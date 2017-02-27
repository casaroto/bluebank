package br.com.bluebank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.bluebank.dao.utils.DataSource;
import br.com.bluebank.domain.CorrentistaVO;

@Component
public class CorrentistaDAOImpl implements CorrentistaDAO {
	
	private DataSource dataSource;
	
	public CorrentistaDAOImpl(){
		this.dataSource = new DataSource();
	}
	
	public List<CorrentistaVO> listarCorrentistas(){
		List<CorrentistaVO> lista = new ArrayList<CorrentistaVO>();
		
	    try {
	    		Connection conn = dataSource.obterConexao();
				Statement stmt = null;
				ResultSet rs = null;
		        stmt = conn.createStatement();
		        rs = stmt.executeQuery("SELECT * FROM correntista");
		        
		        while (rs.next()){
		        	CorrentistaVO correntista = new CorrentistaVO();
		        	correntista.setNome(rs.getString("nome"));
		        	correntista.setCpf(rs.getString("cpfCnpj"));
		        	lista.add(correntista);
		        }
		        
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		         System.out.println("SQLException: " + ex.getMessage());
		    }	
		
		
		return lista;
	}

}
