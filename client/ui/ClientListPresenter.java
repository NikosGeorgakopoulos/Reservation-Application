package client.ui;
import java.util.List;
import memorydao.ClientDAOMemory;
import dao.ClientDAO;
import domain.Client;



public class ClientListPresenter {
	
	
	
	 	private ClientListView view;
	    private List<Client> clients;
	    private ClientDAO clientDao;
	    
	    public ClientListPresenter(ClientListView view) {
	        this.view = view;
	        clientDao = new ClientDAOMemory();
	    }
	    
	    public void start() {
	        view.setPresenter(this);
	        getClientList();
	        view.open();
	    }

		private void getClientList() {
			clients = clientDao.findAll(); 
	        view.setClients(clients);
		}
	    
	    public List<Client> getClients() {
	        return clients;
	    }
	    
	    
	 
	    
	    


	    

}
