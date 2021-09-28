package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {

	   Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	   
	   public void conn() {
		      
		   try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		         
			   String url ="jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			   String dbid ="cgi_6_5";
			   String dbpw ="smhrd5";
			   conn = DriverManager.getConnection(url, dbid, dbpw);
		         
		   }catch(Exception e) {
		         
		   }
		      
		   }
	   
	   public void close() {
		   try {
			   if (rs!=null) {
				   rs.close();
			   }
			   
			   if (psmt!=null) {
				   psmt.close();
				   
			   }if (conn!=null) {
				   conn.close();
			   }
		         
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
	   
	   //예약하기
		public int BOOKINGS(String FIELD_CODE, String MATCHING_DATE, String ADDRESS, String FIELD_NAME, String GAMES) {
			conn();

			int cnt = 0;
			String sql = "insert into BOOKINGS values(?,?,?,?,?)";

			try { 
				psmt = conn.prepareStatement(sql);
				
				
				psmt.setString(1, FIELD_CODE);
				psmt.setString(2, MATCHING_DATE);
				psmt.setString(3, ADDRESS);
				psmt.setString(4, FIELD_NAME);
				psmt.setString(5, GAMES);

				cnt = psmt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				close();
			}

			return cnt;
		}
	
}
