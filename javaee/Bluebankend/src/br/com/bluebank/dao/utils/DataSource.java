package br.com.bluebank.dao.utils;

import java.sql.Connection;

public interface DataSource {
    
    public Connection obterConexao();

}
