package testProject;

public class BookingVO {
	private String MATCHING_DATE;
	private String ADDRESS;
	private String FILED_NAME;
	private String GAMES;
	private String TIMES;


	
	
	public BookingVO(String MATCHING_DATE, String ADDRESS, String FILED_NAME, String GAMES, String TIMES) {
		super();
		this.MATCHING_DATE = MATCHING_DATE;
		this.ADDRESS = ADDRESS;
		this.FILED_NAME = FILED_NAME;
		this.GAMES = GAMES;
		this.TIMES = TIMES;
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
