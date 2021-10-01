package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import newthang.BoardVO;

public class BookingDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void conn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {

		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (psmt != null) {
				psmt.close();

			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 예약하기
	public int BOOKINGS(String MATCHING_DATE, String ADDRESS, String FILED_NAME, String GAMES, String TIMES, String TEAM_NAME,String MEMBER_ID) {
		conn();

		int cnt = 0;
		String sql = "insert into BOOKINGS values(?,?,?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, MATCHING_DATE);
			psmt.setString(2, ADDRESS);
			psmt.setString(3, FILED_NAME);
			psmt.setString(4, GAMES);
			psmt.setString(5, TIMES);
			psmt.setString(6, TEAM_NAME);
			psmt.setString(7, MEMBER_ID);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	
	// 내 예약정보 
	public BookingVO My_booking() { 
	
		BookingVO Bvo = null;
		conn();
	  
		
	  String sql = "select * from BOOKINGS WHERE MEBER_ID=?";
	  
		  try { 
			  psmt = conn.prepareStatement(sql);
			   

			  rs = psmt.executeQuery();
			  
	           if(rs.next()) {        
		            
					String MATCHING_DATE = rs.getString(1);
					String ADDRESS = rs.getString(2);
					String FILED_NAME = rs.getString(3);
					String GAMES = rs.getString(4);
					String TIMES = rs.getString(5);
					
					
					Bvo = new BookingVO(MATCHING_DATE,ADDRESS,FILED_NAME,GAMES,TIMES);
	      }
		  
		  } catch (SQLException e) {
		  
			  e.printStackTrace(); 
		  
		  } finally {
			  close(); 
		  }
		  return Bvo;
		  
		  }
	 

	public ArrayList<BookingVO> select() {
		ArrayList<BookingVO> al = new ArrayList<BookingVO>();
		try {
			conn();

			String sql = "select * from BOOKINGS";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String MATCHING_DATE = rs.getString(1);
				String ADDRESS = rs.getString(2);
				String FILED_NAME = rs.getString(3);
				String GAMES = rs.getString(4);
				String TIMES = rs.getString(5);
				BookingVO vo = new BookingVO(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES);
				al.add(vo);

			}
			// response.sendRedirect("main.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	public ArrayList<BookingVO> bookingsSearch(String choice) {
		ArrayList<BookingVO> boo = new ArrayList<BookingVO>();
		String sql = "select MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES";
		String sqlnormal = "";
		if (choice.equals("normal")) {
			sqlnormal = "where GAMES like '%" + choice.trim() + "%'";
		} else if (choice.equals("friend")) {
			sqlnormal = "where GAMES like '%" + choice.trim() + "%'";
		} else if (choice.equals("rank")) {
			sqlnormal = "where GAMES like '%" + choice.trim() + "%'";
		}
		sql = sql + sqlnormal;
		try {
			// 연결
			conn();

			psmt = conn.prepareStatement(sql);
			// SQL 실행 후 결과값 받
			rs = psmt.executeQuery();
			// 결과값 ArrayList에 첨
			while (rs.next()) {
				String MATCHING_DATE = rs.getString(1);
				String ADDRESS = rs.getString(2);
				String FILED_NAME = rs.getString(3);
				String GAMES = rs.getString(4);
				String TIMES = rs.getString(5);
				BookingVO vo = new BookingVO(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES);
				boo.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return boo;
	}
}
