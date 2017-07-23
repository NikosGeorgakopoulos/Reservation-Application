package client.ui;

import ui.View;

import domain.Client;

import java.util.List;

public interface ClientListView extends View {
	void setPresenter(ClientListPresenter presenter);
    void setClients(List<Client> clients);
    
}
