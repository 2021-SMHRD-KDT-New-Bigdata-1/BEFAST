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
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		// HTML을 브라우저로 전송 시작
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<Link rel=\"stylesheet\" href=\"LGW_HYH/resources/css/football.css\">");
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
		ArrayList<BoardVO> list;

		if (request.getParameter("word") == null) {
			list = dao.boardListData();

		} else {
			String col = request.getParameter("col");
			String word = request.getParameter("word");
			list = dao.BoardSearchData(col, word);
		}
		int size = list.size() + 1;
		int total_page = size / 5 + (size % 5 == 0 ? 0 : 1);
		String page = request.getParameter("page");

		if (page == null) {
			page = "1";
		}
		int cur_page = Integer.parseInt(page);
		System.out.println(cur_page);
		int prev_page = cur_page - 1;
		int next_page = cur_page + 1;

		if (prev_page <= 0) {
			cur_page = 1;
		} else if (cur_page >= total_page) {
			cur_page = total_page;
		}

		for (int i = 5 * (cur_page - 1); i < cur_page * 5; i++) {
			if (i < list.size()) {
				BoardVO vo = list.get(i);
				out.println("<div class=box3>");
				out.println("<div class=box1>");
				out.println("<p class=no>" + vo.getWrite_number() + "번</p>");
				if (vo.getField_code() == 1) {
					out.println("<div class=text-center1 width=10%>" + "랭크전" + "</div>");
				} else if (vo.getField_code() == 2) {
					out.println("<div class=text-center2 width=10%>" + "일반전" + "</div>");
				} else {
					out.println("<div class=text-center3 width=10%>" + "친선전" + "</div>");
				}
				out.println("<p class=member>" + vo.getField_member() + "명</p>");
				out.println("<p class=field_code>" + vo.getP_area() + "</p>");
				out.println("</div>");
				out.println("<p class=subject>" + "<a href=BoardDetail?write_number=" + vo.getWrite_number() + ">"
						+ vo.getWrite_subject() + "</a></p>");
				out.println("<div class=box2>");
				out.println("<p class=name>팀명 : " + vo.getTeam_name() + "</p>");
				out.println("<p class=regdate>" + vo.getWrite_time().toString() + "</p>");
				out.println("<p class=hit>조회수 : " + vo.getHit() + "</p>");
				out.println("</div>");
				out.println("</div>");
			} else {
				break;
			}

		}
		out.println("</table>");

		out.println("<table class=\"table\">");
		out.println("<tr>");

		out.println("<td class=text-left>");
		/* out.println("Search:"); */
		out.println("<form name=\"form1\" method=\"get\" action=\"BoardList\">");
		out.println("<select class=input-sm name=col>");
		out.println("<option value=rname>팀명</option>");
		out.println("<option value=title>제목</option>");
		out.println("<option value=content>내용</option>");
		out.println("</select>");
		out.println("<input type=text size 15 class=input-sm name=word id=search>");
		out.println("<input type=submit value=찾기 class=\"btn btn-sm btn-danger\">");
		out.println("</form>");

		out.println("<td class=text-right>");

		if (prev_page <= 0) {
			prev_page = 1;
		} else if (cur_page >= total_page) {
			next_page = total_page;
		}
		out.println("<a href=?page=" + prev_page + " class=\"btn btn-sm btn-primary\">이전</a>");
		out.println((prev_page) + " page / " + (next_page) + " pages");
		out.println("<a href=?page=" + next_page + " class=\"btn btn-sm btn-primary\">다음</a>");
		out.println("</td>");

		out.println("</tr>");
		out.println("<table>");

		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
