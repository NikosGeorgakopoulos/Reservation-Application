package ui;

import performance.ui.EditPerformanceFrame;
import performance.ui.EditPerformanceView;
import performance.ui.PerformanceListJframe;
import performance.ui.PerformanceListView;

public class PerformanceViewRegistry {
	
	private static PerformanceListView performanceListViewStub;
	private static EditPerformanceView performanceEditorViewStub;
	
	
	public static void setPerformanceListView(PerformanceListView performanceListView) {
		performanceListViewStub = performanceListView;
	}
	
	public static void setPerformanceView(EditPerformanceView performanceView) {
		performanceEditorViewStub = performanceView;
	}
	
    public static PerformanceListView getPerformanceListView() {
        return performanceListViewStub == null ? new PerformanceListJframe() 
        	: performanceListViewStub ;
    }
    
    public static EditPerformanceView getPerformanceView() {
    	return performanceEditorViewStub == null ? new EditPerformanceFrame() 
    		: performanceEditorViewStub;
    }

    public static void reset() {
    	performanceListViewStub = null;
    	performanceEditorViewStub=null;
    }

}
