package newthang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 브라우저에서 실행하는 화면:HTML
		// 브라우저에 알림 : HTML문서 전송
		response.setContentType("text/html;charset=EUC-KR");
		// HTML을 브라우저로 전송 시작
		PrintWriter out = response.getWriter();

		// 번호 받는다 ?no=10
		String write_number = request.getParameter("write_number");
		BoardDAO dao = new BoardDAO();

		BoardVO vo = dao.boardDetail(Integer.parseInt(write_number));

		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<Link rel=\"stylesheet\" href=\"LGW_HYH/resources/css/football_detail.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:0px auto; width:600px}"); // 가운데 출력:margin
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=newthang>");
		out.println("<h2 class=h2>BE FAST</h2>");
		out.println("</div>");
		out.println("<div class=container>");
		out.println("<h2>" + vo.getWrite_subject() + "</h2>");
		out.println("<hr>");
		out.println("<div class=row>");

		// post 보안 / get 다보여짐
		out.println("<div class= profile >");
		out.println("<img src=resources/img/img3.jfif>");
		out.println("<div class= tjfaud>");
		out.println("<p id=name>" + vo.getTeam_name() + "<p>");
		out.println("<br>");
		out.println("<span style='font-size:10px'>" + vo.getWrite_time() + "</span>");
		out.println("<span style='font-size:10px'>조회수 : " + vo.getHit() + "</span>");
		out.println("</div>");
		out.println("<div class= profile2 >");
		if (vo.getField_code() == 1) {
			out.println("<p class=text-center1>" + vo.getField_code() + "</p>");
		} else if (vo.getField_code() == 2) {
			out.println("<div class=text-center2 width=10%>" + vo.getField_code() + "</div>");
		} else {
			out.println("<div class=text-center3 width=60px>" + vo.getField_code() + "</div>");
		}
		out.println("<p class=member>" + vo.getField_member() + "명 </p>");

		out.println("</div>");
		out.println("</div>");

		out.println("<div class = content>" + vo.getWrite_content() + "</div>");

		out.println("<div class = ahrfhr>");
		out.println("<a href=# class=\"btn btn-xs btn-success choice\">신청</a>");
		out.println("<script src=\"resources/js/jquery-3.6.0.min.js\"></script>");
		out.println("<script>$(function(){" + "$('.choice').on('click',function(){"
				+ "alert('신청이 완료되었습니다.');location.href='BoardList';" + "}) })" + "</script>");
		out.println("<script> </script>");

		out.println(
				"<a href=BoardUpdate.jsp?write_number=" + write_number + " class=\"btn btn-xs btn-success\">수정</a>");

		out.println(
				"<a href=BoardDelete.jsp?write_number=" + write_number + " class=\"btn btn-xs btn-success\">삭제</a>");
		out.println("<a href=BoardList class=\"btn btn-xs btn-success\">목록</a>");
		out.println("</div>");
		out.println("</div>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
