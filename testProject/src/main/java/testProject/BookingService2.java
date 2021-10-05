package testProject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookingService2")
public class BookingService2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unlikely-arg-type")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");

		// 1. 사용자가 입력한 데이터 가져오기
		String MATCHING_DATE = request.getParameter("MATCHING_DATE");
		String ADDRESS = request.getParameter("ADDRESS");
		String FILED_NAME = request.getParameter("FILED_NAME");
		String GAMES = request.getParameter("GAMES");
		String TIMES = request.getParameter("TIMES");
		String TEAM_NAME2 = null;
		
		System.out.println(MATCHING_DATE);
	
		HttpSession session = request.getSession();
		memberVO vo = (memberVO) session.getAttribute("vo");

		//String TEAM_NAME2 = vo.getTEAM_NAME();
		// 세션에 있는 (로그인되어있는 아이디를 기준) 값을 들고온다.
		String TEAM_NAME = vo.getTEAM_NAME();
		String MEMBER_ID = vo.getMEMBER_ID();

		BookingVO vo2 =new BookingVO();
		vo2.setMATCHING_DATE(MATCHING_DATE);
		vo2.setADDRESS(ADDRESS);
		vo2.setFILED_NAME(FILED_NAME);
		vo2.setGAMES(GAMES);
		vo2.setTIMES(TIMES);
		vo2.setTEAM_NAME(TEAM_NAME);
		vo2.setMEMBER_ID(MEMBER_ID);
		
		BookingDAO2 dao = new BookingDAO2();
		
		ArrayList<BookingVO> al = dao.select();
				
		for(int i=0; i<al.size(); i++) {
			
			if(al.get(i).getMATCHING_DATE().equals(MATCHING_DATE) &&al.get(i).getTIMES().equals(TIMES)&&al.get(i).getFILED_NAME().equals(FILED_NAME)
					&& al.get(i).getFILED_NAME().equals(FILED_NAME)&& al.get(i).getGAMES().equals(GAMES)) 
			//&&al.get(i).getTIMES().equals(TIMES)
			//&& al.get(i).getFILED_NAME().equals(FILED_NAME) 
			//&& al.get(i).getGAMES().equals(GAMES)) 
			{
			
			TEAM_NAME2=al.get(i).getTEAM_NAME();
	
			}
		}
		
		vo2.setTEAM_NAME2(TEAM_NAME2);
		dao.BOOKINGS(vo2);
		
		//vo2.setTEAM_NAME2(TEAM_NAME2);
		//dao.BOOKINGS(vo2);
		int cnt2 = dao.BOOKINGS_RESULT2(MATCHING_DATE, FILED_NAME, GAMES, TIMES, TEAM_NAME, TEAM_NAME);
	
		//dao.MATCHING_IN(FILED_NAME,TEAM_NAME,MATCHING_DATE,GAMES);
		//int cnt = dao.MATCHING_UP(TEAM_NAME, MATCHING_DATE, MEMBER_ID);
		
		response.sendRedirect("Main.jsp");
	
		// TEAM_NAME, MEMBER_ID는 MEMBERVO의 세션값을 들고온 것

	}
}


