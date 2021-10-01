package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeamsssDAO {
	private Connection conn;
	// SQL���� ����
	private PreparedStatement ps;
	ResultSet rs;

	private static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	private final String URL = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";

	// ���� �غ�
	// 1. ����̹� ���
	public TeamsssDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// ����
	public void conn() {
		try {
			conn = DriverManager.getConnection(URL, "cgi_6_5", "smhrd5");
		} catch (Exception ex) {
		}
	}

	// ����
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
			// ����Ŭ ����
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
			// 2_5. sql�� �����ϱ� -> ���� ���ο� ���� ������ �̵���Ű��
			psmt.executeUpdate();
			// 2_6 ���๮ó��
			
		} catch (Exception e) {
			e.printStackTrace();
			// ���� �� ���� �߻� �� �������
		}
	
	
		
	}
	
}
