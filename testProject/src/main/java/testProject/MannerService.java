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
@WebServlet("/MannerService")
public class MannerService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String MANNERSCORE_CODE = request.getParameter("MANNERSCORE_CODE");
		
		try {
			// ����Ŭ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			// ����ڰ� �Է��� id, pw�� DB�� �ִ��� Ȯ��
			// ������ �α��� 
			String sql = "select*from MANNERSCORES where MANNERSCORE_CODE = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, MANNERSCORE_CODE);
			
			
			// DB�� ���� id, pwã�Ƽ� rs�� ��Ʈ�� �ִ´� -> ������ true, ������ false 
			// �˻��� ����� ResultSet���� ���� ��
			ResultSet rs = psmt.executeQuery();
			
			/* �α��� DBȮ�� �� ��������
			memberDAO dao = new memberDAO();
			memberVO vo = dao.login(MEMBER_ID, PWD);*/
			
			if (rs.next()) {
				// ���� ���� ������ �α��� ����! -> ���ǿ��� ����!
				System.out.print("1");
				// ���� ������ �ؾ��Ѵ�!!!
				HttpSession session = request.getSession();
				session.setAttribute("vo",vo); // (,����ڰ� �Է��� id��)
				
				response.sendRedirect("Main.jsp");
			
			}else {
				System.out.print("2");
				// ���� ���� ������ �α��� ����!
				response.sendRedirect("Loginform.html");
				
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	}

}
