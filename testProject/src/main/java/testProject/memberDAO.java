package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
	   
	   // ����ڰ� �Է��� MEMBER_ID �ߺ�üũ
	   public boolean idCheck(String MEMBER_ID) {
		   boolean check = false;
		   conn();
		   String sql = "select MEMBER_ID from MEMBERS where MEMBER_ID = ?";
		   
		   try {
			   
			   psmt = conn.prepareStatement(sql);
			   psmt.setString(1, MEMBER_ID);
			   rs = psmt.executeQuery(); // select�� ����
			   
			   if (rs.next()) { 
				   // ����ڰ� �Է��� �̸����� ���̺� �����ϴ� ���
				   check = true;
			   }else { 
				   // ����ڰ� �Է��� �̸����� ���̺� �������� �ʴ� ���
				   check = false;
			   }
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   close();
		   }
		   
		   return check;
	   }
	   

	   // �α��� ��� ����
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
		              
		                            
		              vo = new memberVO(MEMBER_ID,MEMBER_NAME,MEMBER_PHONE,
		            		  null, MEMBER_BIRTHDATE,GENDER,P_AREA,POSITION);                          
		              //���ο� ������ Ÿ��                                                        
		           }
		                                                                                            
		        }catch(Exception e) {
		           e.printStackTrace();
		        }finally {
		           close();
		        }
		      return vo;
		   }
	   
	   
	   // ������Ʈ ��� ����
	   public int update(String PWD, String MEMBER_PHONE, String P_AREA, String POSITION, String MEMBER_ID) {
		   
		      int cnt = 0;
		      try {
		            conn();
		            
		            String sql = "update MEMBERS set PWD = ? , MEMBER_PHONE = ? , P_AREA = ?, POSITION = ? where MEMBER_ID = ?";
		            // ��й�ȣ, �޴�����ȣ, ��ȣ����, �������� �ٲ۴�!
		            // ��, ���� MEMBER_ID
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
