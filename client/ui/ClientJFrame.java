package client.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import ui.DefaultJFrame;

public class ClientJFrame extends DefaultJFrame implements ClientView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -481210229297383449L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ClientPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientJFrame frame = new ClientJFrame();
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
	public ClientJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Name");
		contentPane.add(lblName, "cell 0 0");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		contentPane.add(lblSurname, "cell 0 1");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail:");
		contentPane.add(lblEmail, "cell 0 2");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblWayOfPayment = new JLabel("Way of payment: ");
		contentPane.add(lblWayOfPayment, "cell 0 3");
		
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		buttonGroup.add(rdbtnCash);
		contentPane.add(rdbtnCash, "flowx,cell 1 3");
		
		JRadioButton rdbtnCredit = new JRadioButton("Credit");
		buttonGroup.add(rdbtnCredit);
		contentPane.add(rdbtnCredit, "cell 1 3");
		
		JButton btnOk = new JButton("Confirm");
		contentPane.add(btnOk, "flowx,cell 1 4,alignx right");
		
		JButton btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel, "cell 1 4");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelButtonActionPerformed(e);
			}

		
		});
	}

	
	public void setPresenter(ClientPresenter presenter) {
		this.presenter=presenter;
		
	}
	private void CancelButtonActionPerformed(ActionEvent e) {
		presenter.cancel();
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClient(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		
	}

	
}
