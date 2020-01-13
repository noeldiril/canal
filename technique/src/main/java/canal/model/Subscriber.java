package canal.model;

import java.util.ArrayList;

public class Subscriber {
	
	private String id;
	private String firstname;
	private String lastname;
	private String adress;
	private ArrayList<Contracts> contracts = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public ArrayList<Contracts> getContracts() {
		return contracts;
	}
	public void setContracts(ArrayList<Contracts> contracts) {
		this.contracts = contracts;
	}
	
	public Subscriber() {
		
	}
	
	public Subscriber(String id, String firstname) {
		this.id=id;
		this.firstname=firstname;
	}
	
	public Subscriber(String id, String firstname,Contracts contract) {
		this.id=id;
		this.firstname=firstname;
		this.contracts.add(contract);
	}

}
