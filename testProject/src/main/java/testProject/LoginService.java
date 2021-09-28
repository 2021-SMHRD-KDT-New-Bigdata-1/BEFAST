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
		
		request.setCharacterEncoding("euc-kr");
		String MEMBER_ID = request.getParameter("MEMBER_ID");
		String PWD = request.getParameter("PWD");
		System.out.print(MEMBER_ID);
		System.out.print(PWD);
		try {
			// ����Ŭ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			
			// ����ڰ� �Է��� id, pw�� DB�� �ִ��� Ȯ��
			// ������ �α��� 
			String sql = "select*from MEMBERS where MEMBER_ID = ? and PWD = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, MEMBER_ID);
			psmt.setString(2, PWD);
			
			// DB�� ���� id, pwã�Ƽ� rs�� ��Ʈ�� �ִ´� -> ������ true, ������ false 
			// �˻��� ����� ResultSet���� ���� ��
			ResultSet rs = psmt.executeQuery();
			
			// �α��� DBȮ�� �� ��������
			memberDAO dao = new memberDAO();
			memberVO vo = dao.login(MEMBER_ID, PWD);
			
			if (rs.next()) {
				// ���� ���� ������ �α��� ����! -> ���ǿ��� ����!
				System.out.print("1");
				// ���� ������ �ؾ��Ѵ�!!!
				HttpSession session = request.getSession();
				session.setAttribute("vo",vo); // (,����ڰ� �Է��� id��)
				
				// ���������� �� ������ ����� ���� ������...?
				// JSP�� ���尴ü�� �ֱ� ������ session��ü�� 
				// �������� �ʾƵ� �ٷ� ��� ����
				response.sendRedirect("Main.jsp");
			
			}else {
				System.out.print("2");
				// ���� ���� ������ �α��� ����!
				response.sendRedirect("Loginform.jsp");
				
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
