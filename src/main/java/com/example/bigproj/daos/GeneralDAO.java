package com.example.bigproj.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralDAO {
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GeneralDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}


	public List<String> getAllDBNames() {
		return jdbcTemplate.query("select TABLENAME  from SYS.SYSTABLES", new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
			
		});
	}
}
