package admin.ui;

public class AdminPresenter {

	private AdminView view;
	
	public AdminPresenter(AdminView view) {

		this.view=view;
	}
		
		public void start() {
			
			view.setPresenter(this);
			
			 view.open();     
			
		}
		

		public void cancel(){
			
			view.close();
			
		}
}
