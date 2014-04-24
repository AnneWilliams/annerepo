package fr.istic.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.datanucleus.api.jpa.annotations.Extension;


//import org.datanucleus.api.jpa.annotations.Extension;


@Entity
public class Person implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8853790854567956705L;

	String id;
	
	String name;
	String firstName;
	private List<Home> home = new ArrayList<Home>();

	public Person(String name, String firstName ) {
		super();
		this.name = name;
		this.firstName = firstName;
		
	}


	public Person() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName="datanucleus", key = "gae.encoded-pk", value = "true")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@OneToMany (mappedBy="personn", cascade = CascadeType.PERSIST)
	public List<Home> getHome() {
		return home;

	}

	

	public void setHom(List<Home> home) {
		this.home=home;
	}

}
