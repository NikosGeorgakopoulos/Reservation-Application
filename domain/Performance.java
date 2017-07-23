package domain;


import java.util.ArrayList;
import java.util.Date;




public class Performance   {
	
	private ArrayList<Reservation> Consecutive = new ArrayList<Reservation>();
	private ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
	
	private Reservation reservation; 
	private Play play;
	private Lobby lobby;
	private boolean sold_out;
	private Date date;
	

	

	public boolean isSold_out() {
		return sold_out;
	}
 
	public void setSold_out(boolean sold_out) {
		this.sold_out = sold_out;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTitle(){
		return getPlay().getTitle();
	}
	
	public void setTitle(String title){
		getPlay().setTitle(title);
	}
	
	public String[] getActors(){
		return getPlay().getActors();
	}
	
	public void setActors(String[] actors){
		getPlay().setActors(actors);
	}
	
	public String[] getDirectors(){
		return getPlay().getDirectors();
	}
	
	public void setDirectors(String[] directors){
		getPlay().setDirectors(directors);
	}
	
	public Money getPrice(){
		return getPlay().getPrice();
	}
	
	public void setPrice(Money price){
		getPlay().setPrice(price);
	}
	
	public void setType(PerformanceType type){
		getPlay().setType(type);
	}
	
	public PerformanceType getType(){
		return getPlay().getType();
	}
	
	
	
	public void setLobby(Lobby lobby){
		
		this.lobby = lobby;
	}
		
	
	
	public Lobby getLobby(){
		return lobby;
	}
	
	/**
	 * Void methodos h opoia dhmiourgei mi kainoyria krathsh
	 * @param code
	 * @param client
	 * @param payment
	 */
	
	public  void makeReservation(int code,Client client,Payment payment){
		Reservation r = new Reservation();
		r.setCode(code);
		r.setClient(client);
		r.setPerformance(this);
		r.setPayment(payment);
		setReservation(r);
		lobby.setUnavailable(code);
		Reservations.add(r);
	}
	
	/**
	 * Dhmiourgia listas me ths krathseis enos pelath 
	 * gia theseis me diadoxikous kodikous 
	 * kai tis thetei ws synexomenes   
	 * @param range
	 * @param client
	 * @param payment
	 */
	
	public void makeReservations(Sectrange range,Client client,Payment payment){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		for(int i= range.getFrom().getCode(); i <= range.getTo().getCode(); i++){
			makeReservation(i,client,payment);
			list.add(getReservation());
			
			}
		setConsecutive(list);
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

	public void FindSeats() {
		lobby.FindSeats();
		
	}

	public ArrayList<Sectrange> ReserveSeats(int x) {
		
		return lobby.ConsecutiveSeatSelector(x);
		
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public ArrayList<Reservation> getConsecutives(){
		return Consecutive;
	}
	
	public void setConsecutive(ArrayList<Reservation> list){
		this.Consecutive = list;
	}
	
	public void setReservations(ArrayList<Reservation> list){
		this.Reservations = list;
	}
	
	public ArrayList<Reservation> getReservations(){
		return Reservations;
	}

	

}



