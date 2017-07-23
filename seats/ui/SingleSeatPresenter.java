package seats.ui;

import domain.Performance;
import domain.Seat;
import reservation.ui.ReservationPresenter;

public class SingleSeatPresenter {
	private ReservationPresenter rootPresenter;
	private SingleSeatView view;
	private Performance performance;

	public SingleSeatPresenter(SingleSeatView view,ReservationPresenter rootPresenter){
		this.rootPresenter = rootPresenter;
		this.view=view;
		
	}
	
	public void start (){
		
		view.setPresenter(this);
		
		setSeatsText();
		view.open();     
		
		
	}

	private void setSeatsText() {
		String s = "";
		if (performance.isSold_out()){
			s = "No Seats Available";
		}
		else{
			performance.FindSeats();
			for (Seat seat : performance.getLobby().getAvailableSeats()){
				s += seat.getCode() + " ,";
			}
		}
		view.setSeatsText(s);
		
	}

	

	public void cancel() {
		view.close();
		
	}

	public void setPerformance(Performance Performance) {
		this.performance = Performance;
		
	}

	public void sendSelectedSeats(String Seats, String Selection) {
		String[] parts = Seats.split(",");
		
		for(String s : parts){
			if (Selection == s){
				rootPresenter.setSeatSelected(Integer.parseInt(Selection));
			}
		}
		
	}

}
