package MEM;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MembersFrame extends JFrame {
	
	private JTextField NameField;
	private JTextField NumField;
	private JTextField emailField;
	private JTextField telField;
	private JTextField addressField;
	
	private JTextArea paidArea;
	private JTextArea unPaidArea;
	
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 300;

	private static final int AREA_ROWS = 30;
	private static final int AREA_COLUMNS = 30;
	
	
	private static MemberList members;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new MembersFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public MembersFrame() throws Exception {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Add/Remove Members");
		members = new MemberList();
		readMembersFile(members);
		
		initComponents();
		
		refresh();
		setVisible(true);
		
	
	}	
		
	private static ArrayList<Member> paidMembers;
	private static ArrayList<Member> unpaidMembers;
	
	public void refresh(){
		//unpaid = members.getUnPaidMembers();
		
		unpaidMembers = new ArrayList<Member>();
		for (int i = 0; i < members.size(); i++){
			if (members.get(i).getPaid() == false){
				unpaidMembers.add(members.get(i));
			}
		}
		String unpaidMem = "";
		for(Member m: unpaidMembers){
			unpaidMem += m.getName() + "\n";
		}
		
		unPaidArea.setText(unpaidMem);
		setVisible(true);
		
		
		//paid = members.getPaidMembers();
		paidMembers = new ArrayList<Member>();
		for (int i = 0; i < members.size(); i++){
			if (members.get(i).getPaid() == true){
				paidMembers.add(members.get(i));
			}
		}
		String paidMem = "";
		for(Member m: paidMembers){
			paidMem += m.getName() + "\n";
		}
		paidArea.setText(paidMem);
		setVisible(true);
		
		for(Member m: members){
			System.out.println(m.getName());
		}
		
		System.out.println("unpaid");
		for(Member m: unpaidMembers){
			System.out.println(m.getName());
		}
		System.out.println("paid");
		for(Member m: paidMembers){
			System.out.println(m.getName());
		}
		
		setVisible(true);
		
	}
	
	
	public void initComponents()
	{
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,3));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBorder(new TitledBorder(new EtchedBorder(), "Paid Members"));
		paidArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		leftPanel.add(paidArea);
		mainPanel.add(leftPanel);
		//------------------------------------------------------------------------------------------------------------------------------
		
		
		JPanel mainMidPanel = new JPanel();
		mainMidPanel.setLayout(new GridLayout(0,1));
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BorderLayout());
		middlePanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(0,2));
		
		JLabel Name = new JLabel("Name");
		top.add(Name);
		
		JLabel Number = new JLabel("Number");
		top.add(Number);
		
		NameField = new JTextField(20);
		NameField.setText("");
		top.add(NameField);
		
		NumField = new JTextField(20);
		NumField.setText("");
		top.add(NumField);
		
		middlePanel.add(top, BorderLayout.NORTH);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		JLabel address = new JLabel("Address");
		bottom.add(address, BorderLayout.NORTH);
		
		addressField = new JTextField(40);
		addressField.setText("");
		bottom.add(addressField, BorderLayout.CENTER);
		
		JPanel buttonsPan = new JPanel();
		buttonsPan.setLayout(new GridLayout(0,2));
		
		JButton paidButton = new JButton("ADD Paid");
		class paidListener implements ActionListener
		{  
		   public void actionPerformed(ActionEvent event)
		   { 
			   if(NameField.getText().equals("")){NameField.setText("MUST INSERT NAME");}
			   else{
			members.add(new Member(
			NameField.getText(),
			NumField.getText(),
			addressField.getText(),true, true, 60.0));
			
			refresh();
			   }
			
		   }
		}
		
		ActionListener paider = new paidListener();
		paidButton.addActionListener(paider);
		buttonsPan.add(paidButton);
		
		JButton unPaidButton = new JButton("ADD UnPaid");
		class unPaidListener implements ActionListener
		{  
		   public void actionPerformed(ActionEvent event)
		   { 
			   if(NameField.getText().equals("")){NameField.setText("MUST INSERT NAME");}
			   else{
			members.add(new Member(
			NameField.getText(),
			NumField.getText(),
			addressField.getText(),true, false, 60.0));
			
			refresh();
			   }
		   }
		}
		
		ActionListener unpaider = new unPaidListener();
		unPaidButton.addActionListener(unpaider);
		buttonsPan.add(unPaidButton);
		
		
		bottom.add(buttonsPan, BorderLayout.SOUTH);
		
		middlePanel.add(bottom, BorderLayout.SOUTH);
		
		
		JPanel middleBottomPanel = new JPanel();
		middleBottomPanel.setLayout(new GridLayout(0,2));
		
		
		JButton removeButton = new JButton("Remove Member");
		class removeListener implements ActionListener
		{  
		   public void actionPerformed(ActionEvent event)
		   {  
			for(Member m: members){
			  if(NameField.getText().equalsIgnoreCase(m.getName())){
				  if (m.getPaid() == false){
					  unpaidMembers.remove(m);
					  }
				  else{
				  paidMembers.remove(m);
				  }
				  members.remove(m);
			  }
			  
			}
			refresh();
		   }
		}
		
		ActionListener remover = new removeListener();
		removeButton.addActionListener(remover);
		middleBottomPanel.add(removeButton);
		
		
		
		
		JButton ShowButton = new JButton("Show Member");
		class ShowListener implements ActionListener
		{  
		   public void actionPerformed(ActionEvent event)
		   {  
			refresh();
		   }
		}
		
		ActionListener shower = new ShowListener();
		ShowButton.addActionListener(shower);
		middleBottomPanel.add(ShowButton);
		JButton SaveButton = new JButton("Save Members");
		class saveListener implements ActionListener
		{  
		   public void actionPerformed(ActionEvent event)
		   {  
			
			   PrintWriter monthOutput = createFile("members.txt");
				 
				 createMembersData(members, monthOutput);
				 monthOutput.close();

				 setVisible(true);
		   }
		}
		ActionListener saver = new saveListener();
		SaveButton.addActionListener(saver);
		middleBottomPanel.add(SaveButton);
		
		
		
		JButton MoveButton = new JButton("Move");
		class moveListener implements ActionListener
		{  
		   public void actionPerformed(ActionEvent event)
		   {  
			
			   for(Member m: members){
					  if(NameField.getText().equalsIgnoreCase(m.getName())){
						  if (m.getPaid() == false){
							  m.setPaid(true);
							  }
						  else{
						  m.setPaid(false);
						  }
					  }
					}
			   refresh();
		   }
		}
		ActionListener mover = new moveListener();
		MoveButton.addActionListener(mover);
		middleBottomPanel.add(MoveButton);
		
		
		
		mainMidPanel.add(middlePanel);
		mainMidPanel.add(middleBottomPanel);
		
		
		
		
		mainPanel.add(mainMidPanel);
		
		//------------------------------------------------------------------------------------------------------------------------------
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBorder(new TitledBorder(new EtchedBorder(), "unPaid Members"));
		unPaidArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		rightPanel.add(unPaidArea);
		mainPanel.add(rightPanel);
		
		
		add(mainPanel);
		setVisible(true);
	}

	
public static void readMembersFile(MemberList members) throws Exception{
		
	Scanner input;
	 try {
		input = new Scanner (new File ("members.txt"));
		int size = input.nextInt();
		input.nextLine();
		for(int i= 0; i < size; i++){
			String name =  input.nextLine();
			//System.out.println(name);
			String tel = input.nextLine();
			//System.out.println(tel);
			String address = input.nextLine();
			//System.out.println(address);
			Boolean attended = input.nextBoolean();
			Boolean paid = input.nextBoolean();
			Double balance = input.nextDouble();
			input.nextLine();
			members.add(new Member(name, tel, address, attended, paid, balance));			}
		input.close();
		
	} catch (FileNotFoundException e) {
		
	}
		
	}
	
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

	private static void createMembersData(MemberList members, PrintWriter custOutput){
		custOutput.println(members.size());
		for(Member m: members){
			custOutput.println(m.getName());
			custOutput.println(m.getPhone());
			custOutput.println(m.getAddress());
			custOutput.println(m.getAttended());
			custOutput.println(m.getPaid());
			custOutput.println(m.getBalance());
		}
		
		
	}

	
	}

