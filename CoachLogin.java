package MEM;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CoachLogin extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new TreasurerLogin();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public CoachLogin(){
		initialize();
		 setVisible(true);
	}
	
	public void initialize(){
		setTitle("Login");
		setSize(300,150);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		JPanel mPan = new JPanel();
		mPan.setLayout(new GridLayout(0,1));
		
		JPanel topPan = new JPanel();
		topPan.setLayout(new GridLayout(0,2));
		
	JLabel user = new JLabel("Username: ");
		JTextField userTF = new JTextField(10);
		topPan.add(user);
		topPan.add(userTF);
		
		JLabel pass = new JLabel("Password: ");
		JPasswordField passField = new JPasswordField(10);
		topPan.add(pass);
		topPan.add(passField);
		
		mPan.add(topPan);
		
		JPanel bottomPan = new JPanel();
		bottomPan.setLayout(new GridLayout(0,3));
		
		bottomPan.add(new JPanel());
		
		JButton login = new JButton("Login");
		class logListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			 String userin = userTF.getText();
			  String passin = new String(passField.getPassword());
			  
			  if(userin.equals("coach") && passin.equals("coach")){
				  JOptionPane.showMessageDialog(null,"Welcome");
		            dispose();
		           JFrame frame = new CoachMain();  
		   		   frame.setLocationRelativeTo(null);
				   frame.setAlwaysOnTop(true);
		           frame.setVisible(true);
			  }else{
				  JOptionPane.showMessageDialog(null,"Please enter the correct username and password");
				  
			  }
			  userTF.setText("");
		     passField.setText("");
		   }
		}

		ActionListener logger = new logListener();
		login.addActionListener(logger);
		bottomPan.add(login);
		bottomPan.add(new JPanel());
		
		mPan.add(bottomPan);
		add(mPan);
		 
		 setVisible(true);
	}
	
}
