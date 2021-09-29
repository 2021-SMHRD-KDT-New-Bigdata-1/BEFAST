package newthang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeamDetail")
public class TeamDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		// HTML을 브라우저로 전송 시작
		PrintWriter out = response.getWriter();

		
		String team_name = request.getParameter("team_name");
		TeamDAO dao = new TeamDAO();

		TeamVO vo = dao.TeamDetail(team_name);

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
		out.println("<h2>" + vo.getTeam_code() + "</h2>");
		out.println("<hr>");
		out.println("<div class=row>");

		// post 보안 / get 다보여짐
		out.println("<div class= profile >");
		out.println("<img src=resources/img/img3.jfif>");
		out.println("<div class= tjfaud>");
		out.println("<p id=name>" + vo.getTeam_code() + "<p>");
		out.println("<br>");
		out.println("<span style='font-size:10px'>" + vo.getTeam_name() + "</span>");
		out.println("<span style='font-size:10px'>조회수 : " + vo.getTeam_name() + "</span>");
		out.println("</div>");
		out.println("<div class= profile2 >");

		out.println("<div class=text-center3 width=60px>" + vo.getTeam_name() + "</div>");

		out.println("<p class=member>" + vo.getTeam_code() + "명 </p>");

		out.println("</div>");
		out.println("</div>");

		out.println("<div class = content>" + vo.getTeam_name() + "</div>");

		out.println("<div class = ahrfhr>");
		out.println("<a href=# class=\"btn btn-xs btn-success choice\">신청</a>");
		out.println("<script src=\"resources/js/jquery-3.6.0.min.js\"></script>");
		out.println("<script>$(function(){" + "$('.choice').on('click',function(){"
				+ "alert('신청이 완료되었습니다.');location.href='BoardList';" + "}) })" + "</script>");
		out.println("<script> </script>");

		out.println("<a href=BoardUpdate.jsp?write_number=" + team_name + " class=\"btn btn-xs btn-success\">수정</a>");

		out.println("<a href=BoardDelete.jsp?write_number=" + team_name + " class=\"btn btn-xs btn-success\">삭제</a>");
		out.println("<a href=BoardList class=\"btn btn-xs btn-success\">목록</a>");
		out.println("</div>");
		out.println("</div>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		System.out.println(vo.getTeam_name());
	}

}
