package testProject;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/BookingService")
public class BookingService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		// 1. 사용자가 입력한 데이터 가져오기
		//String FIELD_CODE = request.getParameter("FIELD_CODE");
		String MATCHING_DATE = request.getParameter("MATCHING_DATE");
		String ADDRESS = request.getParameter("ADDRESS");
		String FIELD_NAME = request.getParameter("FIELD_NAME");
		String GAMES = request.getParameter("GAMES");
		
		BookingDAO dao = new BookingDAO();
		
		int cnt = dao.BOOKINGS(MATCHING_DATE, ADDRESS, FIELD_NAME, GAMES);
		
		if (cnt>0) {
			response.sendRedirect("Main.jsp");
		}
	}

}
