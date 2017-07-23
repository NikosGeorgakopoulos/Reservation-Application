package performance.ui;

import java.util.List;


import domain.Performance;
import ui.View;

public interface PerformanceListView extends View{

	void setPresenter(PerformanceListPresenter presenter);
    void setPerformances(List<Performance> performances);
	Performance getSelectedPerformance();
}
