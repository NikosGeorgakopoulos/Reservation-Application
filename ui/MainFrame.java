package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import dao.Initializer;
import memorydao.MemoryInitializer;
import admin.ui.AdminFrame;
import admin.ui.AdminPresenter;
import client.ui.ClientListJframe;
import client.ui.ClientListPresenter;
import net.miginfocom.swing.MigLayout;
import reservation.ui.ReservationFrame;
import reservation.ui.ReservationPresenter;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7762232890887247985L;
	/**
	 * 
	 */

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Initializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][]", "[][][][][][]"));
		
		JLabel label = new JLabel("Welcome to our Reservation platform!");
		contentPane.add(label, "cell 0 0");
		
		JButton btnMakeAReservation = new JButton("Make a Reservation ");
		contentPane.add(btnMakeAReservation, "cell 0 3");
		btnMakeAReservation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    
                    	ReservationFrame reserv = new ReservationFrame();
                    	reserv.setLocationRelativeTo(null);
                    	ReservationPresenter presenter = new ReservationPresenter(reserv);
                    	presenter.start();
                    	
                   
                    }
                });
            }
        });
		
		JButton btnClients = new JButton("Clients");
		contentPane.add(btnClients, "cell 1 3");
		btnClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    
                    	ClientListJframe cl = new ClientListJframe();
                    	cl.setLocationRelativeTo(null);
                    	ClientListPresenter presenter = new ClientListPresenter(cl);
                    	presenter.start();
                    	
                   
                    }
                });
            }
        });
		
		
		
		
		JButton btnEnterAsAdministrator = new JButton("Enter as Administrator");
		contentPane.add(btnEnterAsAdministrator, "cell 0 5");
		btnEnterAsAdministrator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    
                    	AdminFrame admin = new AdminFrame();
                    	admin.setLocationRelativeTo(null);
                    	AdminPresenter presenter = new AdminPresenter(admin);
                    	presenter.start();
                    	
                   
                    }
                });
            }
        });
		
	}

}