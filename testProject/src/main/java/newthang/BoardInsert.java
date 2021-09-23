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
    // 폼 작업(화면 출력)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //브라우저에서 실행하는 화면:HTML
          //브라우저에 알림 : HTML문서 전송
          response.setContentType("text/html;charset=EUC-KR");
          //HTML을 브라우저로 전송 시작
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
          out.println("<h2>용병 모집 글쓰기</h2>");
          out.println("<div class=row>");
          
          out.println("<form method=post action=BoardInsert>");
          out.println("<select name=warrior class=select1 >\r\n"
          		+ "                <option value=랭크전>랭크전</option>\r\n"
          		+ "                <option value=일반전>일반전</option>\r\n"
          		+ "                <option value=친선전>친선전</option>\r\n"
          		+ "            </select>");
          out.println("<select class=select1 name=member>\r\n"
          		+ "                <option value=1>1명</option>\r\n"
          		+ "                <option value=2>2명</option>\r\n"
          		+ "                <option value=3>3명</option>\r\n"
          		+ "            </select>\r\n");
          out.println("<select class=select1 name=field_code>\r\n"
          		+ "          		                <option value=광산구>광산구</option>\r\n"
          		+ "          		                <option value=북구>북구</option>\r\n"
          		+ "          		                <option value=서구>서구</option>\r\n"
          		+ "          		                <option value=동구>동구</option>\r\n"
          		+ "          		                <option value=남구>남구</option>\r\n"
          		+ "          		            </select><br>");
          
          // post 보안 / get 다보여짐
          
          out.println("<table class=\"table\">");
          out.println("<tr>");
          out.println("<td width=15% class-right>팀명</td>");
          out.println("<td width=85%>");
          out.println("<input type=text size=15 class=input-sm name=name>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class-right>제목</td>");
          out.println("<td width=85%>");
          out.println("<input type=text size=45 class=input-sm name=subject>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class=text-right>내용</td>");
          out.println("<td width=85%>");
          out.println("<textarea cols=50 rows=10 name=content></textarea>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class-right>시간</td>");
          out.println("<td width=85%>");
          out.println("<input type=text size=45 class=input-sm name=time>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td width=15% class=text-right>비밀번호</td>");
          out.println("<td width=85%>");
          out.println("<input type=password size=10 class=input-sm name=pwd>");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("<tr>");
          out.println("<td colspan=2 class=text-center>");
          out.println("<input type=submit class=\"btn btn-sm btn-danger\" value=글쓰기>");
          out.println("<input type=button class=\"btn btn-sm btn-info\" value=취소 onclick=\"javascript:history.back()\">");
          out.println("</td>");
          out.println("</tr>");
          
          out.println("</table>");
          
          out.println("</form>");
          out.println("</div>");
          out.println("</div>");
          out.println("</body>");
          out.println("</html>");
    }
    // 데이터베이스 연결 => 요청 처리
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
        
        // DAO로 전송 => 오라클 INSERT
        BoardDAO dao=new BoardDAO();
        dao.boardInsert(vo);
        
        // 목록으로 이동    
        response.sendRedirect("BoardList");
    }
}
