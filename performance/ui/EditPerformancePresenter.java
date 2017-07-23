package performance.ui;

import dao.PerformanceDAO;
import domain.Performance;
import Service.PerformancesEditing;

public class EditPerformancePresenter {

	

	private EditPerformanceView view;
	private PerformancesEditing editor = new PerformancesEditing();
	private Performance performance = new Performance();
    private PerformanceDAO performanceDao;
	
	public EditPerformancePresenter( EditPerformanceView view) {
		
		this.view=view;
		
	}
	
	public void ShowStatistics(){
		double earnings = editor.getPerformanceprofits(performance);
		int reserved = editor.getPerformanceReservedSeats(performance);
		ShowStatisticsFrame frame = new ShowStatisticsFrame(earnings,reserved);
		frame.setLocationRelativeTo(null);
    	StatisticsPresenter presenter = new StatisticsPresenter(frame,earnings,reserved);
    	presenter.start();
	}
	
	 public void setPerformance(Performance performance) {
	        this.performance = performance;
	        updateView();
	    }


	    public Performance getperformance() {
	        return performance;
	    }
	
	public void start() {
		 view.setPresenter(this);
		 updateView();
		 view.open();     
	}
	
	private void updateView() {
    	view.setPerformancetitle(performance.getTitle());
        view.setPerformanceActors(performance.getActors());
        view.setPerformanceDirectors(performance.getDirectors());
        view.setPerformanceType(performance.getType());
        view.setPerformancePrice(performance.getPrice());
        
    }
    
    public void save() {
    	performance.setTitle(view.getPerformanceTitle());
    	performance.setActors(view.getPerformanceActors());
    	performance.setDirectors(view.getPerformanceDirectors());
    	performance.setType(view.getPerformanceType());
    	performance.setPrice(view.getPerformancePrice());
    	performanceDao.save(performance);
        view.close();
    }
    
    public void delete(){
    	performanceDao.delete(performance);
    	updateView();
    }

	public void cancel(){
		
	view.close();
	}

	
}
