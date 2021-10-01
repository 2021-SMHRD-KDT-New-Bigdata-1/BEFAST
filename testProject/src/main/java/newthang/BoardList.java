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
		// ���������� �����ϴ� ȭ��:HTML
		// �������� �˸� : HTML���� ����
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		// HTML�� �������� ���� ����
		
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
		out.println("<a href=BoardInsert class=\"btn btn-sm btn-success\">����</a>");
		out.println("</div>");
		// btn-sm ũ�� / btn-lg : ��ư Ŀ�� / btn-xs : ��ư �۾���
		// success - ���
		// ���
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
				out.println("<p class=no>" + vo.getWrite_number() + "��</p>");
				if (vo.getField_code() == 1) {
					out.println("<div class=text-center1 width=10%>" + "��ũ��" + "</div>");
				} else if (vo.getField_code() == 2) {
					out.println("<div class=text-center2 width=10%>" + "�Ϲ���" + "</div>");
				} else {
					out.println("<div class=text-center3 width=10%>" + "ģ����" + "</div>");
				}
				out.println("<p class=member>" + vo.getField_member() + "��</p>");
				out.println("<p class=field_code>" + vo.getP_area() + "</p>");
				out.println("</div>");
				out.println("<p class=subject>" + "<a href=BoardDetail?write_number=" + vo.getWrite_number() + ">"
						+ vo.getWrite_subject() + "</a></p>");
				out.println("<div class=box2>");
				out.println("<p class=name>���� : " + vo.getTeam_name() + "</p>");
				out.println("<p class=regdate>" + vo.getWrite_time().toString() + "</p>");
				out.println("<p class=hit>��ȸ�� : " + vo.getHit() + "</p>");
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
		out.println("<option value=rname>����</option>");
		out.println("<option value=title>����</option>");
		out.println("<option value=content>����</option>");
		out.println("</select>");
		out.println("<input type=text size 15 class=input-sm name=word id=search>");
		out.println("<input type=submit value=ã�� class=\"btn btn-sm btn-danger\">");
		out.println("</form>");

		out.println("<td class=text-right>");

		if (prev_page <= 0) {
			prev_page = 1;
		} else if (cur_page >= total_page) {
			next_page = total_page;
		}
		out.println("<a href=?page=" + prev_page + " class=\"btn btn-sm btn-primary\">����</a>");
		out.println((prev_page) + " page / " + (next_page) + " pages");
		out.println("<a href=?page=" + next_page + " class=\"btn btn-sm btn-primary\">����</a>");
		out.println("</td>");

		out.println("</tr>");
		out.println("<table>");

		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}
