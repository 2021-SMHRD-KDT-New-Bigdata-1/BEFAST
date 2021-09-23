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
			// 오라클 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			
			// 사용자가 입력한 id, pw가 DB에 있는지 확인
			// 없으면 로그인 
			String sql = "select*from MEMBERS where id = ? and pw = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			// DB에 가서 id, pw찾아서 rs에 세트로 넣는다 -> 있으면 true, 없으면 false 
			// 검색된 결과값 ResultSet으로 받을 것
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				// 만약 값이 있으면 로그인 성공! -> 세션에도 저장!
				
				// 세션은 왜@_@....? -> 세션 선언을 해야한다!!!
				HttpSession session = request.getSession();
				session.setAttribute("id",id); // (,사용자가 입력한 id값)
				
				// 서블릿에서는 왜 세션을 사용할 수가 없을까...?
				// JSP는 내장객체가 있기 때문에 session객체를 
				// 선언하지 않아도 바로 사용 가능
				response.sendRedirect("LoginS.jsp");
			
			}else {
				// 만약 값이 없으면 로그인 실패!
				response.sendRedirect("Loginform.html");
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
