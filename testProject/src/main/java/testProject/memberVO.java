package testProject;

import oracle.sql.DATE;

public class memberVO {

	private String MEMBER_ID; 		// ȸ�� ID
	private String PWD;				// ��й�ȣ
	private String MEMBER_NAME; 	// ȸ�� �̸�
	private String MEMBER_PHONE;	// �޴���ȭ
	private DATE MEMBER_BIRTHDATE;	// �������
	private String GENDER;			// ����
	private String P_AREA;			// ��ȣ����
	private String POSITION;		// ������
	
	
	public memberVO(String 	MEMBER_ID, String PWD, String MEMBER_NAME, String MEMBER_PHONE, DATE MEMBER_BIRTHDATE,
			String GENDER, String P_AREA, String POSITION) {
		super();
		this.MEMBER_ID = MEMBER_ID;
		this.PWD = PWD;
		this.MEMBER_NAME = MEMBER_NAME;
		this.MEMBER_PHONE = MEMBER_PHONE;
		this.MEMBER_BIRTHDATE = MEMBER_BIRTHDATE;
		this.GENDER = GENDER;
		this.P_AREA = P_AREA;
		this.POSITION = POSITION;
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


	public DATE getMEMBER_BIRTHDATE() {
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
	
	
	

	
	

	
	
	
}
