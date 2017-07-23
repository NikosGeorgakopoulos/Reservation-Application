package performance.ui;

public class StatisticsPresenter {
	
	private double earning;
	private int reserved;
	private StatisticsView view;
	
	public StatisticsPresenter(StatisticsView view,double earnings,int reserved){
		this.view = view;
		this.setEarning(earnings);
		this.setReserved(reserved);
	}
	
	public void start() {
		
		view.setPresenter(this);
		
		view.open();     
		
	}
	

	public void cancel(){
		
	view.close();
		
	}

	public double getEarning() {
		return earning;
	}

	public void setEarning(double earning) {
		this.earning = earning;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

}
