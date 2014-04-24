package fr.istic.tpjpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class home implements Serializable {

	private long id;
	private String adresse;
	private Integer superficie;
	private String adresse_ip;
	private person personn;

	private List<heater> heaters;
	private ElectronicDevice electro;

	public home() {

	}

	public home(String adresse, Integer superficie, String adresse_ip) {
		this.adresse = adresse;
		this.adresse_ip = adresse_ip;
		this.superficie = superficie;

	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}

	public String getAdresse_ip() {
		return adresse_ip;
	}

	public void setAdresse_ip(String adresse_ip) {
		this.adresse_ip = adresse_ip;
	}

	public home(String adresse) {
		this.adresse = adresse;
	}

	@ManyToOne
	public person getPersonn() {
		return personn;
	}

	public void setPersonn(person personn) {
		this.personn = personn;
	}

	@OneToMany(mappedBy = "hom", cascade = CascadeType.PERSIST)
	public List<heater> getHeaters() {
		return heaters;
	}

	public void setHeaters(List<heater> heaters) {
		this.heaters = heaters;
	}

}
