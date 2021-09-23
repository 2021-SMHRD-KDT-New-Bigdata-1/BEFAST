package newthang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert")
public class BoardInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // �� �۾�(ȭ�� ���)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //���������� �����ϴ� ȭ��:HTML
          //�������� �˸� : HTML���� ����
          response.setContentType("text/html;charset=EUC-KR");
          //HTML�� �������� ���� ����
          PrintWriter out=response.getWriter();
          out.println("<html>");
          out.println("<head>");
          out.println("<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");      
          out.println("<Link rel=\"stylesheet\" href=\"football_insert.css\">");      
          out.println("<style type=text/css>");
          out.println(".row {margin:0px auto; width:500px}"); 
          out.println("h2 {text-align:center}");
          out.println("</style>");
          out.println("</head>");
          out.println("<body>");
          out.println("<div class=container>");
          out.println("<h2>�뺴 ���� �۾���</h2>");
          out.println("<div class=row>");
          
          out.println("<form method=post action=BoardInsert>");
          out.println("<select name=warrior class=select1 >\r\n"
          		+ "                <option value=��ũ��>��ũ��</option>\r\n"
          		+ "                <option value=�Ϲ���>�Ϲ���</option>\r\n"
          		+ "                <option value=ģ����>ģ����</option>\r\n"
          		+ "            </select>");
          out.println("<select class=select1 name=member>\r\n"
          		+ "                <option value=1>1��</option>\r\n"
          		+ "                <option value=2>2��</option>\r\n"
          		+ "                <option value=3>3��</option>\r\n"
          		+ "            </select>\r\n");
          out.println("<select class=select1 name=field_code>\r\n"
          		+ "          		                <option value=���걸>���걸</option>\r\n"
          		+ "          		                <option value=�ϱ�>�ϱ�</option>\r\n"
          		+ "          		                <option value=����>����</option>\r\n"
          		+ "          		                <option value=����>����</option>\r\n"
          		+ "          		                <option value=����>����</option>\r\n"
          		+ "          		            </select><br>");
          
          // post ���� / get �ٺ�����
          
          out.println("<table class=\"table\">");
          out.println("<tr>");
          out.println("<td width=15% class-right>����</td>");
          out.println("<td width=85%>");
          out.println("<input type=text size=15 class=input-sm name=name>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class-right>����</td>");
          out.println("<td width=85%>");
          out.println("<input type=text size=45 class=input-sm name=subject>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class=text-right>����</td>");
          out.println("<td width=85%>");
          out.println("<textarea cols=50 rows=10 name=content></textarea>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class-right>�ð�</td>");
          out.println("<td width=85%>");
          out.println("<input type=text size=45 class=input-sm name=time>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class=text-right>��й�ȣ</td>");
          out.println("<td width=85%>");
          out.println("<input type=password size=10 class=input-sm name=pwd>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td colspan=2 class=text-center>");
          out.println("<input type=submit class=\"btn btn-sm btn-danger\" value=�۾���>");
          out.println("<input type=button class=\"btn btn-sm btn-info\" value=��� onclick=\"javascript:history.back()\">");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("</table>");
          
          out.println("</form>");
          out.println("</div>");
          out.println("</div>");
          out.println("</body>");
          out.println("</html>");
    }
    // �����ͺ��̽� ���� => ��û ó��
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("EUC-KR");
        }catch(Exception ex) {}
        int field_code=Integer.parseInt(request.getParameter("warrior"));
        int field_member=Integer.parseInt(request.getParameter("member"));
        String field_area=request.getParameter("field_area");
        int team=request.getParameter("name");
        String write_subject=request.getParameter("subject");
        String write_content=request.getParameter("content");
        String write_pw=request.getParameter("pwd");
    
        BoardVO vo=new BoardVO();
        vo.setField_code(field_code);
        vo.setField_member(field_member);
        vo.setField_area(field_area);
        vo.setTeam(team);
        vo.setWrite_subject(write_subject);
        vo.setWrite_pw(write_pw);
        vo.setWrite_content(write_content);
        
        // DAO�� ���� => ����Ŭ INSERT
        BoardDAO dao=new BoardDAO();
        dao.boardInsert(vo);
        
        // ������� �̵�    
        response.sendRedirect("BoardList");
    }
}
