package reservation.ui;

public class ReservationDetailsPresenter {
	
	private  ReservationDetailsView view;
	
	ReservationDetailsPresenter(ReservationDetailsView view){
		this.view = view;
	}
	
	public void start(String title,String date,String fname,String lname,double price,String paymentstatus) {
		 view.setPresenter(this);
		 setValues(title,date,fname,lname,price,paymentstatus);
		 view.open();     
		
	}
	
	public void setValues(String title,String date,String fname,String lname,double price,String paymentstatus){
		view.setPerformanceTitle(title);
		view.setClientFirstName(fname);
		view.setClienttLastName(lname);
		view.setPeformanceDate(date);
		view.setPrice(price);
		view.setPaymentStatus(paymentstatus);
	}
}
