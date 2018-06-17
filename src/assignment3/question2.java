package assignment3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class question2 {

	public static void main(String[] args) {
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(author.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg); 		//interface so on object 
		
		Session session = sf.openSession();		//interface so no object 
		 
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		session.close();

	}

}
