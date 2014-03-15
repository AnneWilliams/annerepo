package fr.istic.miage.tpnosql.main;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import fr.istic.miage.tpnosql.domain.Address;
import fr.istic.miage.tpnosql.domain.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws UnknownHostException

	{

	    Morphia morphia = new Morphia();   
	    Mongo mongo= new Mongo();

	    morphia.map(Person.class).map(Address.class);

	    Datastore ds = morphia.createDatastore(mongo, "my_database");

	    //ds.ensureIndexes();
	    //ds.ensureCaps();
	   

	    Person p = new Person();
	    List<Address> addresses = new ArrayList<Address>();

	    p.setName("Tintin");

	    Address address = new Address();

	    address.setStreet("123 Some street");

	    address.setCity("Some city");

	    address.setPostCode("123 456");

	    address.setCountry("Some country");
	   
	    addresses.add(address);
	    //set address

	    p.setAddresses(addresses);

	    // Save the POJO

	    ds.save(p);

	    for (Person e : ds.find(Person.class))

	         System.err.println(e);

	}
}
