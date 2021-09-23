package testProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("euc-kr");
		
		// 1. ����ڰ� �Է��� �� �������� (id, pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		try {
			// ����Ŭ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			
			String sql = "insert into MEMBERS values(?,?)"; // � SQL? insert? update? delete? select?
			// ����ڷκ��� � ���� ������ �𸣱⶧����
			PreparedStatement psmt = conn.prepareStatement(sql);

			// 2_4_1 ù ��° ����ǥ�� �� ��������?
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			// 2_5. sql�� �����ϱ� -> ���� ���ο� ���� ������ �̵���Ű��
			int cnt = psmt.executeUpdate();

			// 2_6 ���๮ó��
			if (cnt > 0) {// �����ϸ� Login��������
				response.sendRedirect("Main.html");
			}

			
			} catch (Exception e) {
				e.printStackTrace();
				// ���� �� ���� �߻� �� �������
				}

	}

}
