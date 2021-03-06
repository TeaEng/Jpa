package it.eng.JpaDay02Task.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 18022021112200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long number;
	private String name;
	
	public City() {
		super();
	}
	
	public City(Long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public City(Long id, Long number, String name) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", number=" + number + ", name=" + name + "]";
	}
}
