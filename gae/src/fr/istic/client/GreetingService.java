package fr.istic.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	Person createPerson(String name, String firstName);
	 List<Person> listAllPerson();
	Home createHome(String adresse, Integer superficie, String adresse_ip);
	List<Home> listAllHome();
}
