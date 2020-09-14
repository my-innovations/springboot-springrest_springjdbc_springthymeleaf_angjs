package com.springboot.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate=jdbcTemplate;
		//System.out.println("dataSource="+dataSource);	
	}
	
	@Override
	public void seeConsoleForDataSourceDetails() {
		System.out.println("dataSource="+dataSource);	
	}
	//use the above dataSource and make some CRUD operation using jdbcTemplate on diff DB based on profile activated.
}


