package testProject;

public class BookingVO {
	private String MATCHING_DATE;
	private String ADDRESS;
	private String FILED_NAME;
	private String GAMES;
	private String TIMES;
	
	private String TEAM_NAME;
	private String MEMBER_ID;
	private String TEAM_NAME2;
	
	
	public BookingVO() {
		
	}


	
	
	
	public BookingVO(String MATCHING_DATE, String ADDRESS, String FILED_NAME, String GAMES, String TIMES,
			String TEAM_NAME, String MEMBER_ID) {
		super();
		this.MATCHING_DATE = MATCHING_DATE;
		this.ADDRESS = ADDRESS;
		this.FILED_NAME = FILED_NAME;
		this.GAMES = GAMES;
		this.TIMES = TIMES;
		this.TEAM_NAME = TEAM_NAME;
		this.MEMBER_ID = MEMBER_ID;
	}
	 

	




	public String getTEAM_NAME() {
		return TEAM_NAME;
	}




	public void setTEAM_NAME(String TEAM_NAME) {
		this.TEAM_NAME = TEAM_NAME;
	}




	public String getMEMBER_ID() {
		return MEMBER_ID;
	}




	public void setMEMBER_ID(String MEMBER_ID) {
		this.MEMBER_ID = MEMBER_ID;
	}




	public String getMATCHING_DATE() {
		return MATCHING_DATE;
	}


	public void setMATCHING_DATE(String MATCHING_DATE) {
		this.MATCHING_DATE = MATCHING_DATE;
	}


	public String getADDRESS() {
		return ADDRESS;
	}


	public void setADDRESS(String ADDRESS) {
		this.ADDRESS = ADDRESS;
	}


	public String getFILED_NAME() {
		return FILED_NAME;
	}


	public void setFILED_NAME(String FILED_NAME) {
		this.FILED_NAME = FILED_NAME;
	}


	public String getGAMES() {
		return GAMES;
	}


	public void setGAMES(String GAMES) {
		this.GAMES = GAMES;
	}


	public String getTIMES() {
		return TIMES;
	}


	public void setTIMES(String TIMES) {
		this.TIMES = TIMES;
	}
	
	
	
	
	
}
