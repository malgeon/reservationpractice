package io.korconut.reservationpractice.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.korconut.reservationpractice.config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class DataSourceTest {
	
	@Autowired
	ApplicationContext context;
	
	DataSource dataSource;
	Connection conn;
	
	@Before
	public void setUp() {
		dataSource = context.getBean(DataSource.class);
		conn = null;
	}
	
	@Test
	public void dataSouceTest() {
		try {
			conn = dataSource.getConnection();
			
			if(conn != null) {
				System.out.println("접속 성공!!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
