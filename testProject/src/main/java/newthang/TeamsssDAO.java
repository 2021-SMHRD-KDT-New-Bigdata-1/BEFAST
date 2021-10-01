package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeamsssDAO {
	private Connection conn;
	// SQL문장 전송
	private PreparedStatement ps;
	ResultSet rs;

	private static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	private final String URL = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";

	// 연결 준비
	// 1. 드라이버 등록
	public TeamsssDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 연결
	public void conn() {
		try {
			conn = DriverManager.getConnection(URL, "cgi_6_5", "smhrd5");
		} catch (Exception ex) {
		}
	}

	// 해제
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		
		}
		
	public void Teamin(TeamsssVO vo) {
		try {
			// 오라클 접속
			conn();
			
			

			String sql = "insert into teams(team_code, team_code, team_field, team_time, team_level, team_uniform, team_info, team_member, team_logo, teamleader) values(?,(SELECT NVL(MAX(team_code)+1,1) FROM TEAM_MEMBER),?,?,?,?,?,1,?,?)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getTeam_name());
			psmt.setString(2, vo.getTeam_field());
			psmt.setString(3, vo.getTeam_time());
			psmt.setString(4, vo.getTeam_level());
			psmt.setString(5, vo.getTeam_uniform());
			psmt.setString(6, vo.getTeam_info());
			psmt.setString(7, vo.getTeam_logo());
			psmt.setString(8, vo.getTeamleader());
			// 2_5. sql문 실행하기 -> 성공 여부에 따라 페이지 이동시키기
			psmt.executeUpdate();
			// 2_6 실행문처리
			
		} catch (Exception e) {
			e.printStackTrace();
			// 실행 후 오류 발생 시 에러출력
		}
	
	
		
	}
	
}
