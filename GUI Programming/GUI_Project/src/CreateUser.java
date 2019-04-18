import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateUser extends JFrame implements WindowListener,ActionListener {
	
	JTextField username = null;
	JTextField password = null;
	JComboBox type = null;
	
public CreateUser() {
		
		this.setVisible(true);
		this.setSize(500, 200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.addWindowListener(this);
		
			JPanel info = new JPanel();
			info.setLayout(new GridLayout(3,1));
			this.add(info, BorderLayout.WEST);
		
				JLabel tec = new JLabel("Username");
				info.add(tec);
				JLabel desc = new JLabel("Password");
				info.add(desc);
				JLabel cate = new JLabel("User type");
				info.add(cate);
				
			JPanel data = new JPanel();
			data.setLayout(new GridLayout(3,1));
			this.add(data, BorderLayout.CENTER);
			  
				username = new JTextField();
				data.add(username);
				password = new JTextField();
				data.add(password);
				String[] typ = {"tech", "admin", "manager"};
			    type = new JComboBox(typ);
			    type.setSelectedIndex(2);
				data.add(type);
				
			JPanel top = new JPanel();
			this.add(top, BorderLayout.NORTH);
			JLabel title = new JLabel("CREATE NEW USER");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("serif", Font.BOLD, 20));
			top.add(title);
			
			JPanel bottom = new JPanel();
			this.add(bottom, BorderLayout.SOUTH);
				
				JButton create = new JButton("CREATE USER");
				create.addActionListener(this);
				create.setActionCommand("create");
				bottom.add(create);
				JButton cancel = new JButton("CANCEL");
				cancel.addActionListener(this);
				cancel.setActionCommand("cancel");
				bottom.add(cancel);
				
				validate();
				repaint();
			
		
	}


	public void newUser(){
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
						
		    Connection conn = null;
	    	Statement stmt = null;
	    	try {
	    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

	    	    stmt = conn.createStatement();
	    	   
	    	    String un = username.getText();
	    	    String pass = password.getText();
	    	    String ty = (String) type.getSelectedItem();
	    	    
	    	    if (stmt.execute("INSERT INTO `ticketsystem`.`user` (`username`, `password`, `type`) VALUES ('"+un+"', '"+pass+"', '"+ty+"');")) {
	    	        
	    	    }
	    	  	    	   
	    	} catch (SQLException ex) {
	    	    
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
			
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("create")) {
			newUser();
			this.setVisible (false);
			this.dispose();
			}else if(e.getActionCommand().equals("cancel")){
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
