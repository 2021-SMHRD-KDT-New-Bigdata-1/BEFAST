package newthang;

import java.sql.Date;

public class BoardVO {
	private int write_number; // �۹�ȣ
	private int field_code; //��ũ, ģ��, �Ϲ�(1,2,3)
	private int field_member; // ��
	private String p_area; //����(���걸, �ϱ� ��)
	private String team_name; //���̸�
    private String write_subject; //����
    private String write_content; // ����
    private String matching_time; //��Ī�ð�
    private String write_pw; //��й�ȣ
    private Date write_time; //�۾��ð�
    private int hit; //��ȸ��
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
