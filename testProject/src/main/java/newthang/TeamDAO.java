package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	// �� ���� insert
	public void TeamInsert(TeamVO vo) {
		
		try {
			// ����Ŭ ����
			conn();
			String sql = "insert into TEAM_MEMBER(team_name, team_code, team_field, team_level, team_uniform, team_info, team_member, team_logo, teamleader) values(?,(SELECT NVL(MAX(team_code)+1,1) FROM TEAM_MEMBER),?,?,?,?,1,?,?)";

			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getTeam_name());
			psmt.setString(2, vo.getTeam_field());
			psmt.setString(3, vo.getTeam_level());
			psmt.setString(4, vo.getTeam_uniform());
			psmt.setString(5, vo.getTeam_info());
			psmt.setString(6, vo.getTeam_logo());
			psmt.setString(7, vo.getTeamleader());
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

	public ArrayList<TeamVO> TeamboardListData() {
		ArrayList<TeamVO> list = new ArrayList<TeamVO>();
		try {
			// ����
			conn();
			// SQL���� ����
			String sql = "SELECT *  FROM team_member ";
			// ����: �ӵ� ������INDEX
			psmt = conn.prepareStatement(sql);
			// SQL ���� �� ����� �ޱ�
			ResultSet rs = psmt.executeQuery();
			// ����� ArrayList�� ÷��
			while (rs.next()) {
				TeamVO vo = new TeamVO();
				vo.setTeam_name(rs.getString(1));
				vo.setTeam_code(rs.getInt(2));
				vo.setTeam_field(rs.getString(3));
				vo.setTeam_level(rs.getString(4));
				vo.setTeam_uniform(rs.getString(5));
				vo.setTeam_info(rs.getString(6));
				vo.setTeam_member(rs.getString(7));
				vo.setTeamleader(rs.getString(8));
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return list;

	}

	public TeamVO TeamDetail(String team_name) {
		TeamVO vo = new TeamVO();
		try {
			// ����
			conn();
			// SQL���� ���� ==> ��ȸ�� ����

			String sql = "select * FROM team_member WHERE Team_name=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, team_name); // ?�� ���� ä���
			// ����
			// ���빰 �����͸� ������ �´�

			ResultSet rs = psmt.executeQuery();
			rs.next();
						
			vo.setTeam_name(rs.getString(1));
			vo.setTeam_code(rs.getInt(2));
			vo.setTeam_field(rs.getString(3));
			vo.setTeam_level(rs.getString(4));
			vo.setTeam_uniform(rs.getString(5));
			vo.setTeam_info(rs.getString(6));
			vo.setTeam_member(rs.getString(7));
			rs.close();
					
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return vo;
	}
	
	// ã�� ���
	public ArrayList<TeamVO> TeamSearchData(String col, String word) {
		ArrayList<TeamVO> list = new ArrayList<TeamVO>();
		// SQL���� ����
		String sql = "SELECT team_name,team_field, team_level, team_uniform, team_info, team_member, team_time FROM team_member ";
		// ����: �ӵ� ������INDEX
		String sqlWord = "";
		if (col.equals("rname")) {
			sqlWord = "where team_name like '%" + word.trim() + "%'";
		} else if (col.equals("areas")) {
			sqlWord = "where team_field like '%" + word.trim() + "%'";
		} 
		sql = sql + sqlWord;
		sql += "ORDER BY team_code DESC";
		try {
			// ����
			conn();
			psmt = conn.prepareStatement(sql);
			// SQL ���� �� ����� �ޱ�
			rs = psmt.executeQuery();
			// ����� ArrayList�� ÷
			while (rs.next()) {
				TeamVO vo = new TeamVO();
				vo.setTeam_name(rs.getString(1));
				vo.setTeam_field(rs.getString(2));
				vo.setTeam_level(rs.getString(3));
				vo.setTeam_uniform(rs.getString(4));
				vo.setTeam_info(rs.getString(5));
				vo.setTeam_member(rs.getString(6));
				vo.setTeam_time(rs.getString(7));
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return list;

	}

}