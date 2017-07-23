package performance.ui;


import ui.View;

public interface StatisticsView extends View {
	
	void setPresenter (StatisticsPresenter presenter);
	
	void setEarnings (Double earnings);
	
	void setReserved (int reserved);
	
	double getEarnings();
	
	int getReserved();
	
	
}
