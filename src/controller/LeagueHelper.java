package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.League;

public class LeagueHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeams"); 
	
	public void insertLeague(League league) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(league);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<League> showAllLeagues(){
		EntityManager em = emfactory.createEntityManager();
		return (List<League>) em.createQuery("SELECT l FROM League l").getResultList();
	}
	
	public League findLeagueById(int id) {
		EntityManager em = emfactory.createEntityManager();
		return em.find(League.class, id);
	}
	
	public League findLeagueBySport(String sport) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<League> typedQuery = 
				em.createQuery("select l from League l where l.sport = :selectedSport", League.class);
		typedQuery.setParameter("selectedSport", sport);
		List<League> foundLeague = typedQuery.getResultList();
		em.close();
		if (foundLeague.isEmpty()) return null;
		return foundLeague.get(0);
	}

	public void updateLeague(League league) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(league);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteLeagueById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		League league = em.find(League.class, id);
		em.remove(league);
		em.getTransaction().commit();
		em.close();
	}

}
