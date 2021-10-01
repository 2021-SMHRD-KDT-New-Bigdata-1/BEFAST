package testProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MatchService")
public class MatchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		String MATCHING_DATE = request.getParameter("MATCHING_DATE");
		String ADDRESS = request.getParameter("ADDRESS");
		String FILED_NAME = request.getParameter("FILED_NAME");
		String GAMES = request.getParameter("GAMES");
		String TIMES = request.getParameter("TIMES");
		String TEAM_NAME = request.getParameter("TEAM_NAME");
		
		
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("vo");
		
		
		
		String MEMBER_ID = vo.getMEMBER_ID();
		
		/* System.out.println("테스트용:" +MATCHING_DATE); */
		
		BookingDAO dao = new BookingDAO();
	
		int cnt = dao.BOOKINGS(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME, MEMBER_ID);
		
		if (cnt>0) {
			response.sendRedirect("Main.jsp");
		}
		
	}

}
