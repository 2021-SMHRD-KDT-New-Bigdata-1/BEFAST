package newthang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 브라우저에서 실행하는 화면:HTML
		// 브라우저에 알림 : HTML문서 전송
		response.setContentType("text/html;charset=EUC-KR");
		// HTML을 브라우저로 전송 시작
		PrintWriter out = response.getWriter();
		// 번호 받는다 ?no=10
		String write_number = request.getParameter("write_number");  
		BoardDAO dao = new BoardDAO(); 
		BoardVO vo = dao.boardDetail(Integer.parseInt(write_number));  
		TeamDAO dao2 = new TeamDAO();
		
		String Team_name = vo.getTeam_name();
		TeamVO vo2 = dao2.Teamlogo(Team_name);
		
		

		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<Link rel=\"stylesheet\" href=\"LGW_HYH/resources/css/football_detail.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:0px auto; width:600px}"); // 가운데 출력:margin
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=newthang>");
		out.println("<h2 class=h2>BE FAST</h2>");
		out.println("</div>");
		out.println("<div class=container>");
		out.println("<h2>" + vo.getWrite_subject() + "</h2>"); //
		out.println("<hr>");
		out.println("<div class=row>");

		// post 보안 / get 다보여짐
		out.println("<div class= profile1 >");
		//al 10번째에.. 어떤 값이 담아져 있는지를 확인해봐야 할거 같네요 그거 그냥 테스트용으로 한번 
		//써본겁니다..ㅠ  저 이미지가 담겨있는 순서로 지정해주셔야 할거같네요 그 지금 글쓴 사람 팀의 이미지를 받아오고 싶은데 어떻게 해야 할지 감이 안잡혀요..
		//ㅇdao  기능 만들으셔야 해요 지금은 전부다 가져와서 al 에 담아주는데 현재 페이지에서는
		//그럴 필요가 없기 때문에 dao 기능 호출할때 현재 로그인한 사람의 팀정보만 가지고 오는 거를 따로 만드셔야 해요.. 네 한 번 해보게
		//습니다....감사합니다
		
		//out.println("<img src='LGW_HYH/"+vo2.getTeam_logo()+"'>");  //여긴가요?넵
		out.println("<div class= tjfaud>");
		out.println("<p id=name>" + vo.getTeam_name() + "</p>");
		out.println("<br>");
		out.println("<span style='font-size:15px'>" + vo.getWrite_time() + "</span>");
		out.println("<span style='font-size:15px'>조회수 : " + vo.getHit() + "</span>");
		out.println("</div>");
		out.println("<div class= profile2 >");
		if (vo.getField_code() == 1) {
			out.println("<div class=text-center1 width=10%>" + "랭크전" + "</div>");
		} else if (vo.getField_code() == 2) {
			out.println("<div class=text-center2 width=10%>" + "일반전" + "</div>");
		} else {
			out.println("<div class=text-center3 width=10%>" + "친선전" + "</div>");
		}
		out.println("<p class=member>" + vo.getField_member() + "명 </p>");

		out.println("</div>");
		out.println("</div>");

		out.println("<div class = content>" + vo.getWrite_content() + "</div>");

		out.println("<div class = ahrfhr>");
		out.println("<a href=# class=\"btn btn-xs btn-success choice\">신청</a>");
		out.println("<script src=\"./YJW_KSJ/JS/jquery-3.6.0.min.js\"></script>");
		out.println("<script>$(function(){" + "$('.choice').on('click',function(){"
				+ "alert('신청이 완료되었습니다.');location.href='BoardList';" + "}) })" + "</script>");
		out.println("<script> </script>");

		out.println(
				"<a href=BoardUpdate.jsp?write_number=" + write_number + " class=\"btn btn-xs btn-success\">수정</a>");

		out.println(
				"<a href=BoardDelete.jsp?write_number=" + write_number + " class=\"btn btn-xs btn-success\">삭제</a>");
		out.println("<a href=BoardList class=\"btn btn-xs btn-success\">목록</a>");
		out.println("</div>");
		out.println("</div>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
