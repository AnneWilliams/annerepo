package fr.istic.tpjpa.domain;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class home implements Serializable {

private long id;	
private String adresse;
private Integer superficie;
private String adresse_ip;
private List<person> personn = new ArrayList<person>();

private List<heater> heaters= new ArrayList<heater>();
private List<ElectronicDevice> electronicdevices= new ArrayList<ElectronicDevice>();

public home () {
	
}

public home (String adresse, Integer superficie, String adresse_ip,List<person> personn) {
	this.adresse=adresse;
	this.adresse_ip=adresse_ip;
	this.superficie=superficie;
	this.personn=personn;
	
	
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


public home (String adresse) {
	this.adresse=adresse;
}



@OneToMany
public List<person> getPersonn() {
	return personn;
}

public void setPersonn(List<person> personn) {
	this.personn = personn;
}



@OneToMany(mappedBy="hom", cascade=CascadeType.PERSIST)
public List<heater> getHeaters() {
	return heaters;
}

public void setHeaters(List<heater> heaters) {
	this.heaters = heaters;
}

@OneToMany(mappedBy="hom", cascade=CascadeType.PERSIST)
public List<ElectronicDevice> getElectronicdevices() {
	return electronicdevices;
}

public void setElectronicdevices(List<ElectronicDevice> electronicdevices) {
	this.electronicdevices = electronicdevices;
}



}
