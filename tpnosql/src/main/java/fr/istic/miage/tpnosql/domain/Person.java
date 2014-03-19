package fr.istic.miage.tpnosql.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;
import org.bson.types.*;

@Entity("personnes")
public class Person {

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", addresses="
				+ addresses + "]";
	}
	@Id private ObjectId id;
	private String name;
	
	
	@Reference private List<Address> addresses = new ArrayList<Address>();
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void addAddresses(Address address) {
		this.addresses.add(address);
	}

	
	
	
	
}
