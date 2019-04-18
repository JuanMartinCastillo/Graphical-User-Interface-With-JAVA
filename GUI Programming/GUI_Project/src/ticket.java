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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ticket extends JFrame implements WindowListener,ActionListener {
	

	JTextField des = null;
	JTextField date = null;
	JComboBox cat = null;
	JComboBox techNames = null;
	
	
	
	
	public ticket() {
		
		this.setVisible(true);
		this.setSize(500, 200);
		this.setLayout(new BorderLayout());
		this.addWindowListener(this);
		
			JPanel info = new JPanel();
			info.setLayout(new GridLayout(3,1));
			this.add(info, BorderLayout.WEST);
		
				JLabel tec = new JLabel("Assign to ");
				info.add(tec);
				JLabel desc = new JLabel("Describe the issue in few words ");
				info.add(desc);
				JLabel cate = new JLabel("Select a category ");
				info.add(cate);
				
			JPanel data = new JPanel();
			data.setLayout(new GridLayout(3,1));
			this.add(data, BorderLayout.CENTER);
			  
			
			    String[] techNa = {"Johan", "James", "John"};
			    techNames = new JComboBox(techNa);
			    techNames.setSelectedIndex(2);
				data.add(techNames);
				des = new JTextField();
				data.add(des);
				String category[] = {"Normal", "Urgent", "Long term"};
				cat = new JComboBox(category);
				cat.setSelectedIndex(2);
				data.add(cat);
				
			JPanel top = new JPanel();
			this.add(top, BorderLayout.NORTH);
			JLabel title = new JLabel("CREATE A TICKET");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("serif", Font.BOLD, 20));
			top.add(title);
			
			JPanel bottom = new JPanel();
			this.add(bottom, BorderLayout.SOUTH);
				
				JButton create = new JButton("CREATE TICKET");
				create.addActionListener(this);
				create.setActionCommand("create");
				bottom.add(create);
				JButton cancel = new JButton("CANCEL");
				cancel.addActionListener(this);
				cancel.setActionCommand("cancel");
				bottom.add(cancel);
			
	}

	public void openTicket(TimeZone GMT){
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
						
		    Connection conn = null;
	    	Statement stmt = null;
	    	try {
	    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ticketsystem?user=root&password=");

	    	    stmt = conn.createStatement();
	    	   
	    	    String de = (String)techNames.getSelectedItem();
	    	    String descrip = des.getText();
	    	    String pr = (String) cat.getSelectedItem();
	    	    Date date = new Date(Instant.now().getEpochSecond() * 1000L);
	    	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS", Locale.ENGLISH);
	    	    format.setTimeZone(TimeZone.getTimeZone("GMT/UTC"));
	    	    String time = format.format(date);
	    	    
	    	    if (stmt.execute("INSERT INTO `ticketsystem`.`tickets` (`Tech`, `date`, `description`, `priority`,  `status`  ) VALUES ('"+de+"', '"+time+"', '"+descrip+"','"+pr+"', 'Open');")) {
	    	        
	    	    }
	    	  	    	   
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
			openTicket(null);
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
