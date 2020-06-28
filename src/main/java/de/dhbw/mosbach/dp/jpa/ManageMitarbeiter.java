package de.dhbw.mosbach.dp.jpa;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageMitarbeiter {
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageMitarbeiter mm = new ManageMitarbeiter();

		/* Add few employee records in database */
		Integer empID1 = mm.addEmployee(2000, "Zara", "Ali");
		Integer empID2 = mm.addEmployee(5000, "Duck", "Daisy");
		Integer empID3 = mm.addEmployee(10000, "Ebon", "Paul");

		/* List down all the employees */
		mm.listEmployees();

		/* Update employee's records */
		mm.updateEmployee(empID1, "Duff", "Ali");

		/* Delete an employee from the database */
		mm.deleteEmployee(empID2);

		/* List down new list of the employees */
		mm.listEmployees();
		factory.close();
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(int id, String nachname, String vorname) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Mitarbeiter mit = new Mitarbeiter(id, nachname, vorname);
			session.save(mit);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}

	/* Method to READ all the employees */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Mitarbeiter> mitarbeiter = session.createQuery("FROM Mitarbeiter").list();
			for (Mitarbeiter currMitarbeiter : mitarbeiter) {
				System.out.println(currMitarbeiter.toString());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer persnr, String nachname, String vorname) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Mitarbeiter mit = (Mitarbeiter) session.get(Mitarbeiter.class, persnr);
			mit.setNachname(nachname);
			mit.setVorname(vorname);
			session.update(mit);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer persnr) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Mitarbeiter mit = (Mitarbeiter) session.get(Mitarbeiter.class, persnr);
			session.delete(mit);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
