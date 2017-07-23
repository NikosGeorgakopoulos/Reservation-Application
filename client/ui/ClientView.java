package client.ui;



import ui.View;

public interface ClientView extends View {

	void setPresenter (ClientPresenter presenter);
	
    
    void setClient(String name);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    
    

	


}
