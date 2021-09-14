package testProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinService")
public class joinService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("euc-kr");
		
		// 회원가입!!
		// 1. 사용자가 입력한 값 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String re_pw = request.getParameter("re_pw");
		String name = request.getParameter("name");
		String Bday = request.getParameter("Bday");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		
		// 2. 오라클 연동
		//2_1. ojdbc6.jar파일 가져오기(WEB-INF -> lib) WEB-INF 생성???
		
	
	}

}
