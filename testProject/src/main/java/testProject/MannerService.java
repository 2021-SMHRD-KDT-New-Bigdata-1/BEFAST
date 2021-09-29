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
			// 오라클 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			// 사용자가 입력한 id, pw가 DB에 있는지 확인
			// 없으면 로그인 
			String sql = "select*from MANNERSCORES where MANNERSCORE_CODE = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, MANNERSCORE_CODE);
			
			
			// DB에 가서 id, pw찾아서 rs에 세트로 넣는다 -> 있으면 true, 없으면 false 
			// 검색된 결과값 ResultSet으로 받을 것
			ResultSet rs = psmt.executeQuery();
			
			/* 로그인 DB확인 및 가져오기
			memberDAO dao = new memberDAO();
			memberVO vo = dao.login(MEMBER_ID, PWD);*/
			
			if (rs.next()) {
				// 만약 값이 있으면 로그인 성공! -> 세션에도 저장!
				System.out.print("1");
				// 세션 선언을 해야한다!!!
				HttpSession session = request.getSession();
				session.setAttribute("vo",vo); // (,사용자가 입력한 id값)
				
				response.sendRedirect("Main.jsp");
			
			}else {
				System.out.print("2");
				// 만약 값이 없으면 로그인 실패!
				response.sendRedirect("Loginform.html");
				
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	}

}
