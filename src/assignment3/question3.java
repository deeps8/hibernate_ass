package assignment3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class question3 {

	public static void main(String[] args) {
		book bookw = new book();
		bookw.setBname("book-45");
		
		
		AuthorName aname = new AuthorName();
		aname.setFname("rahul");
		aname.setLname("baniya");
		
		author a = new author();
		a.setName(aname);		//set the author name embeddable column
		a.setAge(50);
		a.setBookw(bookw);		//set the bookw - foreign key
		bookw.setAid(a);;		//set the aid - foreign key 
		
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
