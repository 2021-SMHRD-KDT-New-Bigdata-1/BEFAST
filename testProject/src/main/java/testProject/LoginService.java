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
		String MEMBER_NAME = request.getParameter("MEMBER_NAME");
		String MEMBER_PHONE = request.getParameter("MEMBER_PHONE");
		String GENDER = request.getParameter("MEMBER_BIRTHDATE");
		String P_AREA = request.getParameter("P_AREA");
		String POSITION = request.getParameter("POSITION");
		String TEAM_NAME = request.getParameter("TEAM_NAME");
		String TEAM_CODE =request.getParameter("TEAM_CODE");
		System.out.print(MEMBER_ID);
		System.out.print(PWD);
		System.out.print(TEAM_NAME);
		
	      // DAO 객체 생성
		
	      memberDAO dao = new memberDAO();
	      memberVO vo = dao.login(MEMBER_ID, PWD);
	      
	      if(vo!=null) {
	          HttpSession session   = request.getSession();
	          session.setAttribute("vo", vo);
	          
	          response.sendRedirect("Main.jsp");      
	          }else {
	             System.out.println("로그인 실패");
	             response.sendRedirect("Loginform.jsp");
	          }
	
	
	}

}
