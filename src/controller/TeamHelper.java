package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.League;
import model.Team;

public class TeamHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeams"); 
	
	public void insertTeam(Team st) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(st);
		League league = em.find(League.class, st.getLeague().getId());
		league.addTeam(st);
		em.merge(league);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Team> showAllTeams(){
		EntityManager em = emfactory.createEntityManager();
		return (List<Team>) em.createQuery("SELECT st FROM Team st").getResultList();
	}

	public Team deleteTeam(Team toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = 
				em.createQuery("select st from Team st where st.city = :selectedcity and st.name = :selectedname", Team.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedcity", toDelete.getCity());
		typedQuery.setParameter("selectedname", toDelete.getName());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		Team result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		return result;
		
	}

	public void updateTeam(Team toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public Team searchForTeamById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team found = em.find(Team.class, idToEdit);
		em.close();
		return found;
	}

	public List<Team> searchForTeamByCity(String city) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = 
				em.createQuery("select st from Team st where st.city = :selectedcity", Team.class);
		typedQuery.setParameter("selectedcity", city);
		List<Team> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}

	public List<Team> searchForTeamByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = 
				em.createQuery("select st from Team st where st.name = :selectedname", Team.class);
		typedQuery.setParameter("selectedname", name);
		List<Team> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public void cleanUp() {
		emfactory.close();
	}


}
