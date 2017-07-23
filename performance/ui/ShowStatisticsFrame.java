package performance.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.DefaultJFrame;

import javax.swing.JLabel;

public class ShowStatisticsFrame extends DefaultJFrame implements StatisticsView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2113929905250475240L;
	private JPanel contentPane;
	private static double earnings;
	private static int reserved;
	@SuppressWarnings("unused")
	private StatisticsPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowStatisticsFrame frame = new ShowStatisticsFrame(earnings,reserved);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 
	
	 
	public ShowStatisticsFrame(double earnings, int reserved) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel StatisticsLabel = new JLabel("The Performance has made "+earnings+" So far and has "+reserved+" Reserved Seats");
		contentPane.add(StatisticsLabel, BorderLayout.NORTH);
	
			
	}

	

	





	@SuppressWarnings("static-access")
	@Override
	public void setEarnings(Double earnings) {
		this.earnings = earnings;
		
	}





	@SuppressWarnings("static-access")
	@Override
	public void setReserved(int reserved) {
		this.reserved = reserved;
		
	}





	@Override
	public double getEarnings() {
		return earnings;
	}





	@Override
	public int getReserved() {
		return reserved;
	}





	@Override
	public void setPresenter(StatisticsPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	

}
