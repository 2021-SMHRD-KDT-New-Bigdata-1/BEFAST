package testProject;

import oracle.sql.DATE;

public class memberVO {

	private String MEMBER_ID; 		// 회원 ID
	private String MEMBER_NAME; 	// 회원 이름
	private String MEMBER_PHONE;	// 휴대전화
	private String MEMBER_BIRTHDATE;// 생년월일
	private DATE GENDER;			// 성별
	private String PWD;				// 비밀번호
	private String P_AREA;			// 선호지역
	private String POSITION;		// 포지션
	
	
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}
	public String getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}
	public void setMEMBER_PHONE(String mEMBER_PHONE) {
		MEMBER_PHONE = mEMBER_PHONE;
	}
	public String getMEMBER_BIRTHDATE() {
		return MEMBER_BIRTHDATE;
	}
	public void setMEMBER_BIRTHDATE(String mEMBER_BIRTHDATE) {
		MEMBER_BIRTHDATE = mEMBER_BIRTHDATE;
	}
	public DATE getGENDER() {
		return GENDER;
	}
	public void setGENDER(DATE gENDER) {
		GENDER = gENDER;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	public String getP_AREA() {
		return P_AREA;
	}
	public void setP_AREA(String p_AREA) {
		P_AREA = p_AREA;
	}
	public String getPOSITION() {
		return POSITION;
	}
	public void setPOSITION(String pOSITION) {
		POSITION = pOSITION;
	}
	
	
	
}
