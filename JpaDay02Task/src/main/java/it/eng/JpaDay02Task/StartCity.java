package it.eng.JpaDay02Task;

import javax.persistence.Persistence;

import it.eng.JpaDay02Task.entity.City;
import it.eng.JpaDay02Task.service.CityService;

public class StartCity {
	private final CityService cityService;
	
	public StartCity() {
		cityService = new CityService(Persistence.createEntityManagerFactory("JpaDay02Task"));
	}
	
    public static void main( String[] args )
    {
    	StartCity startCity = new StartCity();
    	startCity.save(22000L, "Subotica");
    }

	private void save(long number, String name) {
		City city = new City();
		city.setNumber(number);
		city.setName(name);
		
		try {
			city = cityService.save(city);
			if (city != null) {
				System.out.println("City je sacuvan...");
				System.out.println(city);
			} else {
				System.out.println("City vec postoji...");
			}
		} catch (Exception e) {
			System.out.println("Main: greska -> " + e.getMessage());
		}
	}
}
