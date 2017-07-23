package performance.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class EditPerformanceFrame extends DefaultJFrame implements EditPerformanceView {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1370203099989743596L;
	private JPanel contentPane;
	private JTextField TitletextField;
	private JTextField ActorstextField;
	private JTextField DirectorstextField;  
	private JTextField TypetextField;  
	private JTextField PricetextField;
	private EditPerformancePresenter presenter; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPerformanceFrame frame = new EditPerformanceFrame();
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
	public EditPerformanceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		
		JLabel lblName = new JLabel("Enter new title:");
		contentPane.add(lblName, "cell 0 1,alignx left");
		
		TitletextField = new JTextField();
		contentPane.add(TitletextField, "cell 1 1,growx");
		TitletextField.setColumns(10);
		
		JLabel lblType = new JLabel("Enter new Actors:");
		contentPane.add(lblType, "cell 0 2,alignx left");
		
		ActorstextField = new JTextField();
		contentPane.add(ActorstextField, "cell 1 2,growx");
		ActorstextField.setColumns(10);
		
		JLabel lblActors = new JLabel("Enter new Directors:");
		contentPane.add(lblActors, "cell 0 3,alignx left");
		
		DirectorstextField = new JTextField();
		contentPane.add(DirectorstextField, "cell 1 3,growx");
		DirectorstextField.setColumns(10);
		
		JLabel lblDirectors = new JLabel("Enter new Price:");
		contentPane.add(lblDirectors, "cell 0 4,alignx left");
		
		TypetextField = new JTextField();
		contentPane.add(TypetextField, "cell 1 4,growx");
		TypetextField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Enter new Type:");
		contentPane.add(lblPrice, "cell 0 5,alignx left");
		
		PricetextField = new JTextField();
		contentPane.add(PricetextField, "cell 1 5,growx");
		PricetextField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		contentPane.add(btnSave, "flowx,cell 1 8,alignx right");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				presenter.save();
			}


		});
		
		JButton btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel, "cell 1 8");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				CancelButtonActionPerformed(e);
			}


		});
		
		
	}

	
	public void setPresenter(EditPerformancePresenter presenter) {
		this.presenter=presenter;
		
	}
	
	private void CancelButtonActionPerformed(ActionEvent e) {
		presenter.cancel();
		
	}

	@Override
	public void setPerformancetitle(String title) {
		TitletextField.setText(title);
		
	}

	@Override
	public void setPerformanceActors(String[] actors) {
		String line = " ";
		for (String s : actors){
			line += s + ",";
		}
		ActorstextField.setText(line);
		
	}

	@Override
	public void setPerformanceDirectors(String[] directors) {
		
		String line = " ";
		for (String s : directors){
			line += s + ",";
		}
		
		DirectorstextField.setText(line);
		
	}

	@Override
	public void setPerformanceType(domain.PerformanceType type) {
		TypetextField.setText(type.toString());
		
	}

	@Override
	public void setPerformancePrice(Money price) {
		TypetextField.setText(String.valueOf(price.getAmount()));
		
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

}
