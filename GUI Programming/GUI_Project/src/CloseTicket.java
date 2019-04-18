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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CloseTicket extends JFrame implements WindowListener,ActionListener{
	
	JTextField ticketNumber = null;
	
	public CloseTicket() {
	
	this.setVisible(true);
	this.setSize(500, 200);
	this.setLayout(new BorderLayout());
	this.addWindowListener(this);
	
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(3,1));
		this.add(info, BorderLayout.WEST);
	
			JLabel tNumber = new JLabel("Ticket Number: ");
			info.add(tNumber);
			
		JPanel data = new JPanel();
		data.setLayout(new GridLayout(3,1));
		this.add(data, BorderLayout.CENTER);
		  
		    ticketNumber = new JTextField();
			data.add(ticketNumber);
			
		JPanel top = new JPanel();
		this.add(top, BorderLayout.NORTH);
		JLabel title = new JLabel("CLOSE A TICKET");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.BOLD, 20));
		top.add(title);
		
		JPanel bottom = new JPanel();
		this.add(bottom, BorderLayout.SOUTH);
			
			JButton close = new JButton("CLOSE TICKET");
			close.addActionListener(this);
			close.setActionCommand("close");
			bottom.add(close);
			JButton cancel = new JButton("CANCEL");
			cancel.addActionListener(this);
			cancel.setActionCommand("cancel");
			bottom.add(cancel);
						
		validate();
		repaint();
		
}


public void closingTicket(TimeZone GMT){
	try {
		
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		}catch(Exception e ){}
				
	    Connection conn = null;
    	Statement stmt = null;
    	
    	try {
    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

    	    stmt = conn.createStatement();
    	   
    	    String tn = ticketNumber.getText();
    	    Date date = new Date(Instant.now().getEpochSecond() * 1000L);
    	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS", Locale.ENGLISH);
    	    format.setTimeZone(TimeZone.getTimeZone("GMT/UTC"));
    	    String timeClosed = format.format(date);
    	    
    	    if (stmt.execute("UPDATE `ticketsystem`.`tickets` SET status = 'Closed', closeDate = '"+timeClosed+"' WHERE number = '"+tn+"' ;")) {
    	    }
    	    
    	  	    	   
    	} catch (SQLException ex) {
    	    
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("close")) {
		 
		int n = JOptionPane.showConfirmDialog(this,
			    "Are you sure you want to mark this ticket as closed?",
			    "Confirm",
			    JOptionPane.YES_NO_OPTION);
		if(n ==0) {
		closingTicket(null);
		this.setVisible (false);
		this.dispose();
		}else if(n==1) {
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
