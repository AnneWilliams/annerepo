package fr.istic.miage.tpnosql.main;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

import fr.istic.miage.tpnosql.domain.Address;
import fr.istic.miage.tpnosql.domain.Person;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws UnknownHostException {

		Morphia morphia = new Morphia();
		Mongo mongo = new Mongo();

		morphia.map(Person.class).map(Address.class);

		Datastore ds = morphia.createDatastore(mongo, "my_database");

		Person p = new Person();

		p.setName("Anne");

		Address address1 = new Address();

		address1.setStreet("123 Some street");

		address1.setCity("Some city");

		address1.setPostCode("123 456");

		address1.setCountry("Some country");

		// set address

		p.addAddresses(address1);

		// Save the POJO

		ds.save(address1);
		ds.save(p);

		for (Person e : ds.find(Person.class))

			System.err.println("hello: " + e);

	}
}
