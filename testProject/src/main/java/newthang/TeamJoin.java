package newthang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testProject.memberVO;

@WebServlet("/TeamJoin")
public class TeamJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("EUC-KR");
		String teamname = request.getParameter("teamname");
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("vo");
		String member_id = vo.getMEMBER_ID();
		
		
		//String team_name  = request.getParameter("team_name");
		
		TeamJoinDAO dao = new TeamJoinDAO();
		
		int cnt = dao.TeamJoin(teamname, member_id);
		
		
	
	if(cnt>0) {
				
		
		response.sendRedirect("Main.jsp");
		
	}
	else {
		System.out.println("수정 실패");
		response.sendRedirect("Main.jsp");
		}
	}

}
