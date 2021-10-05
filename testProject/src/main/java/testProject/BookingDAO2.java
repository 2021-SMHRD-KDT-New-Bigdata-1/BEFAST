package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAO2 {
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
public void BOOKINGS(BookingVO vo) {
		
	System.out.println(vo);

	try {
		conn();
			
		String sql = "insert into BOOKINGS(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME, MEMBER_ID, TEAM_NAME2) values(?,?,?,?,?,?,?,?)";

		psmt = conn.prepareStatement(sql);
			
		psmt.setString(1, vo.getMATCHING_DATE());
		psmt.setString(2, vo.getADDRESS());
		psmt.setString(3, vo.getFILED_NAME());
		psmt.setString(4, vo.getGAMES());
		psmt.setString(5, vo.getTIMES());
		psmt.setString(6, vo.getTEAM_NAME());
		psmt.setString(7, vo.getMEMBER_ID());
		psmt.setString(8, vo.getTEAM_NAME2());

		psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		
}

	// 상대방 팀 등록
	
	
	// 경기결과 등록
	
	// 상대팀 정보 전달
	
	
	// 내 예약정보
	public BookingVO My_booking(String MEMBER_ID) {

		BookingVO Bvo = null;
		conn();

		String sql = "select * from (select*from BOOKINGS order by MATCHING_DATE DESC) where MEMBER_ID=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, MEMBER_ID);

			rs = psmt.executeQuery();

			if (rs.next()) {

				String MATCHING_DATE = rs.getString(1);
				String ADDRESS = rs.getString(2);
				String FILED_NAME = rs.getString(3);
				String GAMES = rs.getString(4);
				String TIMES = rs.getString(5);
				String TEAM_NAME = rs.getString(6);
				String TEAM_NAME2 = rs.getString(7);

				
				Bvo = new BookingVO(MATCHING_DATE, ADDRESS, FILED_NAME,GAMES,TIMES, TEAM_NAME, MEMBER_ID,TEAM_NAME2);
				 
				
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close();
		}
		return Bvo;

	}

	// 예약 업데이트
	

	public ArrayList<BookingVO> select() {
		ArrayList<BookingVO> al = new ArrayList<BookingVO>();
		try {
			conn();

			String sql = "select to_char(MATCHING_DATE,'yyyy-mm-dd'), address, filed_name, games, times, team_name, member_id, team_name2 from bookings";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String MATCHING_DATE = rs.getString(1);
				String ADDRESS = rs.getString(2);
				String FILED_NAME = rs.getString(3);
				String GAMES = rs.getString(4);
				String TIMES = rs.getString(5);
				String TEAM_NAME = rs.getString(6);
				String MEMBER_ID = rs.getString(7);
				String TEAM_NAME2 = rs.getString(8);

				
				BookingVO vo = new BookingVO(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME, MEMBER_ID,TEAM_NAME2);
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
		System.out.println("sql문 출력 : "+choice);
		String sql = "select * from BOOKINGS ";
		String sqlnormal = "";
		if (choice.equals("일반")) {
			sqlnormal = "where GAMES like '%" + choice.trim() + "%'";
		} else if (choice.equals("친선")) {
			sqlnormal = "where GAMES like '%" + choice.trim() + "%'";
		} else if (choice.equals("랭크")) {
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
				String TEAM_NAME = rs.getString(6);
				String MEMBER_ID = rs.getString(7);
				String TEAM_NAME2 = rs.getString(8);
				
				BookingVO vo = new BookingVO(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME, MEMBER_ID, TEAM_NAME2);
				
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
	public int BOOKINGS_RESULT2(String MATCHING_DATE, String FILED_NAME, String GAMES, String TIMES, String TEAM_NAME,String TEAM_NAME2) {
		conn();
		
		
		int cnt = 0;
		String sql = "update BOOKINGS SET TEAM_NAME2 = ? where MATCHING_DATE =? AND FILED_NAME = ? AND GAMES=? AND TIMES=? AND TEAM_NAME != ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, TEAM_NAME2);
			psmt.setString(2, MATCHING_DATE);
			psmt.setString(3, FILED_NAME);
			psmt.setString(4, GAMES);
			psmt.setString(5, TIMES);
			psmt.setString(6, TEAM_NAME);
			

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	public int MATCHING_UP(String TEAM_NAME, String MATCHING_DATE, String FIELD_CODE) {
		conn();
		
		
		int cnt = 0;
		String sql = "update MATCHING SET TEAM_NAME2 = ? where MATCHING_DATE =? AND FIELD_NAME =? AND TEAM_NAME1 != ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, TEAM_NAME);
			psmt.setString(2, MATCHING_DATE);
			psmt.setString(3, FIELD_CODE);
			psmt.setString(4, TEAM_NAME);
			

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	public void MATCHING_IN(String FIELD_NAME, String TEAM_NAME, String MATCHING_DATE, String MATCHING_TYPE) {
		
		

		try {
			conn();
				
			String sql = "insert into MATCHING(MATCHING_CODE,FIELD_NAME,TEAM_NAME1, TEAM_NAME2, MATCHING_DATE,MATCHING_TYPE)"
					+ "values((SELECT NVL(MAX(MATCHING_CODE)+1,1) FROM MATCHING),?,?,NULL,?,?)";

			psmt = conn.prepareStatement(sql);
				
			psmt.setString(1, FIELD_NAME);
			psmt.setString(2, TEAM_NAME);		
			psmt.setString(3, MATCHING_DATE);
			psmt.setString(4, MATCHING_TYPE);
			
			psmt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				close();
			}

			
	}
}


