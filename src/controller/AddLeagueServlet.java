package controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

/**
 * Servlet implementation class AddLeagueServlet
 */
@WebServlet("/addLeagueServlet")
public class AddLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLeagueServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGett(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeagueHelper lh = new LeagueHelper();
		String path = "/league-list.jsp";
		List<League> leagues = lh.showAllLeagues();
		request.setAttribute("leagues", leagues);
		if (leagues.isEmpty()) path="/index.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leagueId = request.getParameter("leagueId");
		String name = request.getParameter("leagueName");
		String hallOfFame = request.getParameter("hallOfFame");
		LeagueHelper lh = new LeagueHelper();
		lh.insertLeague(new League(leagueId, name, hallOfFame));
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
