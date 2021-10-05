package testProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TEST3")
public class TEST3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		String MATCHING_DATE = request.getParameter("MATCHING_DATE");	
		String ADDRESS = request.getParameter("ADDRESS");
		String FILED_NAME = request.getParameter("FILED_NAME");
		String TIMES = request.getParameter("TIMES");
		String GAMES = request.getParameter("GAMES");
		String TEAM_NAME = request.getParameter("TEAM_NAME");
		
		System.out.println("���� :" + MATCHING_DATE);
		HttpSession session = request.getSession();
		
		memberVO vo = (memberVO) session.getAttribute("vo");
		String TEAM_NAME3 = vo.getTEAM_NAME();
		String MEMBER_ID = vo.getMEMBER_ID();
	    
		BookingVO vo2 = new BookingVO();
		BookingDAO2 dao = new BookingDAO2();
		vo2.setMATCHING_DATE(MATCHING_DATE);
		vo2.setADDRESS(ADDRESS);
		vo2.setFILED_NAME(FILED_NAME);
		vo2.setTIMES(TIMES);
		vo2.setGAMES(GAMES);
		vo2.setTEAM_NAME(TEAM_NAME3);
		vo2.setMEMBER_ID(MEMBER_ID);
		vo2.setTEAM_NAME2(TEAM_NAME);	

		
		
		dao.BOOKINGS(vo2);
		int cnt2 = dao.BOOKINGS_RESULT2(MATCHING_DATE, FILED_NAME, GAMES, TIMES, TEAM_NAME3, TEAM_NAME);
	  			
		// ���ǿ� �ִ� (�α��εǾ��ִ� ���̵� ����) ���� ���´�.
		

		// BookingDAO dao = new BookingDAO();
		// int cnt1 = dao.BOOKINGS_RESULT2(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME2);

		
		
/*		<script>
			alert("�� ��Ī�� �Ϸ�Ǿ����ϴ�.");
			location.href ="ShowPage2.jsp"
		</script>*/

	
	}

}
