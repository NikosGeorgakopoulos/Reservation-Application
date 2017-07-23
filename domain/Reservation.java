package domain;

import java.util.ArrayList;
import java.util.Date;



public class Reservation {
	private Client client;
	private ArrayList<Sectrange> Suggestions = new ArrayList<Sectrange>();
	private  ArrayList<Performance> Performances = new ArrayList<Performance>();
	private  ArrayList<Seat> Seats = new ArrayList<Seat>();
	private Performance Performance;
	private Payment Payment;
	private Seat Seat;
	private int code;
	private int requested_seats; 
	private Sectrange rangeofseats;

	/**
	 * Methdos pou epistrefei tis krathmenes theseis
	 * @param Seats
	 * @param AvailableSeats
	 * @return
	 */
public int getReserved(ArrayList<Seat>Seats,ArrayList<Seat> AvailableSeats){
		
		return Seats.size() - AvailableSeats.size();
	}


public void CreatePayment(){
	
	Date now = new Date();
	
	Payment.setDateOfPayment(now);
	Payment.setAmount(Performance.getPrice().getAmount());
	
	}

/**
 * Methodos gia euresh anazhtoumenhs parastashs
 * dhmiourgei ena antikeimeno Performance 
 * Psaxnei oles tis parastaseis 
 * kai molis brei parastash me idio titlo me to title
 * thn epistrefei 
 * 
 * @param title
 * @return Performance
 */
public Performance findPerformance(String title){
	Performance Performance = new Performance();
	for(int i = 0;i < Performances.size();i++){
		if (Performances.get(i).getTitle() == title){
		Performance = Performances.get(i);
		}
	}
	
	return Performance;
}


public void AddPerformance(Performance p1){
	Performances.add(p1);
}

public void FindSeats(){
	Performance.FindSeats();
}

public void ReserveSeats(){
	
	setSuggestions(Performance.ReserveSeats(requested_seats));
}



public Seat getSeat(){
	return Seat;
}



public int getCode(){
	return code;
}

public void setCode(int code) {
	this.code = code;
}





public Client getClient() {
	return client;
}





public void setClient(Client client) {
	this.client = client;
}





public Payment getPayment() {
	return Payment;
}





public void setPayment(Payment payment) {
	this.Payment = payment;
}





public Performance getPerformance() {
	return Performance;
}





public void setPerformance(Performance performance) {
	this.Performance = performance;
}


public ArrayList<Seat> getSeats() {
	return Seats;
}


public void setSeats(ArrayList<Seat> seats) {
	Seats = seats;
}


public int getRequested_seats() {
	return requested_seats;
}


public void setRequested_seats(int requested_seats) {
	this.requested_seats = requested_seats;
}


public Sectrange getRangeofseats() {
	return rangeofseats;
}


public void setRangeofseats(Sectrange rangeofseats) {
	this.rangeofseats = rangeofseats;
}


public ArrayList<Sectrange> getSuggestions() {
	return Suggestions;
}


public void setSuggestions(ArrayList<Sectrange> suggestions) {
	Suggestions = suggestions;
}

/**
 * Dhmioyrgia pelath 
 * @param fname
 * @param lname
 * @param mail
 */
public void CreateClient(String fname,String lname,Email mail){
	
	client.setName(fname);
	client.setSurname(lname);
	client.setMail(mail);
	
}

public void setPerformances(ArrayList<Performance> p1){
	Performances = p1;
}

public ArrayList<Performance> getPerformances(){
	return Performances;
}


}




