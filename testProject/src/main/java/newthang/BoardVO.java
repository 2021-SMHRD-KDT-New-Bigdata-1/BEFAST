package newthang;

import java.sql.Date;

public class BoardVO {
	private int write_number; // �۹�ȣ
	private int team; // ���̸�
	private String write_subject; //����
	private String write_content; //����
	private String write_pw; //���
	private String matching_time; //��Ī�ð�
	private int field_code; // ��ũ��, ģ����, �Ϲ���
	private String field_area; // ���걸, �ϱ�, ����, ����, ����
	private int field_member; // �����ο���
	private String write_time; //�����ð�
	private Date regdate; // �۾� ��¥
    private int hit; //��ȸ��
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
