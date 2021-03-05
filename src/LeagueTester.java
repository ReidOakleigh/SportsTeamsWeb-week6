import java.util.List;

import controller.LeagueHelper;
import controller.TeamHelper;
import model.League;
import model.Team;

public class LeagueTester {

	public static void main(String[] args) {
		new LeagueTester().go();
	}

	private void go() {
		LeagueHelper lh = new LeagueHelper();
		TeamHelper sth = new TeamHelper();
		
		Team team1;
		
		League l = lh.findLeagueBySport("NFL");
		team1 = new Team("Chicago", "Bears", l);
		sth.insertTeam(team1);
		team1 = new Team("Cleveland", "Browns", l);
		sth.insertTeam(team1);
		l = lh.findLeagueBySport("MLB");
		team1 = new Team("Chicago", "Cubs", l);
		sth.insertTeam(team1);
		team1 = new Team("Chicago", "White Sox", l);
		sth.insertTeam(team1);
		
		
		
		List<League> leagues;
		
		leagues = lh.showAllLeagues();
		for (League league : leagues) {
			System.out.println(league);
			List<Team> teams = league.getListOfTeams();
			if (!teams.isEmpty()) {
				for (Team t : teams) {
					System.out.println("\t" + t);
				}
			}
			System.out.println();
		}
		System.out.println();
				
		List<Team> teams = sth.showAllTeams();
		for (Team team : teams) {
			System.out.println(team);
		}
	}

}
