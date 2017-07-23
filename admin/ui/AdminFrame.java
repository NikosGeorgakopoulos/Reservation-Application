package admin.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import performance.ui.CreatePerformanceFrame;
import performance.ui.CreatePerformancePresenter;
import performance.ui.PerformanceListJframe;
import performance.ui.PerformanceListPresenter;
import ui.DefaultJFrame;

import javax.swing.JButton;

public class AdminFrame extends DefaultJFrame implements AdminView {

	
	private static final long serialVersionUID = -1108369595382037393L;
	/**
	 * 
	 */
	
	private JPanel contentPane;
	private AdminPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][]", "[][][][][][][][][]"));
		
		JButton btnCreatePerfomance = new JButton("Create Performance");
		contentPane.add(btnCreatePerfomance, "cell 0 0,growx");
		btnCreatePerfomance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    
                    	CreatePerformanceFrame perf = new CreatePerformanceFrame();
                    	perf.setLocationRelativeTo(null);
                    	CreatePerformancePresenter presenter = new CreatePerformancePresenter(perf);
                    	 presenter.start();
                    	
                   
                    }
                });
            }
        });
		
		
		
		JButton btnEditPlay = new JButton("Performances");
		contentPane.add(btnEditPlay, "cell 0 2,growx");
		btnEditPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    
                    	PerformanceListJframe plist = new PerformanceListJframe();
                    	plist.setLocationRelativeTo(null);
                    	PerformanceListPresenter presenter = new PerformanceListPresenter(plist);
                    	 presenter.start();
                    	
                   
                    }
                });
            }
        });
		
		
		JButton btnBack = new JButton("Back");
		contentPane.add(btnBack, "cell 9 8,alignx right,aligny bottom");
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				CancelButtonActionPerformed(e);
			}


		});
	}

	
	public void setPresenter(AdminPresenter presenter) {
		this.presenter=presenter;
		
	}
	private void CancelButtonActionPerformed(ActionEvent e) {
		presenter.cancel();
		
	}


}
