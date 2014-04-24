package fr.istic.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.client.GreetingService;
import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	
	EntityManager manager;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		manager = EMF.get().createEntityManager();
		
	}
	
	@Override
	public Person createPerson(String name, String firstName) {
		Person p = new Person(name, firstName);
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(p);
		t.commit();
		
		return p;
	}
	
	@Override
	public Home createHome(String adresse, Integer superficie, String adresse_ip) {
		Home h = new Home(adresse, superficie, adresse_ip);
		EntityTransaction t =  manager.getTransaction();
		if (!t.isActive())
			t.begin();
		manager.persist(h);
		t.commit();
		
		return h;
	}
	
	public List<Person> listAllPerson(){
		List<Person> res = new ArrayList<>();
		res.addAll(manager.createQuery("select p from Person as p",Person.class).getResultList());
		return res;
		
	}
	
	public List<Home> listAllHome(){
		List<Home> resu = new ArrayList<>();
		resu.addAll(manager.createQuery("select h from Home as h",Home.class).getResultList());
		return resu;
		
	}
}
