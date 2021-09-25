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
		
		// Oracle SQL로 넘겨줄 때 euc-kr -> UTF-8로 할 것
		request.setCharacterEncoding("UTF-8");

		// 1. 사용자가 입력한 값 가져오기 (id, pw)
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
			// 오라클 접속
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
			
			// 2_5. sql문 실행하기 -> 성공 여부에 따라 페이지 이동시키기
			int cnt = psmt.executeUpdate();
			System.out.println(cnt);
			// 2_6 실행문처리
			if (cnt > 0) {// 성공하면 Login페이지로
				response.sendRedirect("Main.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// 실행 후 오류 발생 시 에러출력
		}
		
	}

}
