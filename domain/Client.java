package domain;
import java.util.ArrayList;

public class Client {
	
	private ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
	private String name;
	private String surname;
	private Email Mail;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Email getMail() {
		return Mail;
	}

	public void setMail(Email mail) {
		Mail = mail;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String name) {
		this.surname = name;
	}

	public ArrayList<Reservation> getReservations() {
		return Reservations;
	}
	
	public Reservation getReservation(int index){
		return Reservations.get(index);
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		Reservations = reservations;
	}
	
	public void addReservation(Reservation r1){
		Reservations.add(r1);
	}
}
