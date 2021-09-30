package testProject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.sql.DATE;




public class memberDAO {

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
	   
	   // 회원가입
	   public int join(String MEMBER_ID, String PWD, String MEMBER_NAME, String MEMBER_PHONE, 
			   String MEMBER_BIRTHDATE, String GENDER, String P_AREA, String POSITION) {   // -> 테이블에 값(사용자가 입력한 값)이 삽입
		      int cnt =0;
		      try {
		            conn();
		                             
		            String sql = "insert into MEMBERS values(?,?,?,?,?,?,?,?)";
		            psmt = conn.prepareStatement(sql);
		            psmt.setString(1, MEMBER_ID);
		            psmt.setString(2, PWD);
		            psmt.setString(3, MEMBER_NAME);
		            psmt.setString(4, MEMBER_PHONE);
		            psmt.setString(5, MEMBER_BIRTHDATE);
		            psmt.setString(6, GENDER);
		            psmt.setString(7, P_AREA);
		            psmt.setString(8, POSITION);
		                        
		            cnt = psmt.executeUpdate();
		                                    
		         }catch(Exception e) {
		            e.printStackTrace();
		         }finally {
		            close();
		         }
		      return cnt;      
		   }
	   
	   // 사용자가 입력한 MEMBER_ID 중복체크
	   public boolean idCheck(String MEMBER_ID) {
		   boolean check = false;
		   conn();
		   String sql = "select MEMBER_ID from MEMBERS where MEMBER_ID = ?";
		   
		   try {
			   
			   psmt = conn.prepareStatement(sql);
			   psmt.setString(1, MEMBER_ID);
			   rs = psmt.executeQuery(); // select문 쿼리
			   
			   if (rs.next()) { 
				   // 사용자가 입력한 이메일이 테이블에 존재하는 경우
				   check = true;
			   }else { 
				   // 사용자가 입력한 이메일이 테이블에 존재하지 않는 경우
				   check = false;
			   }
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   close();
		   }
		   
		   return check;
	   }
	   

	   // 로그인 기능 구현
	   public memberVO login(String MEMBER_ID, String PWD) {
		      memberVO vo = null;
		      try {
		           conn();
		                                          
		           String sql = "select * from MEMBERS where MEMBER_ID =? and PWD=?";
		           psmt = conn.prepareStatement(sql);
		           psmt.setString(1, MEMBER_ID);
		           psmt.setString(2, PWD);
		           rs = psmt.executeQuery();
		           
		           if(rs.next()) {        
		           
		              String MEMBER_NAME = rs.getString(3);
		              String MEMBER_PHONE = rs.getString(4);
		              String MEMBER_BIRTHDATE = rs.getString(5);
		              String GENDER = rs.getString(6);
		              String P_AREA = rs.getString(7);
		              String POSITION = rs.getString(8);
		                            
		              vo = new memberVO(MEMBER_NAME, MEMBER_PHONE, MEMBER_BIRTHDATE,GENDER,null,null,P_AREA,POSITION);                          
		       
		              //새로운 데이터 타입                                                        
		           }
		                                                                                            
		        }catch(Exception e) {
		           e.printStackTrace();
		        }finally {
		           close();
		        }
		      return vo;
		   }

	  
	   
	   // 업데이트 기능 구현
	   public int update(String PWD, String MEMBER_PHONE, String P_AREA, String POSITION, String MEMBER_ID) {
		   
		      int cnt = 0;
		      try {
		            conn();
		            
		            String sql = "update MEMBERS set PWD = ? , MEMBER_PHONE = ? , P_AREA = ?, POSITION = ? where MEMBER_ID = ?";
		            // 비밀번호, 휴대폰번호, 선호지역, 포지션을 바꾼다!
		            // 단, 조건 MEMBER_ID
		            PreparedStatement psmt = conn.prepareStatement(sql);
		            psmt.setString(1, PWD);
		            psmt.setString(2, MEMBER_PHONE);
		            psmt.setString(3, P_AREA);
		            psmt.setString(4, POSITION);
		            psmt.setString(5, MEMBER_ID);
		                                    
		            cnt = psmt.executeUpdate();            
		            
		         }catch(Exception e) {
		            e.printStackTrace();
		         }finally {
		            close();
		         }
		      return cnt;
		   }
	   
		   
	   }
	

