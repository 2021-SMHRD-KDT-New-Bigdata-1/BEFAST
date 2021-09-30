package testProject;

public class memberVO {

	private String MEMBER_ID; 		// 회원 ID
	private String PWD;				// 비밀번호
	private String MEMBER_NAME; 	// 회원 이름
	private String MEMBER_PHONE;	// 휴대전화
	private String MEMBER_BIRTHDATE;	// 생년월일
	private String GENDER;			// 성별
	private String P_AREA;			// 선호지역
	private String POSITION;		// 포지션
	
	private String TEAM_NAME;
	private String TEAM_CODE;
	
	
	
	
	
	
	//이 생성자에서는  3번째가 name 자리에요 아하!! 감사합니다!@
	public memberVO(String MEMBER_ID, String PWD, String MEMBER_NAME, String MEMBER_PHONE, String MEMBER_BIRTHDATE,
			String GENDER, String P_AREA, String POSITION, String TEAM_NAME, String TEAM_CODE) {
		super();
		this.MEMBER_ID = MEMBER_ID;
		this.PWD = PWD;
		this.MEMBER_NAME = MEMBER_NAME;
		this.MEMBER_PHONE = MEMBER_PHONE;
		this.MEMBER_BIRTHDATE = MEMBER_BIRTHDATE;
		this.GENDER = GENDER;
		this.P_AREA = P_AREA;
		this.POSITION = POSITION;
		this.TEAM_NAME = TEAM_NAME;
		this.TEAM_CODE = TEAM_CODE;
	}


	public String getTEAM_NAME() {
		return TEAM_NAME;
	}


	public void setTEAM_NAME(String TEAM_NAME) {
		this.TEAM_NAME = TEAM_NAME;
	}


	public String getTEAM_CODE() {
		return TEAM_CODE;
	}


	public void setTEAM_CODE(String TEAM_CODE) {
		this.TEAM_CODE = TEAM_CODE;
	}
	


	public String getMEMBER_ID() {
		return MEMBER_ID;
	}


	public String getPWD() {
		return PWD;
	}


	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}


	public String getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}


	public String getMEMBER_BIRTHDATE() {
		return MEMBER_BIRTHDATE;
	}


	public String getGENDER() {
		return GENDER;
	}


	public String getP_AREA() {
		return P_AREA;
	}


	public String getPOSITION() {
		return POSITION;
	}

	
	public void setMEMBER_ID(String MEMBER_ID) {
		this.MEMBER_ID = MEMBER_ID;
	}


	public void setPWD(String PWD) {
		this.PWD = PWD;
	}


	public void setMEMBER_NAME(String MEMBER_NAME) {
		this.MEMBER_NAME = MEMBER_NAME;
	}


	public void setMEMBER_PHONE(String MEMBER_PHONE) {
		this.MEMBER_PHONE = MEMBER_PHONE;
	}


	public void setMEMBER_BIRTHDATE(String MEMBER_BIRTHDATE) {
		this.MEMBER_BIRTHDATE = MEMBER_BIRTHDATE;
	}


	public void setGENDER(String GENDER) {
		this.GENDER = GENDER;
	}


	public void setP_AREA(String P_AREA) {
		this.P_AREA = P_AREA;
	}


	public void setPOSITION(String POSITION) {
		this.POSITION = POSITION;
	}



	
}
