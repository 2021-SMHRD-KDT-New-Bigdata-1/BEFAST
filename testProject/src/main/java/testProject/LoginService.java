package testProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		try {
			// ����Ŭ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			
			// ����ڰ� �Է��� id, pw�� DB�� �ִ��� Ȯ��
			// ������ �α��� 
			String sql = "select*from MEMBERS where id = ? and pw = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			// DB�� ���� id, pwã�Ƽ� rs�� ��Ʈ�� �ִ´� -> ������ true, ������ false 
			// �˻��� ����� ResultSet���� ���� ��
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				// ���� ���� ������ �α��� ����! -> ���ǿ��� ����!
				
				// ������ ��@_@....? -> ���� ������ �ؾ��Ѵ�!!!
				HttpSession session = request.getSession();
				session.setAttribute("id",id); // (,����ڰ� �Է��� id��)
				
				// ���������� �� ������ ����� ���� ������...?
				// JSP�� ���尴ü�� �ֱ� ������ session��ü�� 
				// �������� �ʾƵ� �ٷ� ��� ����
				response.sendRedirect("LoginS.jsp");
			
			}else {
				// ���� ���� ������ �α��� ����!
				response.sendRedirect("Loginform.html");
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
