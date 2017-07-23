package seats.ui;

import ui.View;

public interface SingleSeatView extends View {
	
	void setPresenter (SingleSeatPresenter presenter);
	
	void setSeatsText(String seat);
}
