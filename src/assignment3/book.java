package assignment3;

import javax.persistence.*;

@Entity
public class book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	
	private String Bname;
	
	@OneToOne
	private author aid;
	
	public author getAid() {
		return aid;
	}

	public void setAid(author aid) {
		this.aid = aid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return Bname;
	}

	public void setBname(String bname) {
		Bname = bname;
	}

	@Override
	public String toString() {
		return "book [bid=" + bid + ", Bname=" + Bname + "]";
	}
	
}
