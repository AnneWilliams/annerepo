package fr.istic.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.datanucleus.api.jpa.annotations.Extension;

@Entity
public class Home implements Serializable {


	private static final long serialVersionUID = -8853790854567956705L;
	private long id;	
	private String adresse;
	private Integer superficie;
	private String adresse_ip;
	private Person personne;

	//private List<heater> heaters;
	//private ElectronicDevice electro;

	public Home () {
		
	}

	public Home (String adresse, Integer superficie, String adresse_ip) {
		this.adresse=adresse;
		this.adresse_ip=adresse_ip;
		this.superficie=superficie;
		
		
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName="datanucleus", key = "gae.encoded-pk", value = "true")
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


	public Home (String adresse) {
		this.adresse=adresse;
	}



	@ManyToOne
	public Person getPersonn() {
		return personne;
	}

	public void setPersonn(Person personne) {
		this.personne = personne;
	}



	//@OneToMany(mappedBy="hom", cascade=CascadeType.PERSIST)
	//public List<heater> getHeaters() {
		//return heaters;
	//}

	//public void setHeaters(List<heater> heaters) {
		//this.heaters=heaters;
	//}




	

}
