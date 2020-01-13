package canal.model;

import java.time.LocalDateTime;

public class Contracts {

	String id;
	String adress;
	private LocalDateTime startingTime = LocalDateTime.now();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public LocalDateTime getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(LocalDateTime startingTime) {
		this.startingTime = startingTime;
	}

	public Contracts() {

	}

	public Contracts(String id, String adress) {
		this.id=id;
		this.adress=adress;
	}

}
