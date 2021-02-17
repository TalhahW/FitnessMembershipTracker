package MEM;


import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class AccountPayable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountPayable frame = new AccountPayable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountPayable() {
		setTitle("Accounts Payable");
		
		
		initComponents();
		setAlwaysOnTop(true);
	
	}	

	private static MemberList members;
	private static ArrayList<Member> paid;
	
public static void readMembersFile() throws Exception{
		
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
	
	

	public void initComponents()
	{
		members = new MemberList();
		
		try {
			readMembersFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("Submit");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -104, SpringLayout.EAST, contentPane);
		ActionListener listener = new ClickListener();
		btnNewButton.addActionListener(listener);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -191, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, textField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 23, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -24, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -256, SpringLayout.EAST, contentPane);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Paid Members");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, textArea);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -337, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel);
		
		Label label = new Label("Monthly Revenue");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 3, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, textArea);
		contentPane.add(label);
		
		JButton btnClear = new JButton("Clear");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnClear, 3, SpringLayout.EAST, btnNewButton);
		btnClear.addActionListener(new ActionListener(){
			  @Override
			    public void actionPerformed(ActionEvent e)
			    {
					textArea.setText("");
					textField.setText("");
			    }
		});
		contentPane.add(btnClear);
		
	
	}
	
	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			
			
			members = new MemberList();
			try {
				readMembersFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			paid = new ArrayList<Member>();
			for (int i = 0; i < members.size(); i++){
				if (members.get(i).getPaid() == true){
					paid.add(members.get(i));
				}
			}
			
			System.out.println("paid");
			for(Member m: paid){
				System.out.println(m.getName());
			}
			
			textArea.setText("");
			double count = 0.0;
			for(Member m : paid)
			{
				count += m.getBalance();
				textArea.append(m.getName() +  "\n");
			}
			
			double amount = count;
			String revenue = String.valueOf(amount);
			textField.setText("$" + revenue);
			
		}
	
	
	}
}
