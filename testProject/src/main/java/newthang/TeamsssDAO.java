package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		
		public ArrayList<TeamsssVO> TeamListData11() {
			ArrayList<TeamsssVO> list1 = new ArrayList<TeamsssVO>();
			try {
				// ����
				conn();
				String sql = "SELECT result_1,result_2,result_3 from MATCHING_RESULTS";
						 // ����: �ӵ� ������INDEX
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					TeamsssVO vo = new TeamsssVO();
					vo.setResult_1(rs.getInt(1));
					vo.setResult_2(rs.getInt(2));
					vo.setResult_3(rs.getInt(3));
					list1.add(vo);
				}
				rs.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {
				disConnection();
			}
			return;

		}

	
	
		
	}

}
