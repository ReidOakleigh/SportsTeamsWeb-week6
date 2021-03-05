package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: League
 *
 */
@Entity
@Table(name="league")
public class League {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LEAGUE_ID")
	private int id;
	@Column(name="SPORT")
	private String sport;
	@Column(name="LEAGUE_NAME")
	private String leagueName;
	@Column(name="HALL_OF_FAME")
	private String hallOfFame;

	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="league_id")
//	@JoinTable
//	(
//			name="teams_in_league",
//			joinColumns={ @JoinColumn(name="LEAGUE_ID",
//					  referencedColumnName="LEAGUE_ID") },
//			inverseJoinColumns={ @JoinColumn(name="TEAM_ID",
//					  referencedColumnName="TEAM_ID", unique=true) }
//	)	
	private List<Team> listOfTeams;
	 

	public League() {}
	
	
	public League(String sport, String leagueName, String hallOfFame) {
		super();
		this.sport = sport;
		this.leagueName = leagueName;
		this.hallOfFame = hallOfFame;
		listOfTeams = new ArrayList<Team>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSport() {
		return sport;
	}


	public void setSport(String sport) {
		this.sport = sport;
	}


	public String getLeagueName() {
		return leagueName;
	}


	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}


	public String getHallOfFame() {
		return hallOfFame;
	}


	public void setHallOfFame(String hallOfFame) {
		this.hallOfFame = hallOfFame;
	}



	public List<Team> getListOfTeams() {
		return listOfTeams;
	}

	public void addTeam(Team team) {
		listOfTeams.add(team);
	}

	@Override
	public String toString() {
		return id + " " + sport + " " + leagueName + " " + hallOfFame;
	}





}
