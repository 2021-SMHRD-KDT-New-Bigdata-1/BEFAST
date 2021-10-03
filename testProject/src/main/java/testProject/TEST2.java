package testProject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TEST2")
public class TEST2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();	
		//memberVO vo = (memberVO) session.getAttribute("vo");
		//String TEAM_NAME2 = vo.getTEAM_NAME();
		BookingDAO dao = new BookingDAO();
		ArrayList<BookingVO> al = dao.select();
		HttpSession session = request.getSession();
		memberVO vo = (memberVO) session.getAttribute("vo");

		String TEAM_NAME2 = vo.getTEAM_NAME();
		
		//System.out.println(al.get(0).getGAMES());
		
		int cnt =0;
		
		/*
		 *  
		 * for(int i=0; i<=al.size(); i++) { for(int j=i; j<=al.size(); j++)
		 * { if(
		 * 
		 * al.get(j).getTIMES().equals(al.get(i).getTIMES())) {
		 * System.out.println("ㅂㅏ보"); return;
		 * 
		 * 
		 * } else
		 * 
		 * { System.out.println("바보1"); } } }
		 */
		//if(al.get(10).getTIMES().equals(al.get(11).getTIMES())&&al.get(10).getGAMES().equals(al.get(11).getGAMES())) {
			//System.out.println("바보123");
		//}
				
				for (int i = 0; i < al.size(); i++) {
						for(int j=1; j <al.size(); j++) {
				if (
						  al.get(i).getTIMES().equals(al.get(j).getTIMES()) &&
						  al.get(i).getFILED_NAME().equals(al.get(j).getFILED_NAME()) &&
						  al.get(i).getGAMES().equals(al.get(j).getGAMES())) {
					 
				cnt= dao.BOOKINGS_RESULT2( 
						 al.get(j).getMATCHING_DATE(),
						  al.get(j).getFILED_NAME(), al.get(j).getGAMES(), al.get(j).getTIMES(),
						TEAM_NAME2, al.get(j).getTEAM_NAME());
				
				 return;
				  }
				  
				  } 
						}
				 
				
						if ((cnt > 0)) {
					//System.out.println("출력 : 성공");
					response.sendRedirect("Main.jsp");
				}else {
					response.sendRedirect("Main.jsp");
				//	System.out.println("출력 : 실패");
				}
		
	

	}
	}
