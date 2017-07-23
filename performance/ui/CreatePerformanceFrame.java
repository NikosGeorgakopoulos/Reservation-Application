package performance.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Money;
import domain.PerformanceType;
import net.miginfocom.swing.MigLayout;
import ui.DefaultJFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreatePerformanceFrame extends DefaultJFrame implements CreatePerformanceView{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3438404842002397453L;

	private JPanel contentPane;
	private JTextField TitletextField; 
	private JTextField ActorstextField;
	private JTextField DirectorstextField;
	private JTextField TypetextField; 
	private JTextField PricetextField;
	private JTextField DatetextField;
	private CreatePerformancePresenter presenter;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePerformanceFrame frame = new CreatePerformanceFrame();
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
	public CreatePerformanceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Title :");
		contentPane.add(lblName, "cell 0 0");
		
		TitletextField = new JTextField();
		contentPane.add(TitletextField, "cell 1 0,growx");
		TitletextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Actors :");
		contentPane.add(lblNewLabel, "cell 0 1");
		
		ActorstextField = new JTextField();
		contentPane.add(ActorstextField, "cell 1 1,growx");
		ActorstextField.setColumns(10);
		
		JLabel lblDirectors = new JLabel("Directors :");
		contentPane.add(lblDirectors, "cell 0 2");
		
		DirectorstextField = new JTextField();
		contentPane.add(DirectorstextField, "cell 1 2,growx");
		DirectorstextField.setColumns(10);
		
		JLabel lblType = new JLabel("Type :");
		contentPane.add(lblType, "cell 0 3");
		
		TypetextField = new JTextField();
		contentPane.add(TypetextField, "cell 1 3,growx");
		TypetextField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price :");
		contentPane.add(lblPrice, "cell 0 4");
		
		PricetextField = new JTextField();
		contentPane.add(PricetextField, "cell 1 4,growx");
		PricetextField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		contentPane.add(lblDate, "cell 0 5");
		
		DatetextField = new JTextField();
		contentPane.add(DatetextField, "cell 1 5,growx");
		DatetextField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		contentPane.add(btnSave, "flowx,cell 1 8,alignx right,aligny bottom");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				presenter.save();
				CancelButtonActionPerformed(e);
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel, "cell 1 8,aligny bottom");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				CancelButtonActionPerformed(e);
			}
		});
		
	}	
		public void setPresenter(CreatePerformancePresenter presenter) {
			this.presenter=presenter;
			
		}
		
		private void CancelButtonActionPerformed(ActionEvent e) {
				
				presenter.cancel();
				
			}
		
		
		@Override
		public String getPerformanceTitle() {
			return TitletextField.getText();
		}

		@Override
		public String[] getPerformanceActors() {
			
			String[] splitter = ActorstextField.getText().split(",");
			return splitter;
		}

		@Override
		public String[] getPerformanceDirectors() {
			String[] splitter = DirectorstextField.getText().split(",");
			return splitter;
		}

		@Override
		public PerformanceType getPerformanceType() {
			
			return PerformanceType.valueOf(TypetextField.getText());
		}

		@Override
		public Money getPerformancePrice() {
			Money price = new Money();
			price.setAmount(Double.parseDouble(PricetextField.getText()));
			price.setCurrency("EURO");
			return price;
		}

		@Override
		public Date getPerformanceDate() {
			
			try {
				return dateFormat.parse(DatetextField.getText());
			} catch (ParseException e) {
				
				return null;
			}
		}
	

		
	}






