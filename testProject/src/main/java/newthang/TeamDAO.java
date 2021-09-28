package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeamDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void conn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {

		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (psmt != null) {
				psmt.close();

			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TeamInsert(TeamVO vo) {
		// �� ���� insert
		try {
			// ����Ŭ ����
			conn();
			String sql = "insert into TEAM_MEMBER(team_name, team_code, team_field, team_level, team_uniform, team_info, team_member) values(?,(SELECT NVL(MAX(team_code)+1,1) FROM TEAM_MEMBER),?,?,?,?,1)";

			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getTeam_name());
			psmt.setString(2, vo.getTeam_field());
			psmt.setString(3, vo.getTeam_level());
			psmt.setString(4, vo.getTeam_uniform());
			psmt.setString(5, vo.getTeam_info());

			// 2_5. sql�� �����ϱ� -> ���� ���ο� ���� ������ �̵���Ű��
			psmt.executeUpdate();
			// 2_6 ���๮ó��

		} catch (Exception e) {
			e.printStackTrace();
			// ���� �� ���� �߻� �� �������
		}
	}

	// ���� �ߺ�Ȯ��
	public boolean TeamCheck(String TEAM_NAME) {
		boolean check = false;
		conn();
		String sql = "select TEAM_NAME from TEAM_MEMBER where TEAM_NAME = ?";

		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, TEAM_NAME);
			rs = psmt.executeQuery(); // select�� ����

			if (rs.next()) {
				// ����ڰ� �Է��� �̸����� ���̺� �����ϴ� ���
				check = true;
			} else {
				// ����ڰ� �Է��� �̸����� ���̺� �������� �ʴ� ���
				check = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return check;
	}

}