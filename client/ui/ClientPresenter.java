package client.ui;

import memorydao.ClientDAOMemory;
import dao.ClientDAO;
import domain.Client;



public class ClientPresenter {
	
	 private ClientView view;
	    private Client client = new Client();
	    private ClientDAO clientDao;
	    
	    public ClientPresenter(ClientView view) {
	        this.view = view;
	        clientDao = new ClientDAOMemory();
	    }


	    public void setClient(Client client) {
	        this.client = client;
	        updateView();
	    }


	    public Client getClient() {
	        return client;
	    }
	    
	    public void start() {
	        view.setPresenter(this);
	        updateView();
	        view.open();
	        
	    }
	    
	    
	    private void updateView() {
	    	
	        view.setFirstName(client.getName());
	        view.setLastName(client.getSurname());        
	    }
	    
	    public void save() {
	    	
	        client.setName(view.getFirstName());
	        client.setSurname(view.getLastName());
	        clientDao.save(client);
	        view.close();
	    }
	    
	    public void cancel() {
	        view.close();
	    }

	
}
