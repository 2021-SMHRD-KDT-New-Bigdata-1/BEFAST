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
		System.out.println("사이즈:"+size+"\n토탈:"+total_page);
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
		out.println("Search:");
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

		//일단 페이징은 동작하고 있는데
		// 요부분에 조건이 안걸려 있어서 무조건 새로운 페이지가 생기는거 같네요
		// 그럼 어떻게 해야 하나요?? 지금보시면 prev_page랑 next_page는
		// 조정이 안된값들이에요
		// 위에서 조건검사하실때 얘들도 같이 조정을 해주시거나
		// 여기에 if조건 거셔서 next가 total넘어갔을때 따로 조건을 빼주시거나
		// 해주셔야할거 같네요 그러면 위에 있는 코드 복사해서 가져와도 되나요?
		// 여기에 맞춰서 바꿔주셔야겠죠? 여기에 맞출려면 저 감이 안 잡혀서 그러는데
		// 혹시 이렇게 하고, 동작하는 거 봐서 고쳐야 하나유,,?
		// 지금 페이지가 계속 늘어나는 이유가 nex_page랑 prev_page가 조절이 안되서에요
		// next_page는 page 요청값에 따라서 계속 늘어나요
		// page=3일경우 next_page는 4가 되는데
		// 여기에서 그 조절없이 next_page는 4가 되고 prev페이지는 2가되고
		// 요거 조절을 해주시거나 아니면 아래 코드를 cur_page기준으로 다시 짜주시거나
		// 대충 2가지 방법이 있는거 같네요
		// 알겠습니다! 그 선생님 게시글 거꾸로 보이는건 get.
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
