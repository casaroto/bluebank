package br.com.bluebank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluebank.dao.utils.DataSource;
import br.com.bluebank.domain.ContaVO;

@Component
public class ContaDAOImpl implements ContaDAO {
	
	@Autowired
	private DataSource dataSource;
			
	private static final String CODIGO_SQL_OBTER_CONTA =
			"SELECT * FROM correntista a, conta b " + 
			"WHERE a.idcorrentista = b.idcorrentista AND cpfCnpj = ? ";
	
	private static final String CODIGO_SQL_OBTER_CONTA_POR_ID =
			"SELECT * FROM conta " + 
			"WHERE idcorrentista = ? ";
	
	public ContaDAOImpl(){
		
	}
	
	public ContaVO obterConta(String cpfCnpj){
		ContaVO conta = new ContaVO();
		
	    try {
	    		Connection conn = dataSource.obterConexao();
	    		PreparedStatement stmt = null;
				ResultSet rs = null;
		        stmt = conn.prepareStatement(CODIGO_SQL_OBTER_CONTA);
		        stmt.setString(1, cpfCnpj);
		        
		        rs = stmt.executeQuery();
		        
		        while (rs != null && rs.next()){
		        	conta.setIdConta(rs.getInt("idConta"));
		        	conta.setBanco(rs.getInt("banco"));
		        	conta.setAgencia(rs.getInt("agencia"));
		        	conta.setAgenciaDac(rs.getInt("dac_agencia"));
		        	conta.setConta(rs.getInt("conta"));
		        	conta.setContaDac(rs.getInt("dac_conta"));
		        	conta.setSaldo(rs.getDouble("saldo"));
		        }
		        
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		         System.out.println("SQLException: " + ex.getMessage());
		    }	
		
		
		return conta;
	}
	
	public ContaVO obterConta(int idConta){
		ContaVO conta = new ContaVO();
		
	    try {
	    		Connection conn = dataSource.obterConexao();
	    		PreparedStatement stmt = null;
				ResultSet rs = null;
		        stmt = conn.prepareStatement(CODIGO_SQL_OBTER_CONTA_POR_ID);
		        stmt.setInt(1, idConta);
		        
		        rs = stmt.executeQuery();
		        
		        while (rs != null && rs.next()){
		        	conta.setIdConta(rs.getInt("idConta"));
		        	conta.setBanco(rs.getInt("banco"));
		        	conta.setAgencia(rs.getInt("agencia"));
		        	conta.setAgenciaDac(rs.getInt("dac_agencia"));
		        	conta.setConta(rs.getInt("conta"));
		        	conta.setContaDac(rs.getInt("dac_conta"));
		        	conta.setSaldo(rs.getDouble("saldo"));
		        }
		        
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		         System.out.println("SQLException: " + ex.getMessage());
		    }	
		
		
		return conta;
	}

}
