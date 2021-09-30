package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MannerDAO {
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
	public MannerDAO() {
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
	
	// �Է�
	public void MannerInsert(MannerVO vo) {
		try {
			// ����
			getConnection();
			String sql = "INSERT INTO MATCHING_RESULTS VALUES (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getM_result());
			ps.setString(2, vo.getTime_result());
			ps.setString(3, vo.getFair_plays());
			ps.setString(4, vo.getLanguages());
			ps.setString(5, vo.getComments());

			ps.executeUpdate(); // auto COMMIT
		} catch (Exception ex) {

		} finally {

		}
	}
}
