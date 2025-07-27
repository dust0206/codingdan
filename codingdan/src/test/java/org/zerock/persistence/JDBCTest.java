package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {

	@Test
	public void testConnection() throws Exception {
		
		Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");	// 드라이버 연결
		
		log.info(clz);
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) { 
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "spring", "spring");	// DB 연결
			
			log.info(con);	
			
			con.close();
		}
		long end = System.currentTimeMillis();
		
		log.info("-----------------------");
		log.info(end - start);
				
	}
}
