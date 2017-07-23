package client.ui;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import domain.Client;
import domain.Reservation;
import ui.DefaultJFrame;




public class ClientListJframe extends DefaultJFrame implements ClientListView {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1730802074761761866L;
	@SuppressWarnings("unused")
	private ClientListPresenter presenter;
    @SuppressWarnings("rawtypes")
	private DefaultListModel ClientModel;
    
    private JPanel contentPane;
    @SuppressWarnings("rawtypes")
	private JList clientJList;
    
   

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientListJframe frame = new ClientListJframe();
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
	public ClientListJframe() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400, 400, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        
        
        ClientModel = new DefaultListModel();
        clientJList = new JList();
        clientJList.setModel(ClientModel);
        clientJList.setCellRenderer(new DefaultListCellRenderer() {

            
			private static final long serialVersionUID = 8429699550358591681L;

			public Component getListCellRendererComponent(JList list,
                    Object value, int index, boolean isSelected, boolean cellHasFocus) {
                
                Client client = (Client) value;
                String line = client.getName()+ " " + client.getSurname();
                String line_2 = "";
                
                for(Reservation reservation : client.getReservations()){
                	line_2 += "  ," + reservation.getPerformance().getTitle() + " Thesi "+ reservation.getCode();
                }
                
                line+= "   "+ line_2;
               
                	
                return super.getListCellRendererComponent(list, 
                		line,
                		index, isSelected, cellHasFocus);
            }
        });
        
        clientJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
      
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(24)
        					
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					
        					.addPreferredGap(ComponentPlacement.RELATED)
        					)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(18)
        					.addComponent(clientJList, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(70, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(25)
        			.addComponent(clientJList, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE))
        			.addContainerGap(74, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    public void setPresenter(ClientListPresenter presenter) {
        this.presenter = presenter;
        
    }

    @SuppressWarnings("unchecked")
	@Override
    public void setClients(List<Client> clients) {
        ClientModel.clear();
        for(Client client : clients) {
            ClientModel.addElement(client);
        }
        clientJList.setModel(ClientModel);
    }

   
}
