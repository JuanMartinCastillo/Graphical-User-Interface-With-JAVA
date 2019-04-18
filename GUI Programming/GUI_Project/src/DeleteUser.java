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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeleteUser extends JFrame implements WindowListener,ActionListener{
	
	JTextField user_id = null;
	public DeleteUser() {
	
	this.setVisible(true);
	this.setSize(500, 200);
	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new BorderLayout());
	this.addWindowListener(this);
	
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(3,1));
		this.add(info, BorderLayout.WEST);
	
			JLabel userID = new JLabel("USER ID: ");
			info.add(userID);
			
		JPanel data = new JPanel();
		data.setLayout(new GridLayout(3,1));
		this.add(data, BorderLayout.CENTER);
		  
		    user_id = new JTextField();
			data.add(user_id);
			
		JPanel top = new JPanel();
		this.add(top, BorderLayout.NORTH);
		JLabel title = new JLabel("DELETE USER");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.BOLD, 20));
		top.add(title);
		
		JPanel bottom = new JPanel();
		this.add(bottom, BorderLayout.SOUTH);
			
			JButton close = new JButton("DELETE USER");
			close.addActionListener(this);
			close.setActionCommand("delete");
			bottom.add(close);
			JButton cancel = new JButton("CANCEL");
			cancel.addActionListener(this);
			cancel.setActionCommand("cancel");
			bottom.add(cancel);
			validate();
			repaint();
							
		
}

public void delTicket(){
	try {
		
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		}catch(Exception e ){}
				
	    Connection conn = null;
    	Statement stmt = null;
    	
    	try {
    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

    	    stmt = conn.createStatement();
    	   
    	    String u_id = user_id.getText();
    	   
    	    
    	    if (stmt.execute("DELETE FROM `ticketsystem`.`user` WHERE id = '"+u_id+"' ;")) {
    	    }
    	  	    	   
    	} catch (SQLException ex) {
    	    
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	
}


@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("delete")) {
		
		int n = JOptionPane.showConfirmDialog(this,
			    "Are you sure that you want to delete this user?",
			    "Confirm",
			    JOptionPane.YES_NO_OPTION);
		if(n == 0) {
		delTicket();
		this.setVisible (false);
		this.dispose();
		}else if(n == 1) {
			this.setVisible (false);
			this.dispose();
		}
		
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