package br.com.bluebank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluebank.dao.utils.DataSource;
import br.com.bluebank.domain.CorrentistaVO;

@Component
public class CorrentistaDAOImpl implements CorrentistaDAO {
	
	@Autowired
	private DataSource dataSource;
	
	private static final String CODIGO_SQL_LISTAR_CORRENTISTAS =
			"SELECT * FROM correntista a, conta b " + 
			"WHERE a.idcorrentista = b.idcorrentista AND " + 
			"a.idcorrentista IN " + 
			"  ( SELECT c.idcorrentista_destino FROM autorizado_transferencia c WHERE c.idcorrentista_origem IN"
			+ "		( SELECT d.idcorrentista FROM correntista d  WHERE cpfCnpj=?  ) "
			+ ") ";
			
	private static final String CODIGO_SQL_OBTER_CORRENTISTA =
			"SELECT * FROM correntista a, conta b " + 
			"WHERE a.idcorrentista = b.idcorrentista AND cpfCnpj = ? ";
	
	public CorrentistaDAOImpl(){
		
	}
	
	public List<CorrentistaVO> listarCorrentistasCadastradosTransferencia(String cpfCnpj){
		List<CorrentistaVO> lista = new ArrayList<CorrentistaVO>();
		
	    try {
	    		Connection conn = dataSource.obterConexao();
	    		PreparedStatement stmt = null;
				ResultSet rs = null;
		        stmt = conn.prepareStatement(CODIGO_SQL_LISTAR_CORRENTISTAS);
		        stmt.setString(1, cpfCnpj);
		        
		        rs = stmt.executeQuery();
		        		
		        while (rs != null && rs.next()){
		        	CorrentistaVO correntista = new CorrentistaVO();
		        	correntista.setIdCorrentista(rs.getInt("idcorrentista"));
		        	correntista.setNome(rs.getString("nome"));
		        	correntista.setCpf(rs.getString("cpfCnpj"));
		        	correntista.setBanco(rs.getInt("banco"));
		        	correntista.setAgencia(rs.getInt("agencia"));
		        	correntista.setAgenciaDac(rs.getInt("dac_agencia"));
		        	correntista.setConta(rs.getInt("conta"));
		        	correntista.setContaDac(rs.getInt("dac_conta"));
		        	lista.add(correntista);
		        }
		        
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		         System.out.println("SQLException: " + ex.getMessage());
		    }	
		
		
		return lista;
	}
	
	public CorrentistaVO obterCorrentista(String cpfCnpj){
		CorrentistaVO correntista = new CorrentistaVO();
		
	    try {
	    		Connection conn = dataSource.obterConexao();
	    		PreparedStatement stmt = null;
				ResultSet rs = null;
		        stmt = conn.prepareStatement(CODIGO_SQL_OBTER_CORRENTISTA);
		        stmt.setString(1, cpfCnpj);
		        
		        rs = stmt.executeQuery();
		        
		        while (rs != null && rs.next()){
		        	correntista.setIdCorrentista(rs.getInt("idcorrentista"));
		        	correntista.setNome(rs.getString("nome"));
		        	correntista.setCpf(rs.getString("cpfCnpj"));
		        	correntista.setBanco(rs.getInt("banco"));
		        	correntista.setAgencia(rs.getInt("agencia"));
		        	correntista.setAgenciaDac(rs.getInt("dac_agencia"));
		        	correntista.setConta(rs.getInt("conta"));
		        	correntista.setConta(rs.getInt("dac_conta"));
		        }
		        
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		         System.out.println("SQLException: " + ex.getMessage());
		    }	
		
		
		return correntista;
	}

}
