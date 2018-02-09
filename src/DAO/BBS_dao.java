package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.BBS_dto;

public class BBS_dao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// Connect MySQL
	public BBS_dao() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbUser = "heo";
			String dbPassword = "wjddns1";
			String dbDriver = "com.mysql.jdbc.Driver";
			
			try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Had next Page
	public boolean nextPage(int page) {
		String SQL = "SELECT * FROM bbs WHERE bbsAvailabe = 1 ORDER BY bbsID DESC Limit ?, 10";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, page * 10);
			ResultSet result = ps.executeQuery();
			if( result.next() ){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// Get BBS List 
	public ArrayList<BBS_dto> getList(int pageNumber) {
		String SQL = "SELECT * FROM bbs WHERE bbsAvailable = 1 ORDER BY bbsID DESC Limit ?, ?";
		try {
			ArrayList<BBS_dto> btos = new ArrayList<BBS_dto>();
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, (pageNumber - 1)*10);
			pstmt.setInt(2, 10);
			
			try {
				rs = pstmt.executeQuery();
				while( rs.next() ) {
					BBS_dto bto = new BBS_dto();
					bto.setBbsID( rs.getInt(1) );
					bto.setBbsTitle( rs.getString(2) );
					bto.setUserID( rs.getString(3) );
					bto.setBbsDate( rs.getString(4) );
					bto.setBbsContent( rs.getString(5) );
					bto.setBbsAvailable( rs.getInt(6) );
					
					btos.add( bto );
				}
			} catch (Exception e ) {
				e.printStackTrace();
			}
			return btos;
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
}
