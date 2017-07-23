package seats.ui;

import ui.View;

public interface MultipleSeatsView extends View {
	
	void setPresenter(MultipleSeatsPresenter presenter);
	
	void setConsecutiveSeatsText(String seat);
}
