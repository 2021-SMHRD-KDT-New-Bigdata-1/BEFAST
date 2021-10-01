package newthang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeamRank")
public class TeamRank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<Link rel=\"stylesheet\" href=\"LGW_HYH/resources/css/TeamList.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:0px auto; width:700px}"); // ��� ���:margin
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=container>");
		out.println("<h2 class=h2>BE FAST</h2>");
		out.println("<div class=row>");

		// out.println("<table class=\"table\">");
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
		out.println("<th class=text-center width=15%>����</th>");
		out.println("<th class=text-center width=40%>����</th>");
		out.println("<th class=text-center width=15%>�ų�����</th>");
		out.println("<th class=text-center width=15%>����</th>");
		out.println("<th class=text-center width=15%>����</th>");
		out.println("</tr>");
		// ���
		MannerDAO dao = new MannerDAO();
		ArrayList<MannerVO> list = dao.MannerListData();
		TeamsssVO vo1;
		
		
		
		for (int i = 0; i < list.size(); i++) {
			if (i < 10) {
				MannerVO vo = list.get(i);
				// ȸ���� ����ŭ �ݺ�
				out.print("<tr>");
				out.print("<td width=15%>" + (i + 1) + "</td>");
				out.print("<td><a href='LGW_HYH/TeamDetail.jsp?team_name=" + list.get(i).getTeam_name() + "'>"
						+ list.get(i).getTeam_name() + "</a></td>");
				out.print("<td width=15%>" + list.get(i).getM_result() + "</td>"); // �ų�����
				out.print("<td width=15%>" + list.get(i).getTotal_score() + "</td>"); //����(��������� ������)
				out.print("<td width=15%>" + list.get(i).getResult_2() + "��"+list.get(i).getResult_1() + 
						"��"+list.get(i).getResult_3() + "��</td>"); //����
				out.print("</tr>");

			}
		}

		out.println("</table>");

		out.println("<table class=\"table\">");
		out.println("<tr>");

		out.println("</tr>");
		out.println("<table>");

		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
