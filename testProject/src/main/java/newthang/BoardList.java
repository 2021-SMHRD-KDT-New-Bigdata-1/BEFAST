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
		response.setContentType("text/html;charset=EUC-KR");
		// HTML�� �������� ���� ����
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
		out.println("<a href=BoardInsert class=\"btn btn-sm btn-success\">����</a>");
		out.println("</div>");
		// btn-sm ũ�� / btn-lg : ��ư Ŀ�� / btn-xs : ��ư �۾���
		// success - ���
		// ���
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.boardListData();
		for (BoardVO vo : list) {
			out.println("<div class=box3>");
			out.println("<div class=box1>");
			out.println("<p class=no>" + vo.getWrite_number() + "��</p>");
			if (vo.getField_code()==1) {
				out.println("<div class=text-center1 width=10%>"
						+ vo.getField_code() + "</div>");
			} else if (vo.getField_code()==2) {
				out.println("<div class=text-center2 width=10%>"
						+ vo.getField_code() + "</div>");
			} else {
				out.println("<div class=text-center3 width=10%>"
						+ vo.getField_code() + "</div>");
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
			
		}
		out.println("</table>");
		out.println("<hr>");

		out.println("<table class=\"table\">");
		out.println("<tr>");

		out.println("<td class=text-left>");
		out.println("Search:");
		out.println("<select class=input-sm>");
		out.println("<option>�̸�<option>");
		out.println("<option>����<option>");
		out.println("<option>����<option>");
		out.println("</select>");
		out.println("<input type=text size 15 class=input-sm>");
		out.println("<input type=button value=ã�� class=\"btn btn-sm btn-danger\">");
		out.println("</td>");

		out.println("<td class=text-right>");
		// primary -���� û��
		out.println("<a href=BoardInsert class=\"btn btn-sm btn-primary\">����</a>");
		out.println("0 page / 0 pages");
		out.println("<a href=BoardInsert class=\"btn btn-sm btn-primary\">����</a>");
		out.println("</td>");

		out.println("</tr>");
		out.println("<table>");

		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
