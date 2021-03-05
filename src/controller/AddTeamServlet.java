package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;
import model.Team;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		String name  = request.getParameter("name");
		String sport = request.getParameter("sport");
		TeamHelper dao = new TeamHelper();
		LeagueHelper lh = new LeagueHelper();
		League league = lh.findLeagueBySport(sport);
		Team st = new Team(city, name, league);
		dao.insertTeam(st);		// insert team
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
	/**
	 * @see HttpServlet#doGett(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeagueHelper lh = new LeagueHelper();
		List<League> allLeagues = lh.showAllLeagues();
		request.setAttribute("allLeagues", allLeagues);
		getServletContext().getRequestDispatcher("/add-team.jsp").forward(request, response);		
	}
}
