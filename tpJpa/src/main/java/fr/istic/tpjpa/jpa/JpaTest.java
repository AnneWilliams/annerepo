package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.ElectronicDevice;
import fr.istic.tpjpa.domain.heater;
import fr.istic.tpjpa.domain.home;
import fr.istic.tpjpa.domain.person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		// TODO create entity
		person personne1=new person();
		person personne2=new person();
		person personne3=new person();
		person personne4=new person();
		
		personne1.setNom("william");
		personne1.setPrenom("anne");
		personne1.setGenre("femme");
		personne1.setMail("annewilliam@gmail.com");
		personne1.setDate_naiss(null);
		personne1.setProfil_fb("anne");
		
		personne2.setNom("sene");
		personne2.setPrenom("abdoulaye");
		personne2.setGenre("homme");
		personne2.setMail("sene@gmail.com");
		personne2.setDate_naiss(null);
		personne2.setProfil_fb("sene");
		
		
		personne3.setNom("ndiaye");
		personne3.setPrenom("modou");
		personne3.setGenre("homme");
		personne3.setMail("modou@gmail.com");
		personne3.setDate_naiss(null);
		personne3.setProfil_fb("modou");
		
		personne4.setNom("pouye");
		personne4.setPrenom("issa");
		personne4.setGenre("homme");
		personne4.setMail("pouye@gmail.com");
		personne4.setDate_naiss(null);
		personne4.setProfil_fb("issa");
		
		List<person> amis = new ArrayList<person>();
		amis.add(personne2);
		amis.add(personne3);
		amis.add(personne4);
		
		personne1.setPersonn(amis);
		
		
		
		home maison1=new home();
		maison1.setAdresse("beaulieu");
		maison1.setSuperficie(9); 
		maison1.setAdresse_ip("199.88.77.87");
		
		home maison2=new home();
		maison2.setAdresse("dakar");
		maison2.setSuperficie(200); 
		maison2.setAdresse_ip("199.80.77.87");
		
		List<home> maisons = new ArrayList<home>();
		maisons.add(maison1);
		maisons.add(maison2);
		
		personne1.setHom(maisons);
		
		
		ElectronicDevice electro1= new ElectronicDevice();
		electro1.setMarque("samsung");
		electro1.setPrice(1000);
		
		ElectronicDevice electro2= new ElectronicDevice();
		electro2.setMarque("toshiba");
		electro2.setPrice(2000);
		
		
		List<ElectronicDevice> electronicdevices= new ArrayList<ElectronicDevice>();
		electronicdevices.add(electro1);
		electronicdevices.add(electro2);
		
		maison1.setElectronicdevices(electronicdevices);
		
		heater heater1= new heater();
		heater1.setMarque("nokia");
		heater1.setPrice(800);
		
		heater heater2= new heater();
		heater2.setMarque("hp");
		heater2.setPrice(500);
		
		List<heater> heaters= new ArrayList<heater>();
		heaters.add(heater1);
		heaters.add(heater2);
		
		maison1.setHeaters(heaters);
		
		
		// TODO persist entity

		manager.persist(personne1);
		
		
		personne1.setNom("annie");
		tx.commit();
		test.ajoutpersonne();

		// TODO run request

		System.out.println(".. done");
	}

	
	private void ajoutpersonne() {
		List<person> resultList = manager.createQuery("Select p From person p", person.class).getResultList();
		System.out.println("num of person:" + resultList.size());
		for (person next : resultList) {
			System.out.println("next person: " + next);
		}

}
	
}
