package reservation.ui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import domain.Performance;
import net.miginfocom.swing.MigLayout;

import ui.DefaultJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;



public class ReservationFrame extends DefaultJFrame implements ReservationView {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6349470981950471961L;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JPanel contentPane;
	 @SuppressWarnings("rawtypes")
	private DefaultListModel PerformanceModel;
	 @SuppressWarnings("rawtypes")
	private JList performanceJList;
	
	private ReservationPresenter presenter;
	private JTextField ClientFirstName;  
	private JTextField ClientLastName; 
	private JTextField ClientEmail;
	private JTextField NumOfSeatsJText; 
	private boolean IsCard;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");

	private boolean isSingleSeat;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationFrame frame = new ReservationFrame();
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ReservationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));
	
		
		
				JLabel lblChoosePerformance = new JLabel("Choose Performance");
				contentPane.add(lblChoosePerformance, "cell 0 0");
		     	
				PerformanceModel = new DefaultListModel();
		        performanceJList = new JList();
		        performanceJList.setModel(PerformanceModel);
		        performanceJList.setCellRenderer(new DefaultListCellRenderer() {

		            
		        	private static final long serialVersionUID = 8429699550358591681L;

					public Component getListCellRendererComponent(JList list,
		                    Object value, int index, boolean isSelected, boolean cellHasFocus) {
		                
						Performance performance = (Performance) value;
		                String line = performance.getTitle()+ " " + dateFormat.format(performance.getDate());               
		                                                                     
		                              
		               return super.getListCellRendererComponent(list, 
		                		line,
		                		index, isSelected, cellHasFocus);
		            }
		        });
		        
		        contentPane.add(performanceJList);
		      
					     		     		
				
															
				JLabel lblChooseNumberOf = new JLabel("Choose Number of Seats");
				contentPane.add(lblChooseNumberOf, "cell 0 2");
				
			
				
				NumOfSeatsJText = new JTextField();
				contentPane.add(NumOfSeatsJText, "flowx,cell 1 2");
				NumOfSeatsJText.setColumns(10);
				
				
		    	JButton btnCheckAvailability = new JButton("Check Availability");
		    	contentPane.add(btnCheckAvailability, "cell 1 2");
		    					
						
				
		    		btnCheckAvailability.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                SwingUtilities.invokeLater(new Runnable() {
		                    public void run() {
		                    
		                    	
		                    	presenter.checkAvailability(Integer.parseInt(NumOfSeatsJText.getText()));
		                    	

		                    }
		                });
		            }
	        });										         
								
				JLabel lblClientInformation = new JLabel("Client information");
				contentPane.add(lblClientInformation, "cell 0 4");
														
				JLabel lblName = new JLabel("Name");
				contentPane.add(lblName, "cell 0 5");
				
				ClientFirstName = new JTextField();
				contentPane.add(ClientFirstName, "cell 1 5,growx");
				ClientFirstName.setColumns(10);
				
				JLabel lblSurname = new JLabel("Surname");
				contentPane.add(lblSurname, "cell 0 6");
				
				ClientLastName = new JTextField();
				contentPane.add(ClientLastName, "cell 1 6,growx");
				ClientLastName.setColumns(10);
				
				JLabel lblEmail = new JLabel("E-mail");
				contentPane.add(lblEmail, "cell 0 7");
				
				ClientEmail = new JTextField();
				contentPane.add(ClientEmail, "cell 1 7,growx");
				ClientEmail.setColumns(10);
				
				JLabel lblWayOfPayment = new JLabel("Way of Payment");
				contentPane.add(lblWayOfPayment, "cell 0 8");
				
				JRadioButton rdbtnCash = new JRadioButton("Cash");
				buttonGroup.add(rdbtnCash);
				contentPane.add(rdbtnCash, "flowx,cell 1 8");
				
				rdbtnCash.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						setIsCard(false);
					}


				});	
			
				
				JRadioButton rdbtnCredit = new JRadioButton("Credit");
				buttonGroup.add(rdbtnCredit);
				contentPane.add(rdbtnCredit, "cell 1 8");
				rdbtnCredit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						setIsCard(true);
					}


				});	
				
				JButton btnCreateReservation = new JButton("Confirm Reservation");
				contentPane.add(btnCreateReservation, "flowx,cell 1 9,alignx right");
				
				btnCreateReservation.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						presenter.createReservation();
					}


				});	
				
				JButton btnCancel = new JButton("Cancel");
				contentPane.add(btnCancel, "cell 1 9");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						CancelButtonActionPerformed(e);
					}


				});										
			
	}

	
	public void setPresenter(ReservationPresenter presenter) {
		this.presenter=presenter;
		
	}
	
	private void CancelButtonActionPerformed(ActionEvent e) {
		presenter.cancel();
		
	}

	 	@SuppressWarnings("unchecked")
		@Override
	    public void setPerformances(List<Performance> performances) {
	        PerformanceModel.clear();
	        for(Performance performance : performances) {
	            PerformanceModel.addElement(performance);
	        }
	        performanceJList.setModel(PerformanceModel);
	    }

	 	@Override
		public Performance getSelectedPerformance() {
			
			return (Performance)  performanceJList.getSelectedValue();
		}

		@Override
		public String getClientFirstName() {
			return ClientFirstName.getText();
		}

		@Override
		public String getClienttLastName() {
			return ClientLastName.getText();
		}

		@Override
		public String getClientEmail() {
			return ClientEmail.getText();
		}

			

		public void setIsCard(boolean isCard) {
			IsCard = isCard;
		}

		@Override
		public boolean Iscard() {
			
			return IsCard;
		}

		@Override
		public boolean IsSingleSeat() {
			
			return isSingleSeat;
		}

		@Override
		public void setIsSingleSeat(boolean flag) {
			this.isSingleSeat = flag;
			
		}
		
		
}