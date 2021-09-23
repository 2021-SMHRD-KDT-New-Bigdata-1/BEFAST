package newthang;

import java.sql.Date;

public class BoardVO {
	private int write_number; // 글번호
	private int team; // 팀이름
	private String write_subject; //제목
	private String write_content; //내용
	private String write_pw; //비번
	private String matching_time; //매칭시간
	private int field_code; // 랭크전, 친선전, 일반전
	private String field_area; // 광산구, 북구, 동구, 서구, 남구
	private int field_member; // 모집인원수
	private String write_time; //모집시간
	private Date regdate; // 글쓴 날짜
    private int hit; //조회수
    private String team_logo;
	public int getWrite_number() {
		return write_number;
	}
	public void setWrite_number(int write_number) {
		this.write_number = write_number;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
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
	public String getWrite_pw() {
		return write_pw;
	}
	public void setWrite_pw(String write_pw) {
		this.write_pw = write_pw;
	}
	public String getMatching_time() {
		return matching_time;
	}
	public void setMatching_time(String matching_time) {
		this.matching_time = matching_time;
	}
	public int getField_code() {
		return field_code;
	}
	public void setField_code(int field_code) {
		this.field_code = field_code;
	}
	public int getField_area() {
		return field_area;
	}
	public void setField_area(int field_area) {
		this.field_area = field_area;
	}
	public int getField_member() {
		return field_member;
	}
	public void setField_member(int field_member) {
		this.field_member = field_member;
	}
	public String getWrite_time() {
		return write_time;
	}
	public void setWrite_time(String write_time) {
		this.write_time = write_time;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTeam_logo() {
		return team_logo;
	}
	public void setTeam_logo(String team_logo) {
		this.team_logo = team_logo;
	}
	
	
    
    
	
    
    
	
    
	
	
    
    
    
}
