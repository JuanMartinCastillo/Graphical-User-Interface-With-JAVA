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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Admin extends JFrame implements WindowListener,ActionListener {

	public Admin() {
		
		
		this.setVisible(true);
		this.setSize(600, 400);
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
				JLabel user = new JLabel("You are loged as ADMIN");
				user.setHorizontalAlignment(SwingConstants.CENTER);
				user.setFont(new Font("serif", Font.BOLD, 20));
				top.add(user, BorderLayout.CENTER);
				JButton ref = new JButton("=>");
				ref.addActionListener(this);
				ref.setActionCommand("ref");
				top.add(ref, BorderLayout.EAST);
		
		
			JPanel ticketOption = new JPanel();
			this.add(ticketOption, BorderLayout.WEST);
			ticketOption.setLayout(new GridLayout(4,1));
				
				JButton create = new JButton("Create User");
				create.addActionListener(this);
				create.setActionCommand("create");
				ticketOption.add(create);
				JButton delete = new JButton("Delete User");
				delete.addActionListener(this);
				delete.setActionCommand("delete");
				ticketOption.add(delete);
				JButton changeUN = new JButton("Change Username");
				changeUN.addActionListener(this);
				changeUN.setActionCommand("changeUN");
				ticketOption.add(changeUN);
				JButton changePass = new JButton("Change User Password");
				changePass.addActionListener(this);
				changePass.setActionCommand("changePass");
				ticketOption.add(changePass);
							
		
		
		Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

    	    stmt = conn.createStatement();
    	    rs = stmt.executeQuery("select * from user;");

    	    String[][] data = new String[100][4];
    	    int counter = 0;
    	    
    	    while(rs.next()){
    	    	String id = rs.getString("id");      
    	    	data[counter][0] = id;
    	        String username = rs.getString("username");
    	    	data[counter][1] = username;
    	        String password = rs.getString("password");
    	    	data[counter][2] = password;
    	    	String type = rs.getString("type");
    	    	data[counter][3] = type;
    	        
    	        counter = counter + 1;
    	    }
    	    
    	    String[] colNames = {"ID", "Username","Password", "Account type"};  
    	    
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
		
		if(e.getActionCommand().equals("create")) {
			
			new CreateUser();
			
		}else if(e.getActionCommand().equals("delete")) {
			
			new DeleteUser();
			
		}else if(e.getActionCommand().equals("changeUN")) {
			
			new ChangeName();
			
		}else if (e.getActionCommand().equals("changePass")) {
			
			new ChangePass();
			
		}
		
		if (e.getActionCommand().equals("ref")) {
		 new Admin();
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
