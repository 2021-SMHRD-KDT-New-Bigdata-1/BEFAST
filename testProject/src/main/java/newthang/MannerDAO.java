package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MannerDAO {
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
	public MannerDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 연결
	public void getConnection() {
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
	}
	
	// 입력
	public void MannerInsert(MannerVO vo) {
		try {
			// 연결
			getConnection();
			String sql = "INSERT INTO MATCHING_RESULTS(m_result,time_result,fair_plays,languages,comments,team_name,total_score,numbering) VALUES (?,?,?,?,?,null,?,(SELECT NVL(MAX(numbering)+1,1) FROM matching_results))";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getM_result());
			ps.setInt(2, vo.getTime_result());
			ps.setInt(3, vo.getFair_plays());
			ps.setInt(4, vo.getLanguages());
			ps.setString(5, vo.getComments());
			//ps.setString(6, vo.getTeam_name());
			ps.setInt(6, vo.getTotal_score());

			ps.executeUpdate(); // auto COMMIT
		} catch (Exception ex) {
			ex.printStackTrace();
			//실행해주세요
		} finally {

		}
	}
}
