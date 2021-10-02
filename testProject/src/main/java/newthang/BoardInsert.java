package newthang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testProject.memberVO;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert")
public class BoardInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   // 폼 작업(화면 출력)
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 브라우저에서 실행하는 화면:HTML
      // 브라우저에 알림 : HTML문서 전송
      response.setContentType("text/html;charset=EUC-KR");
      // HTML을 브라우저로 전송 시작
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<head>");
      out.println(
            "<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
      out.println("<Link rel=\"stylesheet\" href=\"LGW_HYH/resources/css/football_insert.css\">");
      out.println("<style type=text/css>");
      out.println(".row {margin:0px auto; width:500px}");
      out.println("h2 {text-align:center}");
      out.println("</style>");
      out.println("</head>");
      out.println("<body>");
      out.println("<div class=newthang>");
      out.println("<h2 class=h2>BE FAST</h2>");
      out.println("</div>");
      out.println("<div class=container>");
      out.println("<h3 class=h3>용병 모집</h3>");
      out.println("<div class=row>");

      out.println("<form method=post action=BoardInsert>");
      out.println("<div class=select_1>");
      out.println("<select name=warrior class=select1 >\r\n" + "<option value=1>랭크전</option>\r\n"
            + "                <option value=2>일반전</option>\r\n"
            + "                <option value=3>친선전</option></select>");
      out.println("<select class=select1 name=member>\r\n" + "<option value=1>1명</option>\r\n"
            + "                <option value=2>2명</option>\r\n" + "<option value=3>3명</option></select>\r\n");
      out.println("<select class=select1 name=field_code>\r\n"
            + "                                <option value=광산구>광산구</option>\r\n"
            + "                                <option value=북구>북구</option>\r\n"
            + "                                <option value=서구>서구</option>\r\n"
            + "                                <option value=동구>동구</option>\r\n"
            + "                                <option value=남구>남구</option>\r\n"
            + "                            </select><br>");
      out.println("</div>");

      // post 보안 / get 다보여짐

      out.println("<input type=\"text\" class=\"title\" name=\"subject\" placeholder=\"제목을 입력해주세요.\"><br>");

      out.println(
            "<textarea cols=50 rows=10 name=\"content\" class=\"text_area\" placeholder=\"내용을 입력해주세요.\"></textarea>");

      out.println("<input type=text class=matching_time name=time placeholder='경기시간을 입력하세요'><br>");

      out.println("<input type=password class=pw name=pwd placeholder=비밀번호입력><br>");

      out.println("<div class=button text-align=center>");
      out.println("<input type=submit class=\"btn btn-sm btn-danger\" value=글쓰기>");
      out.println("<input type=button class=\"btn btn-sm btn-info\" value=취소 onclick=\"javascript:history.back()\">");
      out.println("</div>");

      out.println("</form>");
      out.println("</div>");
      out.println("</div>");
      out.println("</body>");
      out.println("</html>");
   }

   // 데이터베이스 연결 => 요청 처리
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      try {
         request.setCharacterEncoding("EUC-KR");
      } catch (Exception ex) {
      }
      int field_code = Integer.parseInt(request.getParameter("warrior"));
      int field_member = Integer.parseInt(request.getParameter("member"));
      String p_area = request.getParameter("field_code");
      String write_subject = request.getParameter("subject");
      String write_content = request.getParameter("content");
      String matching_time = request.getParameter("time");
      String write_pw = request.getParameter("pwd");
      
      HttpSession session = request.getSession();
      memberVO vo2 = (memberVO)session.getAttribute("vo");
      String team_name = vo2.getTEAM_NAME();
      BoardVO vo = new BoardVO();
      vo.setField_code(field_code);
      vo.setField_member(field_member);
      vo.setP_area(p_area);
      vo.setWrite_subject(write_subject);
      vo.setWrite_content(write_content);
      vo.setMatching_time(matching_time);
      vo.setWrite_pw(write_pw);
      vo.setTeam_name(team_name);

      // DAO로 전송 => 오라클 INSERT
      BoardDAO dao = new BoardDAO();
      dao.boardInsert(vo);

      // 목록으로 이동
      response.sendRedirect("BoardList");
   }
}