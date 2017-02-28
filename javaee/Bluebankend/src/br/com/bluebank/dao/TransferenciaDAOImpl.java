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
			"UPDATE saldo SET valor = ? " + 
			"WHERE idcorrentista_origem = ? AND idcorrentista_destino = ? ";
	
	private static final String MENSAGEM_TRANSFERENCIA_NAO_EFETUADA = "Transferência não efetuada!";
	
	public TransferenciaDAOImpl(){
		
	}
	
	
	public void efetuarTransferencia(TransferenciaVO transferenciaVO) throws Exception{
		
	    try {
	    		Connection conn = dataSource.obterConexao();
	    		PreparedStatement stmt = null;
		        stmt = conn.prepareStatement(CODIGO_SQL_ATUALIZAR_SALDO);
		        stmt.setInt(1, transferenciaVO.getIdCorrentistaOrigem());
		        stmt.setInt(2, transferenciaVO.getIdCorrentistaDestino());
		        stmt.setDouble(3, transferenciaVO.getValor());
		        
		        int retorno = stmt.executeUpdate();
		        
		        if (retorno == 0){
		        	throw new Exception(MENSAGEM_TRANSFERENCIA_NAO_EFETUADA);
		        }
		        
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		         System.out.println("SQLException: " + ex.getMessage());
		         throw ex;
		    } catch (Exception e) {
		    	 e.printStackTrace();
		         System.out.println("SQLException: " + e.getMessage());
		         throw e;
			}	
	
	}

}
