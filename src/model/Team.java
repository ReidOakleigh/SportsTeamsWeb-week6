package model;

import javax.persistence.*;

@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TEAM_ID")
	private int id;
	@Column(name="CITY")
	private String city;
	@Column(name="NAME")
	private String name;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinColumn(name="LEAGUE_ID")
	private League league;

	public Team() { super(); }

	public Team(String city, String name, League league) {
		super();
		this.city = city;
		this.name = name;
		this.league = league;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	
	public void setLeague(League league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return id + " " + city + ", " + name + ", " + league.getSport();
	}
	
	
}
