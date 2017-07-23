package memorydao;
import java.util.ArrayList;
import java.util.List;
import dao.ClientDAO;
import domain.Client;

public class ClientDAOMemory implements ClientDAO {


    protected static List<Client> Clients = new ArrayList<Client>();
    
    public void delete(Client client) {
        Clients.remove(client);    
    }

    public List<Client> findAll() {
        return new ArrayList<Client>(Clients);
    }


    public void save(Client client) {
        if (! Clients.contains(client)) {
            Clients.add(client);    
        }        
    }

    
    public Client find(String name) {
        for(Client client : Clients) {
            if (client.getSurname() == name ) {
                return client;
            }
        }
        return null;
    }

		

}
