package seats.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ui.DefaultJFrame;

public class SingleSeatFrame extends DefaultJFrame implements SingleSeatView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 877953156586129546L;
	private JPanel contentPane;
	
	private JButton buttonOk;
	private JButton btnCancel;
	private SingleSeatPresenter presenter;
	
	private JTextField SeatsSelectionField = new JTextField();
	private JTextField AvailableSeatsField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleSeatFrame frame = new SingleSeatFrame();
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
	public SingleSeatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		
		JLabel lblAbailableSeats = new JLabel("Available Seats: ");
		contentPane.add(lblAbailableSeats, "cell 0 0,alignx trailing");
		
		
		contentPane.add(AvailableSeatsField, "cell 1 0,growx");
		AvailableSeatsField.setColumns(10);
		
		JLabel lblHooseYourSeat = new JLabel("Choose your Seat :");
		contentPane.add(lblHooseYourSeat, "cell 0 2,growx");
		
		
		
		SeatsSelectionField = new JTextField();
		contentPane.add(SeatsSelectionField, "cell 1 2,growx");
		SeatsSelectionField.setColumns(10);

		
		
		buttonOk = new JButton("OK");
		contentPane.add(buttonOk, "flowx,cell 1 8,alignx right");
		
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.sendSelectedSeats(AvailableSeatsField.getText(),SeatsSelectionField.getText());
				CancelButtonActionPerformed(e);
			}

		});
		
		btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel, "cell 1 8,alignx right");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelButtonActionPerformed(e);
			}

		});
		
	}
	
	
	public void setPresenter(SingleSeatPresenter presenter) {
		this.presenter=presenter;
		
	}
	
	private void CancelButtonActionPerformed(ActionEvent e) {
		presenter.cancel();
		
	}

	

	@Override
	public void setSeatsText(String seat) {
		AvailableSeatsField.setText(seat);
		
	}

}
