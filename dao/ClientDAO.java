package dao;



import java.util.List;

import domain.Client;


public interface ClientDAO {

  
    Client find(String name);

       
    
    
    void save(Client entity);
    
    void delete(Client entity);
    
    
    List<Client> findAll();

}
