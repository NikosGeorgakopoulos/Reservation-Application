package performance.ui;

import domain.Money;
import domain.PerformanceType;
import ui.View;

public interface EditPerformanceView extends View {

	void setPresenter(EditPerformancePresenter presenter);

	void setPerformancetitle(String title);

	void setPerformanceActors(String[] actors);

	void setPerformanceDirectors(String[] directors);

	void setPerformanceType(PerformanceType type);

	void setPerformancePrice(Money price);

	String getPerformanceTitle();

	String[] getPerformanceActors();

	String[] getPerformanceDirectors();

	PerformanceType getPerformanceType();

	Money getPerformancePrice();
	
	

}
