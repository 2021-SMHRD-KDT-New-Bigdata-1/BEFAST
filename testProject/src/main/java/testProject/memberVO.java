package testProject;

import oracle.sql.DATE;

public class memberVO {

	private String MEMBER_ID; 		// 회원 ID
	private String MEMBER_NAME; 	// 회원 이름
	private String MEMBER_PHONE;	// 휴대전화
	private DATE   MEMBER_BIRTHDATE;	// 생년월일
	private String GENDER;			// 성별
	private String PWD;				// 비밀번호
	private String P_AREA;			// 선호지역
	private String POSITION;		// 포지션
	
	
public memberVO(String MEMBER_ID, String MEMBER_NAME, String MEMBER_PHONE, DATE MEMBER_BIRTHDATE, String GENDER,
			String PWD, String P_AREA, String POSITION) {
		super();
		this.MEMBER_ID = MEMBER_ID;
		this.MEMBER_NAME = MEMBER_NAME;
		this.MEMBER_PHONE = MEMBER_PHONE;
		this.MEMBER_BIRTHDATE = MEMBER_BIRTHDATE;
		this.GENDER = GENDER;
		this.PWD = PWD;
		this.P_AREA = P_AREA;
		this.POSITION = POSITION;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String MEMBER_ID) {
		this.MEMBER_ID = MEMBER_ID;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String MEMBER_NAME) {
		this.MEMBER_NAME = MEMBER_NAME;
	}
	public String getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}
	public void setMEMBER_PHONE(String MEMBER_PHONE) {
		this.MEMBER_PHONE = MEMBER_PHONE;
	}
	public DATE getMEMBER_BIRTHDATE() {
		return MEMBER_BIRTHDATE;
	}
	public void setMEMBER_BIRTHDATE(DATE MEMBER_BIRTHDATE) {
		this.MEMBER_BIRTHDATE = MEMBER_BIRTHDATE;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String GENDER) {
		this.GENDER = GENDER;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String PWD) {
		this.PWD = PWD;
	}
	public String getP_AREA() {
		return P_AREA;
	}
	public void setP_AREA(String P_AREA) {
		this.P_AREA = P_AREA;
	}
	public String getPOSITION() {
		return POSITION;
	}
	public void setPOSITION(String POSITION) {
		this.POSITION = POSITION;
	}
	
	

	
	
	
}
