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

public class CoachMain extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 100;
	JPanel panel = new JPanel();
	
	public CoachMain() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Coach Main Menu");

		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		option();

		main.add(panel);
		add(main);
	}
	
	public void option(){
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), ""));
		
		JPanel inner = new JPanel();

		JButton log = new JButton("Notify Members");
		class logListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   try {
				   msgApp window = new msgApp();
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 setVisible(true);
		   }
		}

		ActionListener logger = new logListener();
		log.addActionListener(logger);
		
		JButton add = new JButton("Add/Remove Members");
		class addListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   try {
				JFrame a = new MembersFrame();
				a.setVisible(true);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 setVisible(true);
		   }
		}

		ActionListener adder = new addListener();
		add.addActionListener(adder);
		
		/*
		JButton payables = new JButton("_________");
		class payListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   try {
				JFrame a = new AccountPayable();
				a.setVisible(true);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 setVisible(true);
		   }
		}

		ActionListener payer = new payListener();
		payables.addActionListener(payer);
		
		*/
		
		
		
		inner.add(log, BorderLayout.WEST);
		inner.add(add, BorderLayout.CENTER);
		//inner.add(payables, BorderLayout.EAST);
		panel.add(inner, BorderLayout.CENTER);
		setAlwaysOnTop(true);
		
	
	
	}
	
	
	
	
	
	
	
	
	
	
}