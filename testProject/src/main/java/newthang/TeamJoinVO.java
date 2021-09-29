package newthang;

public class TeamJoinVO {

	private String team_name;
	public TeamJoinVO(String team_name) {
		super();
		this.team_name = team_name;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	private String member_id;
}
