package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TeamBoardDAO {
	private Connection conn;
	// SQL���� ����
	private PreparedStatement ps;
	ResultSet rs;

	private static BoardDAO instance;


	public static BoardDAO getInstance(){
        if(instance==null)
            instance=new BoardDAO();
        return instance;
    }


	private final String URL = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";

	// ���� �غ�
	// 1. ����̹� ���
	public TeamBoardDAO() {
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
	   //���
	   //1.���(�Խ���) SELECT
	   public ArrayList<TeamBoardVO> boardListData(){
	      ArrayList<TeamBoardVO> list=new ArrayList<TeamBoardVO>();
	      try {
	         //����
	         getConnection();
	         //SQL���� ����
	         String sql="SELECT team_name, team_code, team_field, team_level, team_uniform, team_info, team_member  FROM team_member "
	                + "ORDER BY no DESC"; //����: �ӵ� ������INDEX
	         ps=conn.prepareStatement(sql);
	         //SQL ���� �� ����� �ޱ�
	         ResultSet rs=ps.executeQuery();      
	         //����� ArrayList�� ÷��
	         while(rs.next()) {
	            TeamBoardVO vo=new TeamBoardVO();
	            vo.setTeam_name(rs.getString(1));
	            vo.setTeam_code(rs.getString(2));
	            vo.setTeam_field(rs.getString(3));
	            vo.setTeam_level(rs.getString(4));
	            vo.setTeam_uniform(rs.getString(5));
	            vo.setTeam_info(rs.getString(6));
	            vo.setTeam_code(rs.getString(7));
	            list.add(vo);
	         }
	         rs.close();
	      }catch(Exception ex) {
	         System.out.println(ex.getMessage());
	      }finally {
	         disConnection();
	      }
	      return list;
	      
	   }
	   //2.���뺸�� SELECT (WHERE) ?no=1
		/*
		 * public TeamBoardVO boardDetail(int no) { BoardVO vo=new BoardVO(); try { //
		 * ���� getConnection(); // SQL���� ���� ==> ��ȸ�� ���� String
		 * sql="UPDATE freeboard SET hit=hit+1 WHERE no=?";
		 * ps=conn.prepareStatement(sql); ps.setInt(1, no); // ?�� ���� ä��� // ����
		 * ps.executeUpdate(); // ���빰 �����͸� ������ �´�
		 * sql="SELECT no, name, subject, content, regdate, hit FROM freeboard WHERE no=?"
		 * ; ps=conn.prepareStatement(sql); ps.setInt(1, no); ResultSet
		 * rs=ps.executeQuery(); rs.next();
		 * 
		 * vo.setNo(rs.getInt(1)); vo.setName(rs.getString(2));
		 * vo.setSubject(rs.getString(3)); vo.setContent(rs.getString(4));
		 * vo.setRegdate(rs.getDate(5)); vo.setHit(rs.getInt(6)); rs.close();
		 * }catch(Exception ex) { System.out.println(ex.getMessage()); } finally {
		 * disConnection(); } return vo; }
		 */
	
	   }

