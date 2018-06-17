package assignment3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class question2 {

	public static void main(String[] args) {
		
		book bookw = new book();
		bookw.setBname("book-101");
		
		AuthorName aname = new AuthorName();
		aname.setFname("raka");
		aname.setLname("divine");
		
		author a = new author();
		a.setName(aname);		//set the author name embeddable column
		a.setAge(25);
		a.setBookw(bookw);		//set the bookw - foreign key
		
		Configuration con = new Configuration().configure().addAnnotatedClass(author.class).addAnnotatedClass(book.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg); 		//interface so on object 
		
		Session session = sf.openSession();		//interface so no object 
		 
		Transaction tx = session.beginTransaction();
		
		session.save(a);
		session.save(bookw);
		tx.commit();
		session.close();

	}

}
