package reservation.ui;


import java.util.List;

import domain.Performance;
import ui.View;

public interface ReservationView extends View {
	
	void setPresenter (ReservationPresenter presenter);
	void setPerformances(List<Performance>performances);
	Performance getSelectedPerformance();
	String getClientFirstName();
	String getClienttLastName();
	String getClientEmail();
	boolean Iscard();
	boolean IsSingleSeat();
	void setIsSingleSeat(boolean flag);
	
}
