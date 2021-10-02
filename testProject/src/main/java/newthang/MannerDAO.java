package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	// select
	public ArrayList<TeamsssVO> MannerListData() {
		ArrayList<TeamsssVO> list = new ArrayList<TeamsssVO>();
		try {
			
			// 연결
			getConnection();
			String sql = "SELECT team_name,mannerscores,winner_point,result_1,result_2,result_3 "
					+ "from teams ORDER BY winner_point desc"; // 단점: 속도 늦음→INDEX
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeamsssVO vo = new TeamsssVO();
				vo.setTeam_name(rs.getString(1));
				vo.setMannerscores(rs.getInt(2));
				vo.setWinner_point(rs.getInt(3));
				vo.setResult_1(rs.getInt(4));
				vo.setResult_2(rs.getInt(5));
				vo.setResult_3(rs.getInt(6));
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

	
	
	// 입력
	public void MannerInsert(MannerVO vo,TeamsssVO vo2) {
		try {
			// 연결
			getConnection();// team_name,mannerscores,winner_point,result_1,result_2,result_3
			if(vo.getTeam_name()==vo2.getTeam_name()) {
				String sql = "insert into teams(winner_point, mannerscores,result_1,result_2,result_3)"
						+ "select m_result,total_score,result_1,result_2,result_3 from matching_results;";
			
			
			/*"INSERT INTO MATCHING_RESULTS(winner_point,time_result,fair_plays,languages,comments,team_name,mannerscores,numbering,result_1,result_2,result_3) "
					+"VALUES ((select winner_point from teams),?,?,?,?,(select team_name from teams),(select mannerscores from teams),"
					+ "(SELECT NVL(MAX(numbering)+1,1) FROM matching_results),(select result_1 from teams),(select result_2 from teams),(select result_3 from teams))";*/
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getM_result());
			ps.setInt(2, vo.getTime_result());
			ps.setInt(3, vo.getFair_plays());
			ps.setInt(4, vo.getLanguages());
			ps.setString(5, vo.getComments());
			//ps.setString(6, vo.getTeam_name());
			ps.setInt(6, vo.getTotal_score());
			ps.setInt(7, vo.getResult_1());
			ps.setInt(8, vo.getResult_2());
			ps.setInt(9, vo.getResult_3());
			
			ps.executeUpdate(); // auto COMMIT
			}else {
				System.out.print(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			//실행해주세요
		} finally {

		}
	}
}
