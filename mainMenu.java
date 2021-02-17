package MEM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class mainMenu extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 100;
	JPanel panel = new JPanel();

	public mainMenu() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		buttons();
		
		main.add(panel);
		add(main);
		setVisible(true);
	}
	
	public void buttons(){
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), ""));
		
		JPanel inner = new JPanel();

		JButton t = new JButton("Treasurer");
		class tListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   try {
				JFrame a = new TreasurerLogin();
				a.setVisible(true);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 setVisible(true);
		   }
		}

		ActionListener logger = new tListener();
		t.addActionListener(logger);
		
		
		JButton c = new JButton("Coach");
		class cListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   try {
				JFrame a = new CoachLogin();
				a.setVisible(true);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 setVisible(true);
		   }
		}

		ActionListener coach = new cListener();
		c.addActionListener(coach);
		
		
		
		
	    t.setBounds(20,30,50,30);;
	    c.setBounds(20,30,50,30);;
		inner.add(t, BorderLayout.WEST);
		inner.add(c, BorderLayout.EAST);
		panel.add(inner, BorderLayout.CENTER);
	
	
	
	
	}
	
	
	
	
	
	
	
}
