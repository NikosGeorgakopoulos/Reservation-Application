package domain;

import java.util.ArrayList;


public class Lobby {
	
	
	private  ArrayList<Seat> AvailableSeats = new ArrayList<Seat>();

	private  ArrayList<Sectrange> Consecutives = new ArrayList<Sectrange>();

	private  ArrayList<Seat> Seats = new ArrayList<Seat>();
	
	private  ArrayList<Sectrange> Suggestions = new ArrayList<Sectrange>();
	
	
	
	
	private int code;
	private int NumOfSeats;

	public void AddSeats(Seat s){
		if(Seats.size() < getNumOfSeats()){
			Seats.add(s);
		}
		
		
		
	}

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getNumOfSeats() {
		return NumOfSeats;
	}

	public void setNumOfSeats(int NumOfSeats) {
		this.NumOfSeats = NumOfSeats;
	}

	public ArrayList<Seat> getSeats() {
		return Seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		Seats = seats;
	}
	
	public  ArrayList<Sectrange> ConsecutiveSeatSelector(int x) {
		 ArrayList<Sectrange> list = new  ArrayList<Sectrange>();
		for (int i = 0; i < Consecutives.size(); i ++){
			
			if (Consecutives.get(i).getSize() >= x){
				list.add(Consecutives.get(i));
			}
		}
		return list;
	}

	/**
	 * methodos pou briskei diadoxikes diathesimes theseis 
	 * kai tis topothetei sth lista Consecutives
	 *  
	 */
	public  void FindConsecutiveSeats() {
		 Seat From = null;
		 Seat To = null;
		 
		 int counter = 1;
		 
			for(int i = 1; i < AvailableSeats.size(); i++){
				if(AvailableSeats.get(i).getCode() - AvailableSeats.get(i-1).getCode() <= 1) {
					From = AvailableSeats.get(i-1);
					To = AvailableSeats.get(i);
					counter = i;
					
					while (AvailableSeats.get(counter).getCode() - AvailableSeats.get(counter-1).getCode() == 1  && counter < AvailableSeats.size() -1){
						To = AvailableSeats.get(counter);
						
						counter +=1;
					}
					Sectrange r = new Sectrange(From,To,To.getCode() - From.getCode());
					
					Consecutives.add(r);
								
				}				
			}
			

	}

	/**
	 * Methodos pou briskei diathesimes theseis
	 * 
	 */

	public void FindSeats() {
		for(int i = 0; i < Seats.size(); i++){
			if(Seats.get(i).isAvailable()){
				AvailableSeats.add(Seats.get(i));
			}
		}
		
	}
	
	public ArrayList<Seat> getAvailableSeats(){
		return AvailableSeats;
	}

	/**
	 * methodos pou allazei thn diathesimothta mias theshs apo true se false 
	 * an o kodikos ths tairiazei me ayton ths parametrou
	 * @param code
	 */
	public void setUnavailable(int code) {
		for(int i =0;i < Seats.size();i++){
			if (Seats.get(i).getCode() == code){
				Seats.get(i).setAvailable(false);				
			}
		}
		
	}
	
	
	public ArrayList<Sectrange> getConsecutiveSeats(){
		return Consecutives;
	}
	
	public void setConsecutivSeats(ArrayList<Sectrange> consecutives){
		Consecutives = consecutives;
	}
	
	public ArrayList<Sectrange> getSuggestions(){
		return Suggestions;
	}
	
	public void setSuggestions(ArrayList<Sectrange> suggestions){
		Suggestions = suggestions;
	}
	/**
	 * methodos pou kanei mia thesh diathesimh
	 * an o kodikos ths tairiazei me ayton ths parametrou
	 * @param code
	 */
	public Boolean RetrieveSeatState(int code){
		
		for(int i = 0; i < Seats.size(); i++){
			if(Seats.get(i).getCode() == code){
				return Seats.get(i).isAvailable();
			}
		}
		return null;
	}
	/**
	 * methodos pou epistrefei tis krathmenes theseis
	 * @return
	 */
	public int getReservedSeats(){
		return Seats.size() - AvailableSeats.size();
	}
}
		
		
