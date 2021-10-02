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
		// ���������� �����ϴ� ȭ��:HTML
		// �������� �˸� : HTML���� ����
		response.setContentType("text/html;charset=EUC-KR");
		// HTML�� �������� ���� ����
		PrintWriter out = response.getWriter();
		// ��ȣ �޴´� ?no=10
		String write_number = request.getParameter("write_number");  
		BoardDAO dao = new BoardDAO(); 
		BoardVO vo = dao.boardDetail(Integer.parseInt(write_number));  
		TeamDAO dao2 = new TeamDAO();
		
		String Team_name = vo.getTeam_name();
		TeamVO vo2 = dao2.Teamlogo(Team_name);
		
		

		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<Link rel=\"stylesheet\" href=\"LGW_HYH/resources/css/football_detail.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:0px auto; width:600px}"); // ��� ���:margin
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=newthang>");
		out.println("<h2 class=h2>BE FAST</h2>");
		out.println("</div>");
		out.println("<div class=container>");
		out.println("<h2>" + vo.getWrite_subject() + "</h2>"); //
		out.println("<hr>");
		out.println("<div class=row>");

		// post ���� / get �ٺ�����
		out.println("<div class= profile1 >");
		//al 10��°��.. � ���� ����� �ִ����� Ȯ���غ��� �Ұ� ���׿� �װ� �׳� �׽�Ʈ������ �ѹ� 
		//�ẻ�̴ϴ�..��  �� �̹����� ����ִ� ������ �������ּž� �ҰŰ��׿� �� ���� �۾� ��� ���� �̹����� �޾ƿ��� ������ ��� �ؾ� ���� ���� ��������..
		//��dao  ��� �������ž� �ؿ� ������ ���δ� �����ͼ� al �� ����ִµ� ���� ������������
		//�׷� �ʿ䰡 ���� ������ dao ��� ȣ���Ҷ� ���� �α����� ����� �������� ������ ���� �Ÿ� ���� ����ž� �ؿ�.. �� �� �� �غ���
		//���ϴ�....�����մϴ�
		
		//out.println("<img src='LGW_HYH/"+vo2.getTeam_logo()+"'>");  //���䰡��?��
		out.println("<div class= tjfaud>");
		out.println("<p id=name>" + vo.getTeam_name() + "</p>");
		out.println("<br>");
		out.println("<span style='font-size:15px'>" + vo.getWrite_time() + "</span>");
		out.println("<span style='font-size:15px'>��ȸ�� : " + vo.getHit() + "</span>");
		out.println("</div>");
		out.println("<div class= profile2 >");
		if (vo.getField_code() == 1) {
			out.println("<div class=text-center1 width=10%>" + "��ũ��" + "</div>");
		} else if (vo.getField_code() == 2) {
			out.println("<div class=text-center2 width=10%>" + "�Ϲ���" + "</div>");
		} else {
			out.println("<div class=text-center3 width=10%>" + "ģ����" + "</div>");
		}
		out.println("<p class=member>" + vo.getField_member() + "�� </p>");

		out.println("</div>");
		out.println("</div>");

		out.println("<div class = content>" + vo.getWrite_content() + "</div>");

		out.println("<div class = ahrfhr>");
		out.println("<a href=# class=\"btn btn-xs btn-success choice\">��û</a>");
		out.println("<script src=\"./YJW_KSJ/JS/jquery-3.6.0.min.js\"></script>");
		out.println("<script>$(function(){" + "$('.choice').on('click',function(){"
				+ "alert('��û�� �Ϸ�Ǿ����ϴ�.');location.href='BoardList';" + "}) })" + "</script>");
		out.println("<script> </script>");

		out.println(
				"<a href=BoardUpdate.jsp?write_number=" + write_number + " class=\"btn btn-xs btn-success\">����</a>");

		out.println(
				"<a href=BoardDelete.jsp?write_number=" + write_number + " class=\"btn btn-xs btn-success\">����</a>");
		out.println("<a href=BoardList class=\"btn btn-xs btn-success\">���</a>");
		out.println("</div>");
		out.println("</div>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
