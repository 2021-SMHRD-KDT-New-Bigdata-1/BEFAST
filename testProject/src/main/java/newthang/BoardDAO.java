package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
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
	public BoardDAO() {
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

	// 기능
	// 1.목록(게시판) SELECT
	public ArrayList<BoardVO> boardListData() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// 연결
			getConnection();
			// SQL문장 전송
			String sql = "SELECT write_number,field_code,field_member,p_area,team_name,write_subject,write_content,matching_time,write_time,hit FROM board "
					+ "ORDER BY write_number DESC"; // 단점: 속도 늦음→INDEX
			ps = conn.prepareStatement(sql);
			// SQL 실행 후 결과값 받기
			rs = ps.executeQuery();
			// 결과값 ArrayList에 첨
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

	// 2.내용보기 SELECT (WHERE) ?no=1
	public BoardVO boardDetail(int write_number) {
		BoardVO vo = new BoardVO();
		try {
			// 연결
			getConnection();
			// SQL문장 전송 ==> 조회수 증가

			String sql = "UPDATE board SET hit=hit+1 WHERE write_number=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, write_number); // ?에 값을 채운다
			// 실행
			ps.executeUpdate();
			// 내용물 데이터를 가지고 온다
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

	// 3.글쓰기 INSERT
	public void boardInsert(BoardVO vo) {
		try {
			// 연결
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

	// 4.글수정 UPDATE

	public int update(BoardVO vo) {
		getConnection();
		String sql = "update board set field_code=?, field_member=?, p_area=?, team_name=?, write_subject = ?, write_content = ?, matching_time=?,write_pw=? where write_number = ?";
		try {
			// BoardVO vo = new BoardVO();
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
		return -1; // 데이터베이스 오류
	}

	// 5.글삭제 DELETE
	// 패스워드 가져오기
	public String getPass(int write_number) {// 리턴할 변수 객체 선언
		String write_pw = "";
		// DB연결
		getConnection();

		try {

			// 쿼리 준비
			String sql = "select write_pw from board where write_number=?";
			// 쿼리 실행할 객체 선언
			ps = conn.prepareStatement(sql);
			ps.setInt(1, write_number);
			rs = ps.executeQuery();
			// 패스워드 값을 저장
			if (rs.next()) {
				write_pw = rs.getString(1);
			}
			// 자원 반납
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return write_pw;

	}

	public void deleteBoard(int write_number) {
		getConnection();
		try {
			// 쿼리 준비
			String sql = "delete from board where write_number=?";
			ps = conn.prepareStatement(sql);

			// 쿼리 실행을 위한 인덱스와 값을 넣어주기
			ps.setInt(1, write_number);

			// 쿼리 실행
			ps.executeUpdate();

			// 자원 반납
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// 6.찾기 SELECT
	public ArrayList<BoardVO> BoardSearchData(String col, String word) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// SQL문장 전송
		String sql = "SELECT write_number,field_code,field_member,p_area,team_name,write_subject,write_content,matching_time,write_time,hit FROM board ";
		// 단점: 속도 늦음→INDEX
		String sqlWord = "";
		if (col.equals("rname")) {
			sqlWord = "where team_name like '%" + word.trim() + "%'";
		} else if (col.equals("title")) {
			sqlWord = "where write_subject like '%" + word.trim() + "%'";
		} else if (col.equals("content")) {
			sqlWord = "where write_content like '%" + word.trim() + "%'";
		}
		sql = sql + sqlWord;
		sql += "ORDER BY write_number DESC";
		try {
			// 연결
			getConnection();
			
			ps = conn.prepareStatement(sql);
			// SQL 실행 후 결과값 받기
			rs = ps.executeQuery();
			// 결과값 ArrayList에 첨
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

	
	

}

// 7. 페이지 처리
