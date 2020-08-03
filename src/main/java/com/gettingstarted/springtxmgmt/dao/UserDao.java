package com.gettingstarted.springtxmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gettingstarted.springtxmgmt.dto.UserDto;

@Repository
public class UserDao {
	
	private DataSource dataSource;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	public boolean createUser(UserDto user) {
		String createUserSql = "insert into tx_user values(?,?,?)";
		Connection connection = null;
		PreparedStatement pStmt = null;
		boolean isCReated = true;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			pStmt = connection.prepareStatement(createUserSql);
			pStmt.setInt(1,user.getId());
			pStmt.setString(2, user.getName());
			pStmt.setString(3, user.getSurname());
			
			pStmt.executeUpdate();
			
			connection.setAutoCommit(true);
		}catch(Exception e) {
			isCReated = false;
			e.printStackTrace();
			try{
				connection.rollback();
			}catch(Exception re) {
				re.printStackTrace();
			}
		}finally {
			try {
				if(null != pStmt) {
					pStmt.close();
				}
				if(null != connection) {
					connection.close();
				}
			}catch(Exception e) {
				isCReated = false;
				e.printStackTrace();
			}			
		}
		return isCReated;
	}
}
