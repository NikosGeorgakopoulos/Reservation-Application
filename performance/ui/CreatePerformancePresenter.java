package performance.ui;

import dao.PerformanceDAO;
import domain.Performance;
import domain.Play;

public class CreatePerformancePresenter {
	
	private CreatePerformanceView view;
	private Performance performance = new Performance();
    private PerformanceDAO performanceDao;
	
	public CreatePerformancePresenter(CreatePerformanceView view){
		
		this.view=view;
		
	}
	
	public void start() {
		 view.setPresenter(this);
		 view.open();     
		
	}

	public void cancel(){
		
	view.close();
	}
	
	public void save() {
		Play play = new Play(view.getPerformanceTitle(),view.getPerformanceActors(),view.getPerformanceDirectors(),view.getPerformanceType(),
				view.getPerformancePrice());
    	performance.setPlay(play);
    	performance.setDate(view.getPerformanceDate());
    	performanceDao.save(performance);
        view.close();
    }

	

}
