package br.com.bluebank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluebank.dao.utils.DataSource;
import br.com.bluebank.domain.TransferenciaVO;

@Component
public class TransferenciaDAOImpl implements TransferenciaDAO {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ContaDAO contaDAO;
	
	private static final String CODIGO_SQL_ATUALIZAR_SALDO =
			"UPDATE conta SET saldo = ? " + 
			"WHERE idcorrentista = ?  ";
	
	private static final String MENSAGEM_TRANSFERENCIA_NAO_EFETUADA = "Transferência não efetuada!";
	
	public TransferenciaDAOImpl(){
		
	}
	
	
	public void efetuarTransferencia(TransferenciaVO transferenciaVO) throws Exception{
		
	    try {
	    		Connection conn = dataSource.obterConexao();
	    		PreparedStatement stmt = null;
		        stmt = conn.prepareStatement(CODIGO_SQL_ATUALIZAR_SALDO);
		        stmt.setInt(1, transferenciaVO.getIdCorrentistaDestino());
		        stmt.setDouble(2, transferenciaVO.getValor());
		        
		        stmt.executeUpdate();
		        
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		         System.out.println("SQLException: " + ex.getMessage());
		         throw new Exception(MENSAGEM_TRANSFERENCIA_NAO_EFETUADA);
		    } catch (Exception e) {
		    	 e.printStackTrace();
		         System.out.println("SQLException: " + e.getMessage());
		         throw new Exception(MENSAGEM_TRANSFERENCIA_NAO_EFETUADA);
			}	
	
	}

}
