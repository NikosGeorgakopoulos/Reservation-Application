package dao;


import java.util.List;

import domain.Performance;;


public interface PerformanceDAO {

   
    Performance find(String title);

       
    
    void save(Performance entity);
   
    void delete(Performance performance);
    
    List<Performance> findAllInstances(String title);
    
    List<Performance> findAll();

}
