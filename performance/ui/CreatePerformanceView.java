package performance.ui;

import java.util.Date;

import domain.Money;
import domain.PerformanceType;
import ui.View;

public interface CreatePerformanceView extends View {

	void setPresenter(CreatePerformancePresenter createPerformancePresenter);
	
	String getPerformanceTitle();

	String[] getPerformanceActors();

	String[] getPerformanceDirectors();

	PerformanceType getPerformanceType();

	Money getPerformancePrice();
	
	Date getPerformanceDate();

	

}
