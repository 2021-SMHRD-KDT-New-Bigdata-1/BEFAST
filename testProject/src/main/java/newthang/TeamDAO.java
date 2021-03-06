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
	// 팀 생성 insert
	public void TeamInsert(TeamVO vo) {
		
		try {
			// 오라클 접속
			conn();
			
			

			String sql = "insert into TEAM_MEMBER(team_name, team_code, team_field, team_time, team_level, team_uniform, team_info, team_member, team_logo, teamleader) values(?,(SELECT NVL(MAX(team_code)+1,1) FROM TEAM_MEMBER),?,?,?,?,?,1,?,?)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getTeam_name());
			psmt.setString(2, vo.getTeam_field());
			psmt.setString(3, vo.getTeam_time());
			psmt.setString(4, vo.getTeam_level());
			psmt.setString(5, vo.getTeam_uniform());
			psmt.setString(6, vo.getTeam_info());
			psmt.setString(7, vo.getTeam_logo());
			psmt.setString(8, vo.getTeamleader());
			// 2_5. sql문 실행하기 -> 성공 여부에 따라 페이지 이동시키기
			psmt.executeUpdate();
			// 2_6 실행문처리
			
		} catch (Exception e) {
			e.printStackTrace();
			// 실행 후 오류 발생 시 에러출력
		}
	}

	
	// 팀명 중복확인
	public boolean TeamCheck(String TEAM_NAME) {
		boolean check = false;
		conn();
		String sql = "select TEAM_NAME from TEAM_MEMBER where TEAM_NAME = ?";

		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, TEAM_NAME);
			rs = psmt.executeQuery(); // select문 쿼리

			if (rs.next()) {
				// 사용자가 입력한 이메일이 테이블에 존재하는 경우
				check = true;
			} else {
				// 사용자가 입력한 이메일이 테이블에 존재하지 않는 경우
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
			// 연결
			conn();
			// SQL문장 전송
			String sql = "SELECT *  FROM team_member";
			// 단점: 속도 늦음→INDEX
			psmt = conn.prepareStatement(sql);
			// SQL 실행 후 결과값 받기
			ResultSet rs = psmt.executeQuery();
			// 결과값 ArrayList에 첨부
			while (rs.next()) {
				TeamVO vo = new TeamVO();
				vo.setTeam_name(rs.getString(1));
				vo.setTeam_code(rs.getInt(2));
				vo.setTeam_field(rs.getString(3));
				vo.setTeam_level(rs.getString(4));
				vo.setTeam_uniform(rs.getString(5));
				vo.setTeam_info(rs.getString(6));
				vo.setTeam_time(rs.getString(7));
				vo.setTeam_logo(rs.getString(8));
				vo.setTeamleader(rs.getString(9));
				vo.setTeam_member(rs.getInt(10));
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
			// 연결
			conn();
			

			String sql = "select * FROM team_member WHERE Team_name=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, team_name); // ?에 값을 채운다
			// 실행
			// 내용물 데이터를 가지고 온다

			ResultSet rs = psmt.executeQuery();
			rs.next();
			vo.setTeam_name(rs.getString(1));
			vo.setTeam_code(rs.getInt(2));
			vo.setTeam_field(rs.getString(3));
			vo.setTeam_level(rs.getString(4));
			vo.setTeam_uniform(rs.getString(5));
			vo.setTeam_info(rs.getString(6));
			vo.setTeam_time(rs.getString(7));
			vo.setTeam_logo(rs.getString(7));
			vo.setTeamleader(rs.getString(9));
			vo.setTeam_member(rs.getInt(10));
			rs.close();
					
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return vo;
	}
	
	// 찾기 기능
	public ArrayList<TeamVO> TeamSearchData(String col, String word) {
		ArrayList<TeamVO> list = new ArrayList<TeamVO>();
		// SQL문장 전송
		String sql = "SELECT team_name,team_field, team_level, team_uniform, team_info,  team_time, teamleader,team_member FROM team_member ";
		// 단점: 속도 늦음→INDEX
		String sqlWord = "";
		if (col.equals("rname")) {
			sqlWord = "where team_name like '%" + word.trim() + "%'";
		} else if (col.equals("areas")) {
			sqlWord = "where team_field like '%" + word.trim() + "%'";
		} 
		sql = sql + sqlWord;
		sql += "ORDER BY team_code DESC";
		try {
			// 연결
			conn();
			psmt = conn.prepareStatement(sql);
			// SQL 실행 후 결과값 받기
			rs = psmt.executeQuery();
			// 결과값 ArrayList에 첨
			while (rs.next()) {
				TeamVO vo = new TeamVO();
				vo.setTeam_name(rs.getString(1));
				vo.setTeam_field(rs.getString(2));
				vo.setTeam_level(rs.getString(3));
				vo.setTeam_uniform(rs.getString(4));
				vo.setTeam_info(rs.getString(5));
				vo.setTeam_time(rs.getString(6));
				vo.setTeamleader(rs.getString(7));
				vo.setTeam_member(rs.getInt(8));
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
	public TeamVO Teamlogo(String Team_name){
		TeamVO vo = new TeamVO();
		try {
			// 연결
			conn();
			

			String sql = "select team_logo FROM team_member WHERE Team_name=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Team_name); // ?에 값을 채운다
			// 실행
			// 내용물 데이터를 가지고 온다

			ResultSet rs = psmt.executeQuery();
			rs.next();
			vo.setTeam_logo(rs.getString(1));
			rs.close();
					
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return vo;
	}
	
	public ResultVO Result(String team_name) {
		ResultVO vo = new ResultVO();
		try {
			// 연결
			conn();
			

			String sql = "select * FROM teams WHERE Team_name=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, team_name); // ?에 값을 채운다
			// 실행
			// 내용물 데이터를 가지고 온다

			ResultSet rs = psmt.executeQuery();
			rs.next();
			vo.setTEAM_CODE(rs.getInt(1));
			vo.setTEAM_NAME(rs.getString(2));
			vo.setMANNERSCORES(rs.getInt(3));
			vo.setWINNER_POINT(rs.getInt(4));
			vo.setTEAM_LOGO(rs.getString(5));
			vo.setTEAM_TROPHY(rs.getString(6));
			vo.setTEAM_INFO(rs.getString(7));
			vo.setTEAMLEADER(rs.getString(8));
			vo.setRESULT_1(rs.getInt(9));
			vo.setRESULT_2(rs.getInt(10));
			vo.setRESULT_3(rs.getInt(11));
			rs.close();
					
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		return vo;
	}
public void ResultInsert(ResultVO vo) {
		
		try {
			// 오라클 접속
			conn();
			
			

			String sql = "insert into teams(team_code, team_name, mannerscores, winner_point, team_logo, team_trophy, team_info, teamleader, result_1, result_2,result_3) values(null,?,null,null,?,null,?,?,null,null,null)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			
			
			psmt.setString(1, vo.getTEAM_NAME());
			psmt.setString(2, vo.getTEAM_LOGO());
			psmt.setString(3, vo.getTEAM_INFO());
			psmt.setString(4, vo.getTEAMLEADER());
			// 2_5. sql문 실행하기 -> 성공 여부에 따라 페이지 이동시키기
			psmt.executeUpdate();
			// 2_6 실행문처리
			
		} catch (Exception e) {
			e.printStackTrace();
			// 실행 후 오류 발생 시 에러출력
		}
	}

	}

	
