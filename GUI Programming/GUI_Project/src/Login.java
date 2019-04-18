import java.awt.BorderLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



public class Login extends JFrame implements WindowListener,ActionListener {
	
	JTextField username = null;
	JPasswordField  password = null;

	public Login(){
		
			this.setVisible(true);
			this.setSize(300,150);
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			this.setLayout(new BorderLayout());
			this.addWindowListener(this);
			
				JPanel info = new JPanel();
				this.add(info, BorderLayout.NORTH);
				info.setLayout(new GridLayout(2,2));
					JLabel name = new JLabel("Username");
					info.add(name);
				    username = new JTextField(20);
					info.add(username);
					
					JLabel pass = new JLabel("Password");
					info.add(pass);
					password = new  JPasswordField (20);
					info.add(password);
										
			JPanel action = new JPanel();
			this.add(action, BorderLayout.SOUTH);
			action.setLayout(new GridLayout(2,1));
			
				JButton log = new JButton("Login");
				action.add(log);
				log.addActionListener(this);
				log.setActionCommand("log");
			
				JButton exit = new JButton("Exit");
				action.add(exit);
				exit.addActionListener(this);
				exit.setActionCommand("exit");
			
			validate();			
			repaint();
			
			}
	
		public void loginWithDatabase(){
			
			try {
				
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
	    	try {
	    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

	    	    stmt = conn.createStatement();

	    	    String un = username.getText();
	    	    String pw = password.getText();
	    	    
	    	    
	    	    
	    	    if (stmt.execute("select * from user where username = '"+un+"' and password = '"+pw+"'")) {
	    	    	   
	    	    	//if(rs == null) {
	 	    	  //     	 JOptionPane.showMessageDialog(null,"Incorrect username or password, please try again" ,"alert" , JOptionPane.ERROR_MESSAGE);
	 	    	  //  	 new Login();
	 	    //}
	    	        
	    	      rs = stmt.getResultSet();
	    	      
	    	    	 while(rs.next()){
	    		    	    String type = rs.getString("type");

	    		    	           if(type.equals("tech")) {

	    		    	        	new Tech();
	    		    	        	
	    		    	         }else if(type.equals("manager")) {

	    		    	        	 new Manager();
	    		    	        	 
	    		    	         }else if(type.equals("admin")) {
	    		    	        	 
	    		    	        	 new Admin();
	    		    	        	 
	    		    	         }
	    		    	           
	    		    	           
	    		    	           }    					
	    	     
	    	     }
	    	 
	    	    
	    	  } catch (SQLException ex) {
	    	   
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	    	  				
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("log")){
				loginWithDatabase();
				this.setVisible (false);
				this.dispose();
			}else if(e.getActionCommand().equals("exit")){
				this.setVisible (false);
				this.dispose();
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
	

