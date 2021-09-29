package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class WaitDAO {
	
	   Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	   
	   //db 연결 메소드
	   public void conn() {
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         String url ="jdbc:oracle:thin:@localhost:1521:xe";
	         String dbid ="cgi_6_5";
	         String dbpw ="smhrd5";
	         conn = DriverManager.getConnection(url, dbid, dbpw);
	         
	      }catch(Exception e) {
	         
	      }
	      
	   }
	   public void close() {
	      try {
	         if(rs!=null) {
	            rs.close();
	         }
	         if(psmt!=null) {
	            psmt.close();
	         }if(conn!=null) {
	            conn.close();
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	

	public ArrayList<BookingDAO> select() {
		
		ArrayList<BookingDAO> al = new ArrayList<BookingDAO>();
        
		try {
            conn();

            String sql = "select * from BOOKINGS";
            psmt = conn.prepareStatement(sql);

            rs = psmt.executeQuery();
            while(rs.next()) {
               String MATCHING_DATE = rs.getString(1);
               String ADDRESS = rs.getString(2);
               String FILED_NAME = rs.getString(3);
               String GAMES = rs.getString(4);
               String TIMES = rs.getString(5);
               
               
               BookingVO vo = new BookingVO(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES);
               al.add(0, null);

            }
            // response.sendRedirect("main.jsp");
         } catch (Exception e) {
            e.printStackTrace();
         }finally {
            close();
         }           

		return al;
	}
	
}
