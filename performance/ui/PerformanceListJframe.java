package performance.ui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;



import domain.Performance;

import ui.DefaultJFrame;

public class PerformanceListJframe extends DefaultJFrame implements PerformanceListView {
	
	private static final long serialVersionUID = -1730802074761761866L;
	private PerformanceListPresenter presenter;
    @SuppressWarnings("rawtypes")
	private DefaultListModel PerformanceModel;
    
    private JPanel contentPane;
    @SuppressWarnings("rawtypes")
	private JList performanceJList;
    private JButton btndelete;
    private JButton btnedit;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
    private JButton btnStatistics;
    
   

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	PerformanceListJframe frame = new PerformanceListJframe();
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
	public PerformanceListJframe() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(700, 700, 700, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        
        
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
        
        performanceJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        btndelete = new JButton("Delete");
        btndelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		presenter.deleteSelected();
        	}
        });
        
        btnStatistics = new JButton("View Statistics");
        btnStatistics.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		presenter.ShowSelectedStatistics();
        	}
        });
        
                     
        btnedit = new JButton("Edit");
        btnedit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		presenter.editSelected();
        	}
        });
        
        
      
        
       
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(24)
        					.addComponent(btnedit)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btndelete)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnStatistics)
        					)
        					        					
        					.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(18)
        					.addComponent(performanceJList, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(70, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(25)
        			.addComponent(performanceJList, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				
        				.addComponent(btnedit)
        				.addComponent(btndelete)
        				.addComponent(btnStatistics)
        				)
        			.addContainerGap(74, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    public void setPresenter(PerformanceListPresenter presenter) {
        this.presenter = presenter;
        
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

}
