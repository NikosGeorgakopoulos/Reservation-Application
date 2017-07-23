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

public class MultipleSeatsFrame extends DefaultJFrame implements MultipleSeatsView {

	
	private static final long serialVersionUID = 8450662668046613546L;
	private JPanel contentPane;
	private JTextField AvailableConsecutives; 
	private JTextField SelectedConsecutives;
	private JButton btnOk; 
	private JButton btnCancel;
	private MultipleSeatsPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleSeatsFrame frame = new MultipleSeatsFrame();
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
	public MultipleSeatsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		
		JLabel lblAvailable = new JLabel("Available Consecutive Seats : ");
		contentPane.add(lblAvailable, "cell 0 0");
		
		AvailableConsecutives = new JTextField();
		contentPane.add(AvailableConsecutives, "cell 1 0,growx");
		AvailableConsecutives.setColumns(10);
		
		JLabel lblChooseSeats = new JLabel("Choose Combo of Seats from above :");
		contentPane.add(lblChooseSeats, "cell 0 2");
		
		SelectedConsecutives = new JTextField();
		contentPane.add(SelectedConsecutives, "cell 1 2,growx");
		SelectedConsecutives.setColumns(10);
		
		btnOk = new JButton("OK");
		contentPane.add(btnOk, "flowx,cell 1 8,alignx right");
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.sendSelectedSeats(AvailableConsecutives.getText(),SelectedConsecutives.getText());
				CancelButtonActionPerformed(e);
			}

		});
		
		
		
		btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel, "cell 1 8");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelButtonActionPerformed(e);
			}

		});
	}

	

	@Override
	public void setConsecutiveSeatsText(String seat) {
		AvailableConsecutives.setText(seat);
		
	}

	@Override
	public void setPresenter(MultipleSeatsPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	private void CancelButtonActionPerformed(ActionEvent e) {
		presenter.cancel();
		
	}

}
