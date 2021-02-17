package MEM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TreasurerFrame extends JFrame{
	
	/**
	 * 
	 */

	private static final int FRAME_WIDTH = 960;
	private static final int FRAME_HEIGHT = 430;

	private static final int AREA_ROWS = 30;
	private static final int AREA_COLUMNS = 30;

 
public static ArrayList<Months> months = new ArrayList<Months>();	
public static ArrayList<String> list = new ArrayList<String>() ;
	
private static PrintWriter createFile(String fileName) {
	
	try{
		
		File listOfNames = new File(fileName);
		
		PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(listOfNames)));
		return infoToWrite;
		
	}
	catch(IOException e){
		System.out.println("An I/O Error Occured");
		
		System.exit(0);
	}
	return null;

	
	
}

private static void createMonthData(ArrayList<Months> month, PrintWriter custOutput){
	custOutput.println(accmoney);
	custOutput.println("x");
	for(Months m: month){
		custOutput.println(m.getName());
		custOutput.println("x");
		custOutput.println(m.getDuty());
		custOutput.println("x");
		custOutput.println(m.getLog());
		custOutput.println("x");
	}
	
	
}


public static void readMonthFile(ArrayList<Months> month) throws Exception{
	
	Scanner input;
	 try {
		input = new Scanner (new File ("monthdata.txt"));
		
		
		
		accmoney = input.nextDouble();
		money.setText("$" + accmoney);
	
	


		for(Months m: month){
		String data = input.next();
		String logting = "";
		String dutyting = "";
		if(data.equals("x")){
				String name = input.next();
			m.setName(name);}
			
			String nextdata = input.next();
			if(nextdata.equals("x")){
				nextdata = input.nextLine();
			while(!(nextdata.equals("x"))){
				dutyting += nextdata + "\n";
				nextdata = input.nextLine();
			}
				}
			nextdata = input.nextLine();
			while(!(nextdata.equals("x"))){
				logting += nextdata + "\n";
				nextdata = input.nextLine();
			}
			
			m.setDuty(dutyting);
			m.setLog(logting);
			
			System.out.println(m.getName());
			System.out.println(m.getDuty());
			System.out.println(m.getLog());
		}
			
			
		input.close();
		
	} catch (FileNotFoundException e) {
		
	}
	
}






	public static double income(double clubmoney, double money){
		double income = money + clubmoney;
		list.add("$ " + money + " was added into the club account" );
		logArea.append("$" + money + " was added into the club account" + "\n");
		//printlog(income);
		return income;
	}
	
	public static double expenses(double clubmoney, double money, String reason){
		double income = clubmoney - money;
		list.add("$ " + money + " was used to pay for club expenses" + reason );
		logArea.append("$" + money + " was used to pay for expenses" + reason + "\n");
		return income;
	}
	
	public static void printlog(double accmoney){
		for (String temp : list) {
			System.out.println(temp);
		}
	}

	
	private static JLabel money;
	
	private static double accmoney = 5000;
	
	
	private JPanel logPanel;
	private static JTextArea logArea;
	private static JTextArea dutyTextArea;
	
	private int i = 0;
	
	public TreasurerFrame(){
		setTitle("Account Log");
		
		Months J = new Months("January" , "", "");
		months.add(J);
		Months F = new Months("February" , "", "");
		months.add(F);
		Months M = new Months("March" , "", "");
		months.add(M);
		Months A = new Months("April" , "", "");
		months.add(A);
		Months May = new Months("May" , "", "");
		months.add(May);
		Months Jun = new Months("June" , "", "");
		months.add(Jun);
		Months Jul = new Months("July" , "", "");
		months.add(Jul);
		Months Aug = new Months("August" , "", "");
		months.add(Aug);
		Months S = new Months("September" , "", "");
		months.add(S);
		Months O = new Months("October" , "", "");
		months.add(O);
		Months N = new Months("November" , "", "");
		months.add(N);
		Months D = new Months("December" , "", "");
		months.add(D);
		
	//	int i = 0;
		
		ListIterator<Months> itr = months.listIterator();
		Months firstmonth = itr.next();
		String firstduty = firstmonth.getDuty();
		String firstlog  = firstmonth.getLog();
		String firstname = firstmonth.getName();
		
		JPanel outsidePanel = new JPanel();
		outsidePanel.setLayout(new BorderLayout());
		logPanel = new JPanel();
		logPanel.setLayout(new BorderLayout());
	    logArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
	    logArea.setText(firstlog);
		logPanel.setBorder(new TitledBorder(new EtchedBorder(), "Money Log"));
	    logPanel.add(logArea);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		
		JPanel moneyPanel = new JPanel();
		moneyPanel.setLayout(new BorderLayout());
		moneyPanel.setBorder(new TitledBorder(new EtchedBorder(), "Club Revenue For The Year"));
		money = new JLabel("$" + accmoney);
		moneyPanel.add(money, BorderLayout.NORTH);
		
		JPanel DutyPanel = new JPanel();
		DutyPanel.setLayout(new BorderLayout());
		dutyTextArea = new JTextArea (15,15);
		dutyTextArea.setText(firstduty);
		DutyPanel.add(dutyTextArea, BorderLayout.CENTER);
		DutyPanel.setBorder(new TitledBorder(new EtchedBorder(), "Duties"));
		
		JPanel fundsPanel = new JPanel();
		fundsPanel.setLayout(new BorderLayout());
		fundsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Funds"));
		
		
		
		
		
		
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(0,2));
		
		JLabel Last = new JLabel("Income");
		top.add(Last);
		
		JLabel First = new JLabel("Expenses");
		top.add(First);
		
		JTextField LastField = new JTextField(20);
		LastField.setText("");
		top.add(LastField);
		
		JTextField FirstField = new JTextField(20);
		FirstField.setText("");
		top.add(FirstField);
		
		fundsPanel.add(top, BorderLayout.NORTH);
		
		
		
		
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		
		JPanel buttonsPan = new JPanel();
		buttonsPan.setLayout(new GridLayout(0,4));
		
		JButton incButton = new JButton("Calculate Income");
		
		
		class incListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   { 
			 if(LastField.getText().equals("")){
				 LastField.setText("error no amount set");
			 }else{
			 String last = LastField.getText();
			 double inc = Double.parseDouble(last);
			 accmoney = income(accmoney, inc);
			 
			 money.setText("$" + accmoney);
			 
			 setVisible(true);}
		   }
		}

		ActionListener Inc = new incListener();
		incButton.addActionListener(Inc);
		buttonsPan.add(incButton);
		
