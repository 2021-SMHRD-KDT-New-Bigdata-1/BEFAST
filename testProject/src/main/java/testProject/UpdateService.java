package testProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testProject.memberVO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 입력한 값 받아오기
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("vo");
		String MEMBER_ID = vo.getMEMBER_ID();
		
		
		String PWD = request.getParameter("PWD");
		String MEMBER_PHONE = request.getParameter("MEMBER_PHONE");
		String P_AREA = request.getParameter("P_AREA");
		String POSITION = request.getParameter("POSITION");
		String TEAM_NAME = request.getParameter("TEAM_NAME");
		
		
		String MEMBER_NAME = request.getParameter("MEMBER_NAME");
		String MEMBER_BIRTHDATE = request.getParameter("MEMBER_BIRTHDATE");
		String GENDER = request.getParameter("GENDER");
		
		
		
		
		
		
		memberDAO dao = new memberDAO();
		
		int cnt = dao.update(PWD, MEMBER_PHONE, P_AREA, POSITION, TEAM_NAME, MEMBER_ID);
		
		if(cnt>0) {
	          memberVO vo2 = new memberVO(MEMBER_ID,PWD,MEMBER_NAME,MEMBER_PHONE,MEMBER_BIRTHDATE,GENDER,P_AREA,POSITION,TEAM_NAME,null);
	          session.setAttribute("vo", vo2);
	          response.sendRedirect("Main.jsp");   
	       
	       }else {
	          System.out.println("수정 실패");
	          response.sendRedirect("Main.jsp");
	       }
		

	}

}
