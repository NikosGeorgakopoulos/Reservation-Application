package reservation.ui;

import ui.View;

public interface ReservationDetailsView extends View {

	void setPresenter (ReservationDetailsPresenter presenter);
	void setClientFirstName(String name);
	void setClienttLastName(String name);
	void setPerformanceTitle(String title);
	void setPeformanceDate(String date);
	void setPrice(double price);
	void setPaymentStatus(String Status);
}
