package testProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idCheckCon")
public class idCheckCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String data = request.getParameter("MEMBER_ID");
		memberDAO dao = new memberDAO();
		boolean check = dao.idCheck(data);
		// 입력한 값이 존재하면 check -> true
		// 입력한 값이 없으면 check -> false
		
		// 응답
		PrintWriter out = response.getWriter(); // 출력 스트림
		
		out.print(check);
	
	
	}

}
