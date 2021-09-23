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
	// URL
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private int write_number;

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
			conn = DriverManager.getConnection(URL, "hr", "hr");
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
			String sql = "SELECT write_number, field_code,field_area,field_member,team,write_subject,write_content,write_pw,regdate,hit FROM freeboard " + "ORDER BY no DESC"; // ����: �ӵ� ������INDEX
			ps = conn.prepareStatement(sql);
			// SQL ���� �� ����� �ޱ�
			ResultSet rs = ps.executeQuery();
			// ����� ArrayList�� ÷��
			while (rs.next()) {
				
				BoardVO vo = new BoardVO();
				vo.setWrite_number(rs.getInt(1));
				vo.setField_code(rs.getInt(2));
				vo.setField_area(rs.getInt(3));
				vo.setField_member(rs.getInt(4));
				vo.setTeam(rs.getInt(5));
				vo.setWrite_subject(rs.getString(6));
				vo.setWrite_content(rs.getString(7));
				vo.setWrite_pw(rs.getString(8));
				vo.setRegdate(rs.getDate(9));
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
	public BoardVO boardDetail(int no) {
		BoardVO vo = new BoardVO();
		try {
			// ����
			getConnection();
			// SQL���� ���� ==> ��ȸ�� ����
			String sql = "UPDATE freeboard SET hit=hit+1 WHERE write_number=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, write_number); // ?�� ���� ä���
			// ����
			ps.executeUpdate();
			// ���빰 �����͸� ������ �´�
			
			sql = "SELECT write_number, field_code,field_member,field_area,team, write_subject, write_content, regdate, hit FROM freeboard WHERE write_number=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, write_number);
			ResultSet rs = ps.executeQuery();
			rs.next();

			vo.setWrite_number(rs.getInt(1));
			vo.setField_code(rs.getInt(2));
			vo.setField_member(rs.getInt(3));
			vo.setField_area(rs.getInt(4));
			vo.setTeam(rs.getInt(5));
			vo.setWrite_subject(rs.getString(6));
			vo.setWrite_content(rs.getString(7));
			vo.setRegdate(rs.getDate(8));
			vo.setHit(rs.getInt(9));
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
			
			
			String sql = "INSERT INTO board(write_number, field_code,field_member,field_area,team,write_subject,write_content,write_pw) VALUES((SELECT NVL(MAX(no)+1,1) FROM freeboard),?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getField_code());
			ps.setInt(2, vo.getField_member());
			ps.setInt(3, vo.getField_area());
			ps.setInt(4, vo.getTeam());
			ps.setString(5, vo.getWrite_subject());
			ps.setString(6, vo.getWrite_content());
			ps.setString(7, vo.getWrite_pw());

			ps.executeUpdate(); // auto COMMIT
		} catch (Exception ex) {

		} finally {

		}
	}
	// 4.�ۼ��� UPDATE
	// 5.�ۻ��� DELETE
	// 6.ã�� SELECT
}
