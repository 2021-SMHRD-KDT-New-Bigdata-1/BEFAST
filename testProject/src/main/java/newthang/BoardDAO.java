package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	private Connection conn;
	// SQL���� ����
	private PreparedStatement ps;
	ResultSet rs;
	// URL
	private final String URL = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";

	// ���� �غ�
	// 1. ����̹� ���
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// ����
	public void getConnection() {
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
	}

	// ���
	// 1.���(�Խ���) SELECT
	public ArrayList<BoardVO> boardListData() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// ����
			getConnection();
			// SQL���� ����
			String sql = "SELECT write_number,field_code,field_member,p_area,team_name,write_subject,write_content,matching_time,write_time,hit FROM board "
					+ "ORDER BY write_number DESC"; // ����: �ӵ� ������INDEX
			ps = conn.prepareStatement(sql);
			// SQL ���� �� ����� �ޱ�
			rs = ps.executeQuery();
			// ����� ArrayList�� ÷
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setWrite_number(rs.getInt(1));
				vo.setField_code(rs.getInt(2));
				vo.setField_member(rs.getInt(3));
				vo.setP_area(rs.getString(4));
				vo.setTeam_name(rs.getString(5));
				vo.setWrite_subject(rs.getString(6));
				vo.setWrite_content(rs.getString(7));
				vo.setMatching_time(rs.getString(8));
				vo.setWrite_time(rs.getDate(9));
				vo.setHit(rs.getInt(10));
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return list;

	}

	// 2.���뺸�� SELECT (WHERE) ?no=1
	public BoardVO boardDetail(int write_number) {
		BoardVO vo = new BoardVO();
		try {
			// ����
			getConnection();
			// SQL���� ���� ==> ��ȸ�� ����

			String sql = "UPDATE board SET hit=hit+1 WHERE write_number=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, write_number); // ?�� ���� ä���
			// ����
			ps.executeUpdate();
			// ���빰 �����͸� ������ �´�
			sql = "SELECT write_number,field_code,field_member,p_area,team_name,write_subject,write_content,matching_time,write_time,hit FROM board WHERE write_number=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, write_number);
			ResultSet rs = ps.executeQuery();
			rs.next();

			vo.setWrite_number(rs.getInt(1));
			vo.setField_code(rs.getInt(2));
			vo.setField_member(rs.getInt(3));
			vo.setP_area(rs.getString(4));
			vo.setTeam_name(rs.getString(5));
			vo.setWrite_subject(rs.getString(6));
			vo.setWrite_content(rs.getString(7));
			vo.setMatching_time(rs.getString(8));
			vo.setWrite_time(rs.getDate(9));
			vo.setHit(rs.getInt(10));
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return vo;
	}

	// 3.�۾��� INSERT
	public void boardInsert(BoardVO vo) {
		try {
			// ����
			getConnection();
			String sql = "INSERT INTO board(write_number,field_code,field_member,p_area,team_name,write_subject,write_content,matching_time,write_pw) VALUES((SELECT NVL(MAX(write_number)+1,1) FROM board),?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getField_code());
			ps.setInt(2, vo.getField_member());
			ps.setString(3, vo.getP_area());
			ps.setString(4, vo.getTeam_name());
			ps.setString(5, vo.getWrite_subject());
			ps.setString(6, vo.getWrite_content());
			ps.setString(7, vo.getMatching_time());
			ps.setString(8, vo.getWrite_pw());

			ps.executeUpdate(); // auto COMMIT
		} catch (Exception ex) {

		} finally {

		}
	}

	// 4.�ۼ��� UPDATE
	
	
	public int update(int write_number) {
		getConnection();
		String sql = "update board set field_code=?, field_member=?, p_area=?, team_area=?, write_subject = ?, write_content = ?, matching_time=?,write_pw=? where write_number = ?";
		try {
			BoardVO vo = new BoardVO();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getField_code());
			ps.setInt(2, vo.getField_member());
			ps.setString(3, vo.getP_area());
			ps.setString(4, vo.getTeam_name());
			ps.setString(5, vo.getWrite_subject());
			ps.setString(6, vo.getWrite_content());
			ps.setString(7, vo.getMatching_time());
			ps.setString(8, vo.getWrite_pw());
			ps.setInt(9, vo.getWrite_number());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽� ����
	}

	// 5.�ۻ��� DELETE
	public String getPass(int write_number) {// ������ ���� ��ü ����
		String write_pw = "";
		// DB����
		getConnection();

		try {

			// ���� �غ�
			String sql = "select write_pw from board where write_number=?";
			// ���� ������ ��ü ����
			ps = conn.prepareStatement(sql);
			ps.setInt(1, write_number);
			rs = ps.executeQuery();
			// �н����� ���� ����
			if (rs.next()) {
				write_pw = rs.getString(1);
			}
			// �ڿ� �ݳ�
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return write_pw;

	}

	public void deleteBoard(int write_number) {
		getConnection();
		try {
			// ���� �غ�
			String sql = "delete from board where write_number=?";
			ps = conn.prepareStatement(sql);

			// ���� ������ ���� �ε����� ���� �־��ֱ�
			ps.setInt(1, write_number);

			// ���� ����
			ps.executeUpdate();

			// �ڿ� �ݳ�
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 6.ã�� SELECT

// 7. ������ ó��

