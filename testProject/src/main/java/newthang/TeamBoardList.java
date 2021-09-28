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
	      out.println(".row {margin:0px auto; width:700px}"); //��� ���:margin
	      out.println("h2 {text-align:center}");
	      out.println("</style>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<div class=container>");
	      out.println("<h2>�� ã��</h2>");
	      out.println("<div class=row>");
	      
	      out.println("<table class=\"table\">");
	      out.println("<tr>");
	      out.println("<td>");
	      
	      //btn-sm ũ�� / btn-lg : ��ư Ŀ�� / btn-xs : ��ư �۾��� 
	      // success - ���
	      out.println("</td>");
	      out.println("</tr>");
	      out.println("<table>");
	      
	      out.println("<table class=\"table table-hover\">");
	      out.println("<tr class=info>"); //���� ������:danger(table-hover)
	      out.println("<th class=text-center width=10%>��ȣ</th>");
	      out.println("<th class=text-center width=10%>����</th>");
	      out.println("<th class=text-center width=45%>������</th>");
	      out.println("<th class=text-center width=15%>�� �����</th>");
	      out.println("<th class=text-center width=20%>�� ������</th>");
	      out.println("<th class=text-center width=10%>�� ���</th>");
	      out.println("</tr>");
	      //���
	     TeamVO vo =new TeamVO();
	     TeamDAO dao=new TeamDAO();
	     ArrayList<TeamVO> list = dao.TeamboardListData();
	     System.out.print(list.size());
	      
	     for(int i=0; i<list.size();i++){//ȸ���� ����ŭ �ݺ�
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
	      out.println("<option>����<option>");
	      out.println("<option>������<option>");
	      out.println("</select>");
	      out.println("<input type=text size 15 class=input-sm>");
	      out.println("<input type=button value=ã�� class=\"btn btn-sm btn-danger\">");
	      out.println("</td>");
	      
	      out.println("<td class=text-right>");
	      //primary -���� û��
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


