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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Oracle SQL�� �Ѱ��� �� euc-kr -> UTF-8�� �� ��
		request.setCharacterEncoding("UTF-8");

		// 1. ����ڰ� �Է��� �� �������� (id, pw)
		String MEMBER_ID = request.getParameter("MEMBER_ID");
		String PWD = request.getParameter("PWD");
		//String re_pw = request.getParameter("re_pw");
		String MEMBER_NAME = request.getParameter("MEMBER_NAME");
		String MEMBER_BIRTHDATE = request.getParameter("MEMBER_BIRTHDATE");
		String GENDER = request.getParameter("GENDER");
		String MEMBER_PHONE = request.getParameter("MEMBER_PHONE");
		String P_AREA = request.getParameter("P_AREA");
		String POSITION = request.getParameter("POSITION");

		System.out.println(GENDER);
		
		try {
			// ����Ŭ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);

			String sql = "insert into MEMBERS(MEMBER_ID, PWD, MEMBER_NAME, MEMBER_BIRTHDATE,GENDER, MEMBER_PHONE, P_AREA, POSITION) values(?,?,?,?,?,?,?,?)"; 
			
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, MEMBER_ID);
			psmt.setString(2, PWD);
			//psmt.setString(3, re_pw);
			psmt.setString(3, MEMBER_NAME);
			psmt.setString(4, MEMBER_BIRTHDATE);
			psmt.setString(5, GENDER);
			psmt.setString(6, MEMBER_PHONE);
			psmt.setString(7, P_AREA);
			psmt.setString(8, POSITION);
			
			// 2_5. sql�� �����ϱ� -> ���� ���ο� ���� ������ �̵���Ű��
			int cnt = psmt.executeUpdate();
			System.out.println(cnt);
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
