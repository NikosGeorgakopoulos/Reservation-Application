package Service;

import domain.Performance;
import domain.Play;
import domain.Money;
import domain.PerformanceType;
import domain.Lobby;
import java.util.ArrayList;
import java.util.Date;

public class PerformancesEditing {
	
	private ArrayList<Performance> Performances = new ArrayList<Performance>();
	
	public void DeletePerformance(Performance p1){
		for(int i = 0; i<Performances.size();i++){
			if(Performances.get(i).getTitle()==p1.getTitle() && Performances.get(i).getDate()== p1.getDate()){
				Performances.remove(i);
			}
		}
	}
	
	public void EditPerformance(Performance p1,String[] actors,double price,Date date,Lobby lobby){
		for(int i = 0; i<Performances.size();i++){
			if(Performances.get(i).getTitle()==p1.getTitle() && Performances.get(i).getDate()== p1.getDate()){
				if(actors!= null){
					Performances.get(i).setActors(actors);
				}
				
				if(price != 0){
					Performances.get(i).getPrice().setAmount(price);
				}
				
				if(date != null){
					Performances.get(i).setDate(date);
				}
				
				if(lobby!= null){
					Performances.get(i).setLobby(lobby);
				}
			}
		}
		
		
	
	}
	
	public void CreatePerformance(String title,String[] actors,String[] directors,PerformanceType type,Money price,Lobby lobby,Date date){
		Play play = new Play(title,actors,directors,type,price);
		Performance p1 = new Performance();
		p1.setPlay(play);
		p1.setLobby(lobby);
		p1.setDate(date);
		Performances.add(p1);
	}
	
	public double getPerformanceprofits(Performance p1){
		
		return p1.getLobby().getReservedSeats() * p1.getPrice().getAmount();
	}
	
	public int getPerformanceReservedSeats(Performance p1){
		return p1.getLobby().getReservedSeats();
	}
	
	public ArrayList<Performance> getPerformances(){
		return Performances;
	}
	
	public void setPerformances( ArrayList<Performance> Performances){
		this.Performances = Performances;
	}

}
