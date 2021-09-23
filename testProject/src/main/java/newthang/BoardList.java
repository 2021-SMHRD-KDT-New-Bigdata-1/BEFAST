package newthang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 브라우저에서 실행하는 화면:HTML
		// 브라우저에 알림 : HTML문서 전송
		response.setContentType("text/html;charset=EUC-KR");
		// HTML을 브라우저로 전송 시작
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println(
				"<Link rel=\"stylesheet\" href=\"resources/css/football.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:15px auto; width:700px}"); 
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=newthang>");
		out.println("<h2 class=h2>BE FAST</h2>");
		out.println("</div>");
		out.println("<div class=container>");
		out.println("<div class=row>");
		out.println("<div class=a>");
		out.println("<a href=BoardInsert class=\"btn btn-sm btn-success\">새글</a>");
		out.println("</div>");
		// btn-sm 크기 / btn-lg : 버튼 커짐 / btn-xs : 버튼 작아짐
		// success - 녹색
		// 출력
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.boardListData();
		for (BoardVO vo : list) {
			out.println("<div class=box3>");
			out.println("<div class=box1>");
			out.println("<p class=no>" + vo.getNo() + "번</p>");
			if (vo.getWarrior().equals("랭크전")) {
				out.println("<div class=text-center1 width=10%>"
						+ vo.getWarrior() + "</div>");
			} else if (vo.getWarrior().equals("일반전")) {
				out.println("<div class=text-center2 width=10%>"
						+ vo.getWarrior() + "</div>");
			} else {
				out.println("<div class=text-center3 width=10%>"
						+ vo.getWarrior() + "</div>");
			}
			out.println("<p class=member>" + vo.getMember() + "명</p>");
			out.println("<p class=field_code>" + vo.getField_code() + "</p>");
			out.println("</div>");
			out.println("<p class=subject>" + "<a href=BoardDetail?no=" + vo.getNo() + ">"
					+ vo.getSubject() + "</a></p>");
			out.println("<div class=box2>");
			out.println("<p class=name>팀명 : " + vo.getName() + "</p>");
			out.println("<p class=regdate>" + vo.getRegdate().toString() + "</p>");
			out.println("<p class=hit>조회수 : " + vo.getHit() + "</p>");
			out.println("</div>");
			out.println("</div>");
		}
		out.println("</table>");
		out.println("<hr>");

		out.println("<table class=\"table\">");
		out.println("<tr>");

		out.println("<td class=text-left>");
		out.println("Search:");
		out.println("<select class=input-sm>");
		out.println("<option>이름<option>");
		out.println("<option>제목<option>");
		out.println("<option>내용<option>");
		out.println("</select>");
		out.println("<input type=text size 15 class=input-sm>");
		out.println("<input type=button value=찾기 class=\"btn btn-sm btn-danger\">");
		out.println("</td>");

		out.println("<td class=text-right>");
		// primary -진한 청색
		out.println("<a href=BoardInsert class=\"btn btn-sm btn-primary\">이전</a>");
		out.println("0 page / 0 pages");
		out.println("<a href=BoardInsert class=\"btn btn-sm btn-primary\">다음</a>");
		out.println("</td>");

		out.println("</tr>");
		out.println("<table>");

		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
