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
		out.println(".row {margin:0px auto; width:700px}"); // 가운데 출력:margin
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
//		// btn-sm 크기 / btn-lg : 버튼 커짐 / btn-xs : 버튼 작아짐
//		// success - 녹색
//		out.println("</td>");
//		out.println("</tr>");
		out.println("<table>");

		out.println("<table class=\"table table-hover\">");
		out.println("<tr class=info>"); // 색상 빨간색:danger(table-hover)
		out.println("<th class=text-center width=15%>순위</th>");
		out.println("<th class=text-center width=40%>팀명</th>");
		out.println("<th class=text-center width=15%>매너점수</th>");
		out.println("<th class=text-center width=15%>승점</th>");
		out.println("<th class=text-center width=15%>전적</th>");
		out.println("</tr>");
		// 출력
		MannerDAO dao = new MannerDAO();
		ArrayList<MannerVO> list = dao.MannerListData();
		TeamsssVO vo1;
		
		
		
		for (int i = 0; i < list.size(); i++) {
			if (i < 10) {
				MannerVO vo = list.get(i);
				// 회원의 수만큼 반복
				out.print("<tr>");
				out.print("<td width=15%>" + (i + 1) + "</td>");
				out.print("<td><a href='LGW_HYH/TeamDetail.jsp?team_name=" + list.get(i).getTeam_name() + "'>"
						+ list.get(i).getTeam_name() + "</a></td>");
				out.print("<td width=15%>" + list.get(i).getM_result() + "</td>"); // 매너점수
				out.print("<td width=15%>" + list.get(i).getTotal_score() + "</td>"); //승점(경기결과에서 가져옴)
				out.print("<td width=15%>" + list.get(i).getResult_2() + "승"+list.get(i).getResult_1() + 
						"패"+list.get(i).getResult_3() + "무</td>"); //전적
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
