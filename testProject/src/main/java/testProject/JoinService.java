package testProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("euc-kr");
		
		// 1. 사용자가 입력한 값 가져오기 (id, pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		try {
			// 오라클 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			
			String sql = "insert into MEMBERS values(?,?)"; // 어떤 SQL? insert? update? delete? select?
			// 사용자로부터 어떤 값을 받을지 모르기때문에
			PreparedStatement psmt = conn.prepareStatement(sql);

			// 2_4_1 첫 번째 물음표에 뭘 넣을꺼야?
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			// 2_5. sql문 실행하기 -> 성공 여부에 따라 페이지 이동시키기
			int cnt = psmt.executeUpdate();

			// 2_6 실행문처리
			if (cnt > 0) {// 성공하면 Login페이지로
				response.sendRedirect("Main.html");
			}

			
			} catch (Exception e) {
				e.printStackTrace();
				// 실행 후 오류 발생 시 에러출력
				}

	}

}
