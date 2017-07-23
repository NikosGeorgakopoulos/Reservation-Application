package performance.ui;

import java.util.List;



import performance.ui.PerformanceListView;
import dao.PerformanceDAO;
import domain.Performance;
import memorydao.PerformanceDAOMemory;
import ui.PerformanceViewRegistry;


public class PerformanceListPresenter {

	
	private PerformanceListView view;
    private List<Performance> performances;
    private PerformanceDAO performanceDao;
    
    public PerformanceListPresenter(PerformanceListView view) {
        this.view = view;
        performanceDao = new  PerformanceDAOMemory();
    }
    
    public void start() {
        view.setPresenter(this);
        getPerformanceList();
        view.open();
    }

	private void getPerformanceList() {
		performances = performanceDao.findAll();
        view.setPerformances(performances);
	}
	
	public void editSelected() {
        EditPerformanceView performanceView = PerformanceViewRegistry.getPerformanceView();
        EditPerformancePresenter performanceEditorPresenter = new  EditPerformancePresenter(performanceView);
        performanceEditorPresenter.setPerformance(view.getSelectedPerformance());
        performanceEditorPresenter.start();
    }
	
	public void deleteSelected(){
		EditPerformanceView performanceView = PerformanceViewRegistry.getPerformanceView();
        EditPerformancePresenter performanceEditorPresenter = new  EditPerformancePresenter(performanceView);
        performanceEditorPresenter.setPerformance(view.getSelectedPerformance());
        performanceEditorPresenter.delete();
		
	}
    
    public List<Performance> getPerformances() { 
        return performances;
    }

	public void ShowSelectedStatistics() {
		EditPerformanceView performanceView = PerformanceViewRegistry.getPerformanceView();
        EditPerformancePresenter performanceEditorPresenter = new  EditPerformancePresenter(performanceView);
        performanceEditorPresenter.setPerformance(view.getSelectedPerformance());
        performanceEditorPresenter.ShowStatistics();
		
	}

	
}
