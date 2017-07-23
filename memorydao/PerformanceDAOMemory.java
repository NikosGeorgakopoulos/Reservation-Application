package memorydao;
import domain.Performance;
import java.util.ArrayList;
import java.util.List;
import dao.PerformanceDAO;

public class PerformanceDAOMemory implements PerformanceDAO { 
    protected static List<Performance> Performances = new ArrayList<Performance>();
    
    
    public void delete(Performance performance) {
    	Performances.remove(performance);
    	            
    }

    public ArrayList<Performance> findAll() {
        return new ArrayList<Performance>(Performances);
    }
    
    public List<Performance> findAllInstances(String title){
    	ArrayList<Performance> Instances = new ArrayList<Performance>();
    	for(Performance Performance : Performances) {
            if (Performance.getTitle() == title) {
                Instances.add(Performance);
            }
        }
		return Instances;
    	
    }


    public void save(Performance p1) {
        if (! Performances.contains(p1)) {
        	Performances.add(p1);    
        }        
    }
    public Performance find(String title) {
        for(Performance Performance : Performances) {
            if (Performance.getTitle() == title) {
                return Performance;
            }
        }
        return null;
    }

	

	

}
