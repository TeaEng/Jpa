package it.eng.JpaDay02Task.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person implements Serializable {
	private static final long serialVersionUID = 18022021115400L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long personalIdentityNumber;
	private String firstname;
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name = "bornCity")
	private City bornCity;

	public Person() {
		super();
	}

	public Person(Long id, Long personalIdentityNumber, String firstname, String lastname, City bornCity) {
		super();
		this.id = id;
		this.personalIdentityNumber = personalIdentityNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bornCity = bornCity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}

	public void setPersonalIdentityNumber(Long personalIdentityNumber) {
		this.personalIdentityNumber = personalIdentityNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public City getBornCity() {
		return bornCity;
	}

	public void setBornCity(City bornCity) {
		this.bornCity = bornCity;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", personalIdentityNumber=" + personalIdentityNumber + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", bornCity=" + bornCity + "]";
	}
}
