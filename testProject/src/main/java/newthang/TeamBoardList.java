package newthang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeamBoardList")
public class TeamBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		out.println("<html>");
	      out.println("<head>");
	      out.println("<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");      
	      out.println("<style type=text/css>");
	      out.println(".row {margin:0px auto; width:700px}"); //가운데 출력:margin
	      out.println("h2 {text-align:center}");
	      out.println("</style>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<div class=container>");
	      out.println("<h2>팀 찾기</h2>");
	      out.println("<div class=row>");
	      
	      out.println("<table class=\"table\">");
	      out.println("<tr>");
	      out.println("<td>");
	      
	      //btn-sm 크기 / btn-lg : 버튼 커짐 / btn-xs : 버튼 작아짐 
	      // success - 녹색
	      out.println("</td>");
	      out.println("</tr>");
	      out.println("<table>");
	      
	      out.println("<table class=\"table table-hover\">");
	      out.println("<tr class=info>"); //색상 빨간색:danger(table-hover)
	      out.println("<th class=text-center width=10%>번호</th>");
	      out.println("<th class=text-center width=10%>팀명</th>");
	      out.println("<th class=text-center width=45%>연고지</th>");
	      out.println("<th class=text-center width=15%>팀 경쟁력</th>");
	      out.println("<th class=text-center width=20%>팀 유니폼</th>");
	      out.println("<th class=text-center width=10%>팀 멤버</th>");
	      out.println("</tr>");
	      //출력
	     TeamVO vo =new TeamVO();
	     TeamDAO dao=new TeamDAO();
	     ArrayList<TeamVO> list = dao.TeamboardListData();
	     System.out.print(list.size());
	      
	     for(int i=0; i<list.size();i++){//회원의 수만큼 반복
       		out.print("<tr>");
       		out.print("<td>"+(i+1)+"</td>");
       		out.print("<td>"+list.get(i).getTeam_name()+"</td>");
       		out.print("<td>"+list.get(i).getTeam_field()+"</td>");
       		out.print("<td>"+list.get(i).getTeam_level()+"</td>");
       		out.print("<td>"+list.get(i).getTeam_uniform()+"</td>");
       		out.print("<td>"+list.get(i).getTeam_member()+"</td>");          		
       		out.print("</tr>");
       	}
	      
	      out.println("</table>");
	      out.println("<hr>");
	      
	      out.println("<table class=\"table\">");
	      out.println("<tr>");
	      
	      out.println("<td class=text-left>");
	      out.println("Search:");
	      out.println("<select class=input-sm>");
	      out.println("<option>팀명<option>");
	      out.println("<option>연고지<option>");
	      out.println("</select>");
	      out.println("<input type=text size 15 class=input-sm>");
	      out.println("<input type=button value=찾기 class=\"btn btn-sm btn-danger\">");
	      out.println("</td>");
	      
	      out.println("<td class=text-right>");
	      //primary -진한 청색
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


