package testProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newthang.MannerDAO;

@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cnt=0;
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();		
		String result =request.getParameter("m_result");
		HttpSession session = request.getSession();
		memberVO vo = (memberVO) session.getAttribute("vo");
		
		MannerDAO dao = new MannerDAO();
		if(result.equals("�¸�")) {
			cnt = dao.MATCHINGRE1(vo.getTEAM_NAME());
			System.out.println("���:" +result);
		}else if(result.equals("�й�")) {
			dao.MATCHINGRE3(vo.getTEAM_NAME());
		}else {
			
			dao.MATCHINGRE2(vo.getTEAM_NAME());
		}
		if(cnt>0) {
			System.out.println("������Ʈ ����");
		}else {
			System.out.println("����");
		}
		
	}
			

}
