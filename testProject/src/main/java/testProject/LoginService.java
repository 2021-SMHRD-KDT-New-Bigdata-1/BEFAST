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
			// 오라클 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			
			// 사용자가 입력한 id, pw가 DB에 있는지 확인
			// 없으면 로그인 
			String sql = "select*from MEMBERS where MEMBER_ID = ? and PWD = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, MEMBER_ID);
			psmt.setString(2, PWD);
			
			// DB에 가서 id, pw찾아서 rs에 세트로 넣는다 -> 있으면 true, 없으면 false 
			// 검색된 결과값 ResultSet으로 받을 것
			ResultSet rs = psmt.executeQuery();
			
			// 로그인 DB확인 및 가져오기
			memberDAO dao = new memberDAO();
			memberVO vo = dao.login(MEMBER_ID, PWD);
			
			if (rs.next()) {
				// 만약 값이 있으면 로그인 성공! -> 세션에도 저장!
				System.out.print("1");
				// 세션 선언을 해야한다!!!
				HttpSession session = request.getSession();
				session.setAttribute("vo",vo); // (,사용자가 입력한 id값)
				
				// 서블릿에서는 왜 세션을 사용할 수가 없을까...?
				// JSP는 내장객체가 있기 때문에 session객체를 
				// 선언하지 않아도 바로 사용 가능
				response.sendRedirect("Main.jsp");
			
			}else {
				System.out.print("2");
				// 만약 값이 없으면 로그인 실패!
				response.sendRedirect("Loginform.jsp");
				
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
