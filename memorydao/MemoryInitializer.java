package memorydao;

import java.util.List;
import domain.*;
import dao.ClientDAO;
import dao.Initializer;
import dao.PerformanceDAO;


public class MemoryInitializer extends Initializer {

    @Override
    protected void eraseData() {
                
        List<Performance> AllPerformances = getPerformanceDAO().findAll();
        for(Performance performance : AllPerformances) {
            getPerformanceDAO().delete(performance);
        }
            
        List<Client> allClients = getClientDAO().findAll();        
        for(Client client : allClients) {
            getClientDAO().delete(client);
        }
        
         
    }

	@Override
	protected PerformanceDAO getPerformanceDAO() {
		return new PerformanceDAOMemory();
	}

	@Override
	protected ClientDAO getClientDAO() {
		return new ClientDAOMemory();
	}

	
    
}
