package testProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/BookingService")
public class BookingService extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
      request.setCharacterEncoding("EUC-KR");
      
      // 1. 사용자가 입력한 데이터 가져오기
      //String FIELD_CODE = request.getParameter("FIELD_CODE");
      String MATCHING_DATE = request.getParameter("MATCHING_DATE");
      String ADDRESS = request.getParameter("ADDRESS");
      String FILED_NAME = request.getParameter("FILED_NAME");
      String GAMES = request.getParameter("GAMES");
      String TIMES = request.getParameter("TIMES");
     
      // 멤버 ID, 팀 name ?? 어디에서 받아야 하는가 --> 세션에 저장된 값을 불러온다!
      HttpSession session = request.getSession();
      memberVO vo = (memberVO)session.getAttribute("vo");
      
      // 세션에 있는 (로그인되어있는 아이디를 기준) 값을 들고온다.
      String TEAM_NAME = vo.getTEAM_NAME();
      String MEMBER_ID = vo.getMEMBER_ID();
      
      BookingDAO dao = new BookingDAO();
     
      // TEAM_NAME, MEMBER_ID는 MEMBERVO의 세션값을 들고온 것
      int cnt = dao.BOOKINGS(MATCHING_DATE, ADDRESS, FILED_NAME, GAMES, TIMES, TEAM_NAME, MEMBER_ID);
      
      
      if (cnt>0) {
         response.sendRedirect("Main.jsp");
      }
   }

}