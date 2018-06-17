package assignment3;

import javax.persistence.*;

@Entity
public class author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	
	private AuthorName name;
	
	private int age;
	
	@OneToOne
	private book bookw;
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public AuthorName getName() {
		return name;
	}

	public void setName(AuthorName name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public book getBookw() {
		return bookw;
	}

	public void setBookw(book bookw) {
		this.bookw = bookw;
	}

	@Override
	public String toString() {
		return "author [aid=" + aid + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
