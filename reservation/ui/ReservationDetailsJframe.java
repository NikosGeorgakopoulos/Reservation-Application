package reservation.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import ui.DefaultJFrame;

import javax.swing.JLabel;

public class ReservationDetailsJframe extends DefaultJFrame implements ReservationDetailsView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7429009075399678935L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private ReservationDetailsPresenter presenter;
	private String title;
	private String fname;
	private String lname;
	private String date;
	private double price;
	private String status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationDetailsJframe frame = new ReservationDetailsJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservationDetailsJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][]", "[][][][][][][][]"));
		
		JLabel lblPerformanceTitle = new JLabel(title);
		contentPane.add(lblPerformanceTitle, "cell 6 0");
		
		JLabel lblPerformanceDate = new JLabel(date);
		contentPane.add(lblPerformanceDate, "cell 6 2");
		
		JLabel lblClientinfo = new JLabel(fname + " " + lname);
		contentPane.add(lblClientinfo, "cell 6 4");
		
		JLabel lblPrice = new JLabel(String.valueOf(price));
		contentPane.add(lblPrice, "cell 3 7");
		
		JLabel lblPaymentdetails = new JLabel(status);
		contentPane.add(lblPaymentdetails, "cell 9 7");
	}

	

	@Override
	public void setClientFirstName(String name) {
		this.fname = name;
		
	}

	@Override
	public void setClienttLastName(String name) {
		this.lname = name;
		
	}

	@Override
	public void setPerformanceTitle(String title) {
		this.title = title;
		
	}

	@Override
	public void setPeformanceDate(String date) {
		this.date = date;
		
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
		
	}

	@Override
	public void setPaymentStatus(String Status) {
		this.status = Status;
		
	}

	@Override
	public void setPresenter(ReservationDetailsPresenter presenter) {
		this.presenter = presenter;
		
	}

}
