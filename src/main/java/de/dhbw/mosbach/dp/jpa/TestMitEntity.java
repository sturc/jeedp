package de.dhbw.mosbach.dp.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMitEntity {
	public static void main(String[] args) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the
											// configuration file

		// creating session factory object
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object

		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();

		Mitarbeiter m1 = new Mitarbeiter();
		m1.setPersnr(115);
		m1.setVorname("sonoo");
		m1.setNachname("jaiswal");

		session.persist(m1);// persisting the object

		t.commit();// transaction is committed
		session.close();

		System.out.println("successfully saved");

	}

}
