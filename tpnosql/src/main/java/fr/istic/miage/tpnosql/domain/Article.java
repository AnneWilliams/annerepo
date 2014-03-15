package fr.istic.miage.tpnosql.domain;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;


public class Article {

	
	private String name;
	private int stars;
	private List<Person> personne = new ArrayList<Person>();
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public List<Person> getPersonne() {
		return personne;
	}

	public void setPersonne(List<Person> personne) {
		this.personne = personne;
	}
	
	
	

}
