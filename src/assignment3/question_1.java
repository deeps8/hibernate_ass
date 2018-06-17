//To create Author and Inserting 10 rows in Author table 
package assignment3;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

public class question_1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(author.class).addAnnotatedClass(book.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg); 		//interface so on object 
		
		 Session session = sf.openSession();		//interface so no object 
		 
		 Transaction tx = session.beginTransaction();
		 
		 for(int i=0;i<10;i++)
		 {	 
			 AuthorName aname = new AuthorName();
			 author a = new author();
			 
			 System.out.println("Enter Author First name :");
			 aname.setFname(in.next());
			 
			 System.out.println("Enter Author Last name :");
			 aname.setLname(in.next());
			 
			 System.out.println("Enter age of Author :");
			 a.setAge(in.nextInt());
			 
			 a.setName(aname); 				// Author name is set here to author 
			 
			 session.save(a);
		 }
		 
		 for(int i=0;i<10;i++) {
			 
			 book b = new book();
			 
			 System.out.println("Enter book name : ");
			 b.setBname("book-"+i+1);
			 
			 session.save(b);
		 }
		 
		 
		 
		 tx.commit();
		 session.close();
	}

}
