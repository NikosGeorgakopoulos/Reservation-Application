package ui;

import javax.swing.JFrame;

public class DefaultJFrame extends JFrame implements View {

	
	private static final long serialVersionUID = -102645302725301113L;
	
	public void open (){
		setVisible(true);
	}

	
	public void close() {
		dispose();
		
	}

}
