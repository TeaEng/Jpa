package it.eng.JpaDay02Task;

import javax.persistence.Persistence;

import it.eng.JpaDay02Task.entity.City;
import it.eng.JpaDay02Task.entity.Person;
import it.eng.JpaDay02Task.service.PersonService;

public class StartPerson {
	private final PersonService personService;

	public StartPerson() {
		personService = new PersonService(Persistence.createEntityManagerFactory("JpaDay02Task"));
	}

	public static void main(String[] args) {
		StartPerson startPerson = new StartPerson();
		//startPerson.save(5L, 1111222233334L, "firstname - 1", "lastname - 1", 11000l, "Beograd");
		startPerson.printAll();
	}

	private void save(Long personId, Long idnId, String firstname, String lastname, long cityNumber, String cityName) {
		City city = new City(cityNumber, cityName);
		Person person = new Person();
		person.setId(personId);
		person.setPersonalIdentityNumber(idnId);
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setBornCity(city);

		try {
			person = personService.save(person);
			System.out.println("Osoba je sacuvana...");
			System.out.println(person);
		} catch (Exception e) {
			System.out.println("MAIN: greska -> " + e.getMessage());
		}
	}
	
	private void printAll() {
		personService.printAll();
	}
}
