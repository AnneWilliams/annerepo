package fr.istic.miage.tpnosql.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;
import org.bson.types.*;

@Entity("articles")
public class Article {

	@Id ObjectId id;
	private String name;
	private int stars;
	@Reference private List<Person> personne = new ArrayList<Person>();
	
	

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

	public void addPersonne(Person pers) {
		this.personne.add(pers);
	}
	
	
	

}
