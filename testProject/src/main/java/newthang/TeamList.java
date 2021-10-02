package newthang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeamList")
public class TeamList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println(
				"<Link rel=\"stylesheet\" href=\"LGW_HYH/resources/css/TeamList.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:0px auto; width:700px}"); // ��� ���:margin
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=container>");
		out.println("<h2 class=h2>BE FAST</h2>");
		out.println("<div class=row>");

		//out.println("<table class=\"table\">");
//		out.println("<tr>");
//		out.println("<td>");
//
//		// btn-sm ũ�� / btn-lg : ��ư Ŀ�� / btn-xs : ��ư �۾���
//		// success - ���
//		out.println("</td>");
//		out.println("</tr>");
		out.println("<table>");

		out.println("<table class=\"table table-hover\">");
		out.println("<tr class=info>"); // ���� ������:danger(table-hover)
		out.println("<th class=text-center width=10%>��ȣ</th>");
		out.println("<th class=text-center width=10%>����</th>");
		out.println("<th class=text-center width=10%>������</th>");
		out.println("<th class=text-center width=10%>�� �����</th>");
		out.println("<th class=text-center width=10%>�� ������</th>");
		out.println("<th class=text-center width=10%>�� ���</th>");
		out.println("</tr>");
		// ���
		TeamDAO dao = new TeamDAO();
		ArrayList<TeamVO> list = dao.TeamboardListData();
		System.out.print("������ ������ :"+list.size());

		if (request.getParameter("word") == null) {
			list = dao.TeamboardListData();
		} else {
			String col = request.getParameter("col");
			String word = request.getParameter("word");
			list = dao.TeamSearchData(col, word);
		}

		int size = list.size() + 1;
		int total_page = size / 15 + (size % 5 == 0 ? 0 : 1);
		System.out.println("������:" + size + "\n��Ż:" + total_page);
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

		for (int i = 15 * (cur_page - 1); i < cur_page * 15; i++) {
			if (i < list.size()) {
				TeamVO vo = list.get(i);
				// ȸ���� ����ŭ �ݺ�
				out.print("<tr>");
				out.print("<td>" + (i + 1) + "</td>");
				out.print("<td><a href='LGW_HYH/TeamDetail.jsp?team_name=" + list.get(i).getTeam_name() + "'>"
						+ list.get(i).getTeam_name() + "</a></td>");
				out.print("<td>" + list.get(i).getTeam_field() + "</td>");
				if (list.get(i).getTeam_level() == "1") {
					out.println("<td>��</td>");
				} else if (list.get(i).getTeam_level() == "2") {
					out.println("<td>��</td>");
				} else {
					out.println("<td>��</td>");
				}
				out.print("<td>" + list.get(i).getTeam_uniform() + "</td>");
				out.print("<td>" + list.get(i).getTeam_member() + "</td>");
				out.print("</tr>");
			} else {
				break;
			}

		}

		out.println("</table>");
//		out.println("<hr>");

		out.println("<table class=\"table\">");
		out.println("<tr>");

		out.println("<td class=text-left>");
//		out.println("Search:");
		out.println("<form name=\"form1\" method=\"get\" action=\"TeamList\">");
		out.println("<select class=input-sm name=col>");
		out.println("<option value=rname>����</option>");
		out.println("<option value=areas>������</option>");
		out.println("</select>");
		out.println("<input type=text size 15 class=input-sm name=word id=search>");
		out.println("<input type=submit value=ã�� class=\"btn btn-sm btn-danger\">");
		out.println("</form>");
		out.println("</td>");

		if (prev_page <= 0) {
			prev_page = 1;
		} else if (cur_page >= total_page) {
			next_page = total_page;
		}
		
		out.println("<td class=text-right>");
		// primary -���� û��
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
