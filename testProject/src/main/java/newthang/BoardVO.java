package newthang;

import java.sql.Date;

public class BoardVO {
	private int write_number; // 글번호
	private int field_code; //랭크, 친선, 일반(1,2,3)
	private int field_member; // 명
	private String p_area; //지역(광산구, 북구 등)
	private String team_name; //팀이름
    private String write_subject; //제목
    private String write_content; // 내용
    private String matching_time; //매칭시간
    private String write_pw; //비밀번호
    private Date write_time; //글쓴시간
    private int hit; //조회수
	public int getWrite_number() {
		return write_number;
	}
	public void setWrite_number(int write_number) {
		this.write_number = write_number;
	}
	public int getField_code() {
		return field_code;
	}
	public void setField_code(int field_code) {
		this.field_code = field_code;
	}
	public int getField_member() {
		return field_member;
	}
	public void setField_member(int field_member) {
		this.field_member = field_member;
	}
	public String getP_area() {
		return p_area;
	}
	public void setP_area(String p_area) {
		this.p_area = p_area;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getWrite_subject() {
		return write_subject;
	}
	public void setWrite_subject(String write_subject) {
		this.write_subject = write_subject;
	}
	public String getWrite_content() {
		return write_content;
	}
	public void setWrite_content(String write_content) {
		this.write_content = write_content;
	}
	public String getMatching_time() {
		return matching_time;
	}
	public void setMatching_time(String matching_time) {
		this.matching_time = matching_time;
	}
	public String getWrite_pw() {
		return write_pw;
	}
	public void setWrite_pw(String write_pw) {
		this.write_pw = write_pw;
	}
	public Date getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
    
    
    
}
