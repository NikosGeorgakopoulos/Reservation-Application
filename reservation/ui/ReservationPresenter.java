package reservation.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import dao.PerformanceDAO;
import domain.Client;
import domain.Email;
import domain.Payment;
import domain.PaymentType;
import domain.Performance;
import domain.Sectrange;
import memorydao.PerformanceDAOMemory;
import seats.ui.MultipleSeatsFrame;
import seats.ui.MultipleSeatsPresenter;
import seats.ui.SingleSeatFrame;
import seats.ui.SingleSeatPresenter;

public class ReservationPresenter {

	private ReservationView view;
	private int SeatCode ;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
    private List<Performance> performances;
    private PerformanceDAO PerformanceDao;
	private Sectrange sectrange;
	private Payment p1 = new Payment();
	public ReservationPresenter (ReservationView view) {
		
		this.view=view;
		PerformanceDao = new PerformanceDAOMemory();
	}
	
	public void start() {
		 view.setPresenter(this);
		 getPerformanceList();
		 view.open();     
		
	}
	
	
	

	public void checkAvailability(int NumOfSeats) {
    	if (NumOfSeats == 1){
    	view.setIsSingleSeat(true);
    	SingleSeatFrame ss = new SingleSeatFrame();
    	ss.setLocationRelativeTo(null);
    	SingleSeatPresenter presenter = new SingleSeatPresenter(ss,this);
    	presenter.setPerformance(view.getSelectedPerformance());
    	presenter.start();
    	}
    	else{ 
    			view.setIsSingleSeat(false);
    			MultipleSeatsFrame ms = new MultipleSeatsFrame();
                ms.setLocationRelativeTo(null);
                MultipleSeatsPresenter presenter = new MultipleSeatsPresenter(ms,this);
                presenter.setPerformance(view.getSelectedPerformance());
                presenter.setrequestedseats(NumOfSeats);
                presenter.start();
    	}
		
	}

	

	public void createReservation() {
		Client c1 = new Client();
		c1.setName(view.getClientFirstName());
		c1.setSurname(view.getClienttLastName());
		c1.setMail(new Email(view.getClientEmail()));
		
		
				
		if(view.IsSingleSeat()){
			
			p1.setAmount(view.getSelectedPerformance().getPrice().getAmount());
			
			if(view.Iscard()){
				p1.setWayOfPayment(PaymentType.Card);
			}
			else{
				p1.setWayOfPayment(PaymentType.Cash);
				p1.setAmount(0);
			}
			
			view.getSelectedPerformance().makeReservation(getSeatCode(), c1, p1);
		}
		else{
				p1.setAmount(view.getSelectedPerformance().getPrice().getAmount() * getSectrange().getSize());
			
			if(view.Iscard()){
				p1.setWayOfPayment(PaymentType.Card);
			}
			else{
				p1.setWayOfPayment(PaymentType.Cash);
				p1.setAmount(0);
			}
			
			view.getSelectedPerformance().makeReservations(getSectrange(), c1, p1);
		}
		
		createDetailsFrame();
	}

	

	private void createDetailsFrame() {
		String status = "";
		if(p1.getAmount()==0){
			status = "Payment at Cashier";
		}
		else{
			status = "Paid online with credit card";
		}
		ReservationDetailsJframe frame = new ReservationDetailsJframe();
		frame.setLocationRelativeTo(null);
		ReservationDetailsPresenter presenter = new ReservationDetailsPresenter(frame);
		presenter.start(view.getSelectedPerformance().getTitle(),dateFormat.format(view.getSelectedPerformance().getDate()),
				view.getClientFirstName(),view.getClienttLastName(),view.getSelectedPerformance().getPrice().getAmount(),status);
		
	}
	

	public int getSeatCode() {
		return SeatCode;
	}

	public void setSeatCode(int seatCode) {
		SeatCode = seatCode;
	}
	
	public void setSeatSelected(int seat) {
		this.setSeatCode(seat);
		
	}

	public void setSectrange(Sectrange sect1) {
		this.sectrange = sect1;
		
	}
	
	public Sectrange getSectrange(){
		return sectrange;
	}
	
	private void getPerformanceList() {
		performances =  PerformanceDao.findAll();
        view.setPerformances(performances);
	}
	
	public void cancel() {
		
		view.close();
		
	}
	
	

	
}
