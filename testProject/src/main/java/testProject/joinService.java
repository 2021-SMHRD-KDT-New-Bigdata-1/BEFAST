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
		// �ѱ� ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		// ȸ������!!
		// 1. ����ڰ� �Է��� �� ��������
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String re_pw = request.getParameter("re_pw");
		String name = request.getParameter("name");
		String Bday = request.getParameter("Bday");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		
		// 2. ����Ŭ ����
		//2_1. ojdbc6.jar���� ��������(WEB-INF -> lib) WEB-INF ����???
		
	
	}

}
