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
		String no = request.getParameter("no");
		BoardDAO dao = new BoardDAO();

		BoardVO vo = dao.boardDetail(Integer.parseInt(no));

		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<Link rel=\"stylesheet\" href=\"resources/css/football_detail.css\">");
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
		out.println("<h2>" + vo.getSubject() + "</h2>");
		out.println("<hr>");
		out.println("<div class=row>");

		// post 보안 / get 다보여짐
		out.println("<table class=\"table\">");
		out.println("<tr>");
		out.println("<td width=25% class=text-center>" + vo.getName() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=25% class=text-center>" + vo.getName() + "</td>");
		out.println("<td width=25% class=text-center>조회수 : " + vo.getHit() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan=4 height=200 valign=top>" + vo.getContent() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan=4 class=text-right>");
		out.println("<a href=# class=\"btn btn-xs btn-success choice\">신청</a>");
		out.println("<script src=\"resources/js/jquery-3.6.0.min.js\"></script>");
		out.println("<script>$(function(){" + "$('.choice').on('click',function(){"
				+ "alert('신청이 완료되었습니다.');location.href='BoardList';" + "}) })" + "</script>");
		out.println("<script> </script>");

		out.println("<a href=# class=\"btn btn-xs btn-success\">수정</a>");
		out.println("<a href=# class=\"btn btn-xs btn-success\">삭제</a>");
		out.println("<a href=BoardList class=\"btn btn-xs btn-success\">목록</a>");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
