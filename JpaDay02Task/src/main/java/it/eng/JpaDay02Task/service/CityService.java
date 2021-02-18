package it.eng.JpaDay02Task.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.JpaDay02Task.entity.City;

public class CityService {
	private EntityManagerFactory emf;

	public CityService(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public City save(City city) throws Exception {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			City c = em.find(City.class, city.getNumber());
			if (c == null) {
				em.persist(city);
			}
			
			c = em.merge(city);
			
			em.getTransaction().commit();
			System.out.println("ID: " + c.getId());
			return c;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error: " + e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}
}
