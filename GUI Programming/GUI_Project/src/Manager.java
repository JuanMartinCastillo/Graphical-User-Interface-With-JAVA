import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class Manager extends JFrame implements WindowListener,ActionListener {
	
	JTextField username = null;
	public Manager() {
		
		
		this.setVisible(true);
		this.setSize(800, 400);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.addWindowListener(this);
		
			
		
		
			JPanel top = new JPanel();
			this.add(top, BorderLayout.NORTH);
			top.setLayout(new BorderLayout());
				JButton logout = new JButton("Logout");
				logout.addActionListener(this);
				logout.setActionCommand("logout");
				top.add(logout, BorderLayout.WEST);
				JLabel user = new JLabel("You are loged in as a Manager");
				user.setHorizontalAlignment(SwingConstants.CENTER);
				user.setFont(new Font("serif", Font.BOLD, 20));
				top.add(user, BorderLayout.CENTER);
				JButton ref = new JButton("=>");
				ref.addActionListener(this);
				ref.setActionCommand("ref");
				top.add(ref, BorderLayout.EAST);
		
		
			JPanel ticketOption = new JPanel();
			this.add(ticketOption, BorderLayout.WEST);
			ticketOption.setLayout(new GridLayout(2,1));
				
				JButton open = new JButton("Open Tickets");
				open.addActionListener(this);
				open.setActionCommand("open");
				ticketOption.add(open);
				JButton close = new JButton("Closed Ticket");
				close.addActionListener(this);
				close.setActionCommand("close");
				ticketOption.add(close);
				
							
		
		
		Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

    	    stmt = conn.createStatement();
    	    rs = stmt.executeQuery("select * from tickets ORDER BY priority DESC;");
    	   

    	    String[][] data = new String[100][7];
    	    int counter = 0;
    	    while(rs.next()){
    	    	String number = rs.getString("number");      
    	       
    	    	data[counter][0] = number;
    	      
    	        String u_id = rs.getString("Tech");
    	    	data[counter][1] = u_id;    	      
    	        
    	        String date = rs.getString("date");
    	    	data[counter][2] = date;
    	    	
    	    	 String des = rs.getString("description");
     	    	data[counter][3] = des;
     	    	
     	    	String pri = rs.getString("priority");
     	    	data[counter][4] = pri;
     	    	
     	    	String st = rs.getString("status");
     	    	data[counter][5] = st;
     	    	
     	    	String cd = rs.getString("closeDate");
     	    	data[counter][6] = cd;
    	        
    	        counter = counter + 1;
    	        
    	    }
    	   
    	    String[] colNames = {"Ticket Number", "Tech in charge","Date opened", "Description", "Priority", "Status", "Date Closed"};  
    	    
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
    	    
    	   // String CONT = Integer.toString(counter * 50);
    	    
    	   // JPanel total = new JPanel();
    	   // this.add(total, BorderLayout.SOUTH);
    	   // JLabel TOTAL = new JLabel("TOTAL COST OF TICKETS");
    	   // total.add(TOTAL);
    	  //  JLabel count = new JLabel("€" + CONT);
    	  //  total.add(count);
        	
    	} catch (SQLException ex) {
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	
    	validate();
		repaint();
    }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("open")) {
			
			new TotalOpen();
			
		}else if(e.getActionCommand().equals("close")) {
			
			new TotalClosed();
			
		}
		
		if (e.getActionCommand().equals("ref")) {
		 new Manager();
		 this.setVisible (false);
		 this.dispose();
		}
		
		if (e.getActionCommand().equals("logout")){
			
			int n = JOptionPane.showConfirmDialog(this,
				    "Do you want to logout?",
				    "Confirm",
				    JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				new Login();
				this.setVisible (false);
				this.dispose();
			}else if(n == 1) {
				
			}
			
		}
			
		
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
		if(JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_NO_OPTION) {
			new Login();
			this.setVisible (false);
			this.dispose();
		}
		
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
