package testProject;

import oracle.sql.DATE;

public class JoinVO {
	
	private String MEMER_ID;
	private String PWD;
	private String MEMBER_NAME;
	private DATE MEMBER_BIRTHDATE;
	private String GENDER;
	private String MEMBER_PHONE;
	
	public String getMEMER_ID() {
		return MEMER_ID;
	}
	public void setMEMER_ID(String mEMER_ID) {
		MEMER_ID = mEMER_ID;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pWD) {
		PWD = pWD;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}
	public DATE getMEMBER_BIRTHDATE() {
		return MEMBER_BIRTHDATE;
	}
	public void setMEMBER_BIRTHDATE(DATE mEMBER_BIRTHDATE) {
		MEMBER_BIRTHDATE = mEMBER_BIRTHDATE;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}
	public void setMEMBER_PHONE(String mEMBER_PHONE) {
		MEMBER_PHONE = mEMBER_PHONE;
	}
 
	
	
}
