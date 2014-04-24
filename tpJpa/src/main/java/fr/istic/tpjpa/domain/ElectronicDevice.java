package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice {

	private long id;
	private String marque;
	private int price;
	private person personn;

	public ElectronicDevice() {

	}

	public ElectronicDevice(String marque, int price) {
		this.marque = marque;
		this.price = price;

	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@ManyToOne
	public person getPersonn() {
		return personn;
	}

	public void setPersonn(person personn) {
		this.personn = personn;
	}

}
