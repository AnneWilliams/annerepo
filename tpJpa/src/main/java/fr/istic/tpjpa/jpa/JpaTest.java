package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		List<person> amis1 = new ArrayList<person>();
		// amis1.add(personne2);

		List<person> amis2 = new ArrayList<person>();
		// amis2.add(personne1);

		person personne1 = new person("william", "anne", "femme",
				"annewilliam@gmail.com", null, "anne");
		person personne2 = new person("sene", "abdoulaye", "homme",
				"sene@gmail.com", null, "sene");

		personne1.getAmis().add(personne2);

		home maison1 = new home("beaulieu", 9, "199.88.77.87");
		home maison2 = new home("dakar", 200, "199.80.77.87");

		personne1.getHom().add(maison1);
		personne1.getHom().add(maison2);
		maison1.setPersonn(personne1);
		maison2.setPersonn(personne1);

		ElectronicDevice electro1 = new ElectronicDevice("samsung", 1000);
		ElectronicDevice electro2 = new ElectronicDevice("toshiba", 2000);

		personne1.getElectro().add(electro2);
		electro2.setPersonn(personne1);

		heater heater1 = new heater("nokia", 800);
		heater heater2 = new heater("hp", 500);

		// maison1.getHeaters().add(heater2);
		// heater2.setHom(maison1);

		// TODO persist entity

		manager.persist(personne1);
		manager.persist(personne2);
		manager.persist(maison1);
		manager.persist(maison2);
		manager.persist(electro1);
		manager.persist(electro2);
		manager.persist(heater1);
		manager.persist(heater2);

		tx.commit();

		System.out.println(".. done");

		
		test.listPerson();
		test.listHome();
		test.listHeater();
		test.listElectronicDevice();
	}

	// TODO run request
	public void listPerson() {

		List<person> resultList = manager.createQuery("select p from person p",
				person.class).getResultList();
		System.out.println("number of persons:" + resultList.size());
		for (person next : resultList) {
			System.out.println("next person: " + next.toString());
		}
	}

	public void listHome() {

		List<home> resultList = manager.createQuery("select h from home h",
				home.class).getResultList();
		System.out.println("number of homes:" + resultList.size());
		for (home next : resultList) {
			System.out.println("next home: " + next.toString());
		}
	}

	public void listHeater() {

		List<heater> resultList = manager.createQuery(
				"select he from heater he", heater.class).getResultList();
		System.out.println("number of heaters:" + resultList.size());
		for (heater next : resultList) {
			System.out.println("next heater: " + next.toString());
		}
	}

	public void listElectronicDevice() {

		List<ElectronicDevice> resultList = manager.createQuery(
				"select e from ElectronicDevice e", ElectronicDevice.class)
				.getResultList();
		System.out.println("number of ElectronicDevices:" + resultList.size());
		for (ElectronicDevice next : resultList) {
			System.out.println("next ElectronicDevice: " + next.toString());
		}
	}

}
