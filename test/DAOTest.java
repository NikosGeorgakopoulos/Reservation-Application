package test;
import dao.*;
import domain.Client;
import domain.Email;
import domain.Money;
import domain.Performance;
import domain.Play;
import domain.PerformanceType;
import memorydao.*;



import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DAOTest {


    
  
    private ClientDAO ClientDAO;
    private PerformanceDAO PerformanceDAO;
    
    
    private static final int INITIAL_CLIENT_COUNT = 3;
    private static final int INITIAL_PERFORMANCE_COUNT = 10;    
   
    
    

    
    @Before
    public void setUp() {
    	/**
    	 *   Create Performances,Plays and Clients  
    	 * 
    	 * 	 Access them through the DAO
    	 */
    	Initializer dataHelper = new MemoryInitializer();
    	dataHelper.prepareData();
        
    	ClientDAO = new ClientDAOMemory();
        PerformanceDAO = new PerformanceDAOMemory();
    }
    
    
    
    /**
     * Check for existing Client in the DAO
     */
    @Test
    public void findExistingClient() {
        Client client = ClientDAO.find("Mazwnakis");
        Assert.assertEquals("Giwrgos", client.getName());                
    }
    
    /**
     * Check for non existing client therefore the Object should be NULL
     */
    @Test
    public void findNonExistingClient() {        
    	Client client = ClientDAO.find("Papadimitriou");
          
        Assert.assertNull(client);    
    }
        
    /**
     * Use the Initial Client Count to see if we retrieved every Client from the DAO
     */
    @Test
    public void listAllClients() {        
        List<Client> allCLients = ClientDAO.findAll();
        Assert.assertEquals(INITIAL_CLIENT_COUNT, allCLients.size());        
    }
    
    /**
     * Create new client and add to the DAO
     * Now the DAO count should be +1 
     * And we check if the newly created client is included
     */
    @Test
    public void saveClient() {        
        Client client = new Client();
        client.setMail(new Email("clienttest@gmail.com"));
        client.setName("Makis");
        client.setSurname("Testakis");
        ClientDAO.save(client);
        Assert.assertEquals(INITIAL_CLIENT_COUNT + 1, ClientDAO.findAll().size());
        Assert.assertNotNull(ClientDAO.find(client.getSurname()));
        Assert.assertTrue(ClientDAO.findAll().contains(client));
    }
    
    /**
     * Delete the first client of the DAO
     * Now the count should be -1 
     * And the Object searching for the client NULL
     */
  
    @Test
    public void deleteClient() {
        List<Client> AllClients = ClientDAO.findAll();
        Client client = AllClients.get(0);
        ClientDAO.delete(client);
        AllClients = ClientDAO.findAll();
        Assert.assertEquals(INITIAL_CLIENT_COUNT - 1, AllClients.size());
        Assert.assertNull(ClientDAO.find(client.getName()));
    }
    
    
    /**
     * Check for existing Performance in the DAO
     */
    @Test
    public void findExistingPerformance() {
        double Expected_Price = 30;
        
        Performance Performance = PerformanceDAO.find("Arxontoxwriatis");
        Assert.assertEquals(Expected_Price , Performance.getPrice().getAmount(),0);
    }
    
    
    /**
     *
     * Check for non existing Performance
     * Again the Object should be NULL
     */
    @Test
    public void findNonExistingPerformance() {
    	Performance Performance = PerformanceDAO.find("Limni twn kuknwn");
        Assert.assertNull(Performance);
    }
    
    /**
     * List all Performances so the size of the created list should be equal with the initial count
     */
    @Test
    public void listAllPerformances() {
        List<Performance> AllPerformances = PerformanceDAO.findAll();        
        Assert.assertEquals(INITIAL_PERFORMANCE_COUNT, AllPerformances.size());        
    }
    
    /**
     * Create New performance and save it in the DAO
     * Now the count should be +1 
     * The new performance should be found the DAO
     */
    @Test
    public void savePerformance() {
    	Money price = new Money();
    	price.setAmount(50);
    	price.setCurrency("EURO");
        String[] actors = {"George Clooney","Arnold"};
        String[] directors ={"James Cameron"};
		Play play = new Play("Batman",actors,directors,PerformanceType.DRAMA, price);
        Performance performance = new  Performance();
        performance.setPlay(play);
        PerformanceDAO.save(performance);
        List<Performance> AllPerformances = PerformanceDAO.findAll(); 
        Assert.assertEquals(INITIAL_PERFORMANCE_COUNT + 1, AllPerformances.size());
        Assert.assertNotNull(PerformanceDAO.find(performance.getTitle()));
        Assert.assertTrue(AllPerformances.contains(performance));
    }
    
   /**
    * Delete Performance from the DAO
    * The count should be -1 
    * And The deleted Performance should not be in the list
    */
    @Test
    public void deletePerformance() {      
    	
        Performance performance = PerformanceDAO.find("Interstellar");
        
       
        
        PerformanceDAO.delete(performance);
        List<Performance> AllPerformances = PerformanceDAO.findAll(); 
        Assert.assertEquals(INITIAL_PERFORMANCE_COUNT - 1, AllPerformances.size());
        
        List<Performance> Instances = PerformanceDAO.findAllInstances("Interstellar");
        Assert.assertEquals(1, Instances.size());
                
    }
    /**
     * Delete Performance from the DAO
     * The count should be -1 
     * And The deleted Performance should not be in the list
     */
    
  
}
