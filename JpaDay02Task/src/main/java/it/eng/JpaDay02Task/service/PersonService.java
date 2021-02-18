package it.eng.JpaDay02Task.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.eng.JpaDay02Task.entity.City;
import it.eng.JpaDay02Task.entity.Person;

public class PersonService {
	private EntityManagerFactory emf;

	public PersonService(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public Person save(Person person) throws Exception {
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			City city = em.find(City.class, person.getBornCity().getNumber());

			if (city == null) {
				em.persist(person.getBornCity());
			}

			person = em.merge(person);

			em.getTransaction().commit();
			System.out.println("ID: " + person.getId());
			return person;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	
	public void printAll() {
		EntityManager em = emf.createEntityManager();
		List<Person> persons = em.createQuery("SELECT p FROM Person p").getResultList();
		
		for (Person person : persons) {
			System.out.println(person);
		}
		
		em.close();
	}
}
