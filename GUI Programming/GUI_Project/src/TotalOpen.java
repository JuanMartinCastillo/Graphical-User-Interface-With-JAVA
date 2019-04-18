import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TotalOpen extends JFrame  implements WindowListener{
    public TotalOpen(){
    
    	this.setSize(500,500);
    	this.setVisible(true);
    	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new BorderLayout());
    	this.addWindowListener(this);
    	
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	try {
    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

    	    stmt = conn.createStatement();
    	    rs = stmt.executeQuery("select * from tickets WHERE status = 'open';");
    	    
    	    String[][] data = new String[100][4];
    	    int counter = 0;
    	    
    	    while(rs.next()){
    	    	String number = rs.getString("number");      
     	       
    	    	data[counter][0] = number;
    	      
    	        String u_id = rs.getString("Tech");
    	    	data[counter][1] = u_id;    	      
    	        
    	        String date = rs.getString("date");
    	    	data[counter][2] = date;
    	    	
 
    	        counter = counter + 1;
    	    }
    	    

    	    String[] colNames = {"Ticket Number", "Tech in charge","Date opened"};
    	    
    	    JPanel list = new JPanel();
			this.add(list, BorderLayout.CENTER);
				JTable table = new JTable(data, colNames) {
					@Override
					public boolean isCellEditable(int rowIndex, int vColIndex) {
						  return false;
			        }
				};
				
			list.add(table);
    	    JScrollPane sr = new JScrollPane(table);
    	    this.add(sr);
    	   
    	    String CONT = Integer.toString(counter * 50);
    	    JPanel total = new JPanel();
    	    this.add(total, BorderLayout.SOUTH);
    	    total.setLayout(new GridLayout());
    	    JLabel TOTAL = new JLabel("                    " + "OPEN TICKETS: " + counter);
    	    total.add(TOTAL);
    	    JLabel count = new JLabel("TOTAL COST €" + CONT);
    	    total.add(count);
    	    
    	} catch (SQLException ex) {
    	    // handle any errors
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	
    	validate();
    	repaint();
    	
    }

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
			this.setVisible (false);
			this.dispose();
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
