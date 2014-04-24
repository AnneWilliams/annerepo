package fr.istic.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void createPerson(String name, String firstName,
			AsyncCallback<Person> callback);
	
	void listAllPerson(AsyncCallback<List<Person>> callback);
	
	void createHome(String adresse, Integer superficie, String adresse_ip,AsyncCallback<Home> callback);
	
	void listAllHome(AsyncCallback<List<Home>> callback);
}
