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
			String sql = "SELECT no, warrior,member,field_code,name,subject,regdate,hit FROM freeboard " + "ORDER BY no DESC"; // ����: �ӵ� ������INDEX
			ps = conn.prepareStatement(sql);
			// SQL ���� �� ����� �ޱ�
			ResultSet rs = ps.executeQuery();
			// ����� ArrayList�� ÷��
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setWarrior(rs.getString(2));
				vo.setMember(rs.getInt(3));
				vo.setField_code(rs.getString(4));
				vo.setName(rs.getString(5));
				vo.setSubject(rs.getString(6));
				vo.setRegdate(rs.getDate(7));
				vo.setHit(rs.getInt(8));
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
			String sql = "UPDATE freeboard SET hit=hit+1 WHERE no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no); // ?�� ���� ä���
			// ����
			ps.executeUpdate();
			// ���빰 �����͸� ������ �´�
			sql = "SELECT no, warrior,member,field_code, name, subject, content, regdate, hit FROM freeboard WHERE no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();

			vo.setNo(rs.getInt(1));
			vo.setWarrior(rs.getString(2));
			vo.setMember(rs.getInt(3));
			vo.setField_code(rs.getString(4));
			vo.setName(rs.getString(5));
			vo.setSubject(rs.getString(6));
			vo.setContent(rs.getString(7));
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
			String sql = "INSERT INTO freeboard(no,warrior,member,field_code,name,subject,content,pwd) VALUES((SELECT NVL(MAX(no)+1,1) FROM freeboard),?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getWarrior());
			ps.setInt(2, vo.getMember());
			ps.setString(3, vo.getField_code());
			ps.setString(4, vo.getName());
			ps.setString(5, vo.getSubject());
			ps.setString(6, vo.getContent());
			ps.setString(7, vo.getPwd());

			ps.executeUpdate(); // auto COMMIT
		} catch (Exception ex) {

		} finally {

		}
	}
	// 4.�ۼ��� UPDATE
	// 5.�ۻ��� DELETE
	// 6.ã�� SELECT
}