JButton expButton = new JButton("Calculate Expenses");

		class expListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   if(FirstField.getText().equals("")){
					 FirstField.setText("error no amount set");
				 }else{  
			 String first = FirstField.getText();
			 double exp = Double.parseDouble(first);
			 accmoney = expenses(accmoney, exp, "");
			 
			
			 money.setText("$" + accmoney);
		
			 setVisible(true);}
		   }
		}

		ActionListener Exp = new expListener();
		expButton.addActionListener(Exp);
		buttonsPan.add(expButton);
		
		
JButton loadButton = new JButton("Load Data");
		
		class loadListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   try {
				   
				readMonthFile(months);
				String log = months.get(i).getLog();
				String duty = months.get(i).getDuty();
				logArea.setText(log);
				dutyTextArea.setText(duty);
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 setVisible(true);
		   }
		}

		ActionListener load = new loadListener();
		loadButton.addActionListener(load);
		buttonsPan.add(loadButton);
		
		JButton clearButton = new JButton("Save");
		class clearListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   months.get(i).setDuty(dutyTextArea.getText());
			   months.get(i).setLog(logArea.getText());
		
			 PrintWriter monthOutput = createFile("monthdata.txt");
			 
			 createMonthData(months, monthOutput);
			 
			 monthOutput.close();

			 setVisible(true);
		   }
		}

		ActionListener Clear = new clearListener();
		clearButton.addActionListener(Clear);
		buttonsPan.add(clearButton);
		
		
		bottom.add(buttonsPan, BorderLayout.SOUTH);
		fundsPanel.add(bottom, BorderLayout.SOUTH );
		
		
		rightPanel.add(moneyPanel, BorderLayout.NORTH);
		rightPanel.add(DutyPanel, BorderLayout.CENTER);
		rightPanel.add(fundsPanel, BorderLayout.SOUTH);
		
		
		
		JLabel month = new JLabel("Change Month:		" + months.get(i).getName());
		
		controlPanel.add(month, BorderLayout.NORTH);
		JButton prev = new JButton("<-");
		class prevListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   
			   months.get(i).setDuty(dutyTextArea.getText());
			   months.get(i).setLog(logArea.getText());
			   
			   if(i == 0){
				   i = 11;
				  String duty = months.get(i).getDuty();
				   String log = months.get(i).getLog(); 
				  String name = months.get(i).getName();
				  month.setText("Change Month:		" + name);
					logArea.setText(log);
					dutyTextArea.setText(duty);
			   }
			   else{
				   i--;
				   String duty = months.get(i).getDuty();
				   String log = months.get(i).getLog(); 
				  String name = months.get(i).getName();
				  month.setText("Change Month:		" + name);
					logArea.setText(log);
					dutyTextArea.setText(duty);
			   }
			   
			   
			 setVisible(true);
		   }
		}

		ActionListener pre = new prevListener();
		prev.addActionListener(pre);
		controlPanel.add(prev, BorderLayout.WEST);
		
		JButton next = new JButton("->");
		class nextListener implements ActionListener
		{  
			
		   public void actionPerformed(ActionEvent event)
		   {  
			   
			   months.get(i).setDuty(dutyTextArea.getText());
			   months.get(i).setLog(logArea.getText());
			   
			   if(i == 11){
				   i = 0;
				  String duty = months.get(i).getDuty();
				   String log = months.get(i).getLog(); 
				  String name = months.get(i).getName();
				  month.setText("Change Month:		" + name);
					logArea.setText(log);
					dutyTextArea.setText(duty);
			   }
			   else{
				   i++;
				   String duty = months.get(i).getDuty();
				   String log = months.get(i).getLog(); 
				  String name = months.get(i).getName();
				  month.setText("Change Month:		" + name);
					logArea.setText(log);
					dutyTextArea.setText(duty);
			   }
		
			 setVisible(true);
		   }
		}

		ActionListener nex = new nextListener();
		next.addActionListener(nex);
		controlPanel.add(next, BorderLayout.EAST);
		
		
		
		leftPanel.add(logPanel,BorderLayout.CENTER);
		leftPanel.add(controlPanel, BorderLayout.SOUTH);
		
		outsidePanel.add(leftPanel, BorderLayout.WEST);
		outsidePanel.add(rightPanel, BorderLayout.CENTER);
		
		add(outsidePanel);
		
		 setSize(FRAME_WIDTH, FRAME_HEIGHT);
		 setAlwaysOnTop(true);
		
	}
}
