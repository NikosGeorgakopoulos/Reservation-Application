package seats.ui;

import java.util.ArrayList;

import domain.Performance;
import domain.Seat;
import domain.Sectrange;
import reservation.ui.ReservationPresenter;

public class MultipleSeatsPresenter {
	
	private MultipleSeatsView view;
	private Performance performance;
	private int requestedseats; 
	
	private ReservationPresenter rootPresenter;
	
	public MultipleSeatsPresenter(MultipleSeatsView view,ReservationPresenter rootPresenter){
		this.rootPresenter = rootPresenter;
		this.view=view;
		
	}
	
public void start (){
		
		view.setPresenter(this);
		setConsecutiveSeatsText();
		view.open();     
		
		
	}

	public void cancel() {
		view.close();
		
	}
	
	private void setConsecutiveSeatsText() {
		String s = "";
		if (performance.isSold_out()){
			s = "No Seats Available";
		}
		else{
			performance.FindSeats();
			performance.getLobby().FindConsecutiveSeats();
			ArrayList<Sectrange> sects = performance.getLobby().ConsecutiveSeatSelector(requestedseats);
			if (performance.getLobby().getConsecutiveSeats().size() == 0){
				s = "No consecutives Available";
			}
			else if (sects.size() == 0){
				s = "No such number of consecutive seats available";
			}
			
			else{
				for (Sectrange sect : sects){
					s += sect.getFrom().getCode() + "-" + sect.getTo().getCode() + ",";
				}
			}
				
	}
		view.setConsecutiveSeatsText(s);
	}

	public void setPerformance(Performance Performance) {
		
			this.performance = Performance;
		
	}

	public void setrequestedseats(int numOfSeats) {
		this.requestedseats = numOfSeats; 
		
	}

	public void sendSelectedSeats(String sects, String selection) {
			String[] parts = sects.split(",");
		
		for(String s : parts){
			if (selection == s){
				rootPresenter.setSeatSelected(Integer.parseInt(selection));
				String [] seats = selection.split("-");
				Seat s1 = new Seat(Integer.parseInt(seats[0]),true);
				Seat s2 = new Seat(Integer.parseInt(seats[1]),true);
				Sectrange sect1 = new Sectrange(s1,s2,Integer.parseInt(seats[1]) - Integer.parseInt(seats[0]));
				rootPresenter.setSectrange(sect1);
			}
		}
		
		
	}

}
