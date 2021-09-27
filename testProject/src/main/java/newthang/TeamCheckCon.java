package newthang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testProject.memberDAO;

/**
 * Servlet implementation class TeamCheckCon
 */
@WebServlet("/TeamCheckCon")
public class TeamCheckCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("name");
		memberDAO dao = new memberDAO();
		boolean check = dao.idCheck(data);
		// �Է��� ���� �����ϸ� check -> true
		// �Է��� ���� ������ check -> false
		
		// ����
		PrintWriter out = response.getWriter(); // ��� ��Ʈ��
		
		out.print(check);
	
	}

}
