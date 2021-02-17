package MEM;


import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class InterfaceFrame extends JFrame {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	static Stack<Coach> names;
	JTextArea members;
	JTextField name;
	JPanel panel = new JPanel();
	JPanel toppanel = new JPanel();
	Coach m;

	
	
	
	
	
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

public static void readCoachesFile() throws Exception{
	
	Scanner input;
	 try {
		input = new Scanner (new File ("coaches.txt"));
		int size = input.nextInt();
		input.nextLine();
		for(int i= 0; i < size; i++){
			String name =  input.nextLine();
			names.add(new Coach(name));			}
		input.close();
		
	} catch (FileNotFoundException e) {
		
	}
}




	private static void createCoachesData(Stack<Coach> coaches, PrintWriter custOutput){
		custOutput.println(coaches.size());
		for(Coach c: coaches){
			custOutput.println(c.getName());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public InterfaceFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Add/Remove Coaches");
		names = new Stack<Coach>();
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		List();
		main.add(members, BorderLayout.CENTER);
		manage();
		main.add(panel, BorderLayout.AFTER_LAST_LINE);
		add(main);

	}

	public void List() {
		toppanel.setLayout(new BorderLayout());
		toppanel.setBorder(new TitledBorder(new EtchedBorder(), "List"));

	members = new JTextArea();
		toppanel.add(members);
		
		setVisible(true);
	}

	public void manage() {
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), ""));

		JPanel panel1 = new JPanel();
		JButton add = new JButton("Add");
		JButton remove = new JButton("Remove");
		JButton clear = new JButton("Clear");
		JButton save = new JButton("Save");
		JButton load = new JButton("Load");
		panel1.add(add);
		panel1.add(remove);
		panel1.add(clear);
		
		
		class saveListener implements ActionListener {

			public void actionPerformed(ActionEvent event) {
 PrintWriter monthOutput = createFile("coaches.txt");
				 
				 createCoachesData(names, monthOutput);
				 monthOutput.close();

				 setVisible(true);

			}
		}
		
		ActionListener s = new saveListener();
		save.addActionListener(s);
		class loadListener implements ActionListener {
			
			public void actionPerformed(ActionEvent event) {
			members.setText("");
				try {
					readCoachesFile();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 for(Coach c : names)
	{
		
		members.append(c.getName() +  "\n");
	}

				 setVisible(true);

			}
		}
		ActionListener l = new loadListener();
		load.addActionListener(l);
		
		panel1.add(save);
		panel1.add(load);
		
		panel.add(panel1, BorderLayout.SOUTH);
		name = new JTextField(4);
		panel.add(name);

		class Add implements ActionListener {

			public void actionPerformed(ActionEvent event) {
				String text = name.getText();
				create(text, names);
				print(names);

			}
		}

		ActionListener a = new Add();
		add.addActionListener(a);

		class Remove implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				String text = name.getText();
				error(text);
				rem(text);
				print(names);
			}
		}
		
		ActionListener b = new Remove();
		remove.addActionListener(b);

		class Clear implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				name.setText("");
			}
		}
		ActionListener c = new Clear();
		clear.addActionListener(c);
	}

	public void create(String Desc, Stack<Coach> names) {
		String text = Desc;
		int r = find(new Coach(text));
		if (r != -1)
			name.setText("Duplicate name on list, please retry");
		else
		names.add(new Coach(text));
	}

	public void print(Stack<Coach> names) {
		members.setText("");
		for (Coach i : names) {
			members.append(i.print() + "\n");
		}
	}

	public int find(Coach a) {
		int counter = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).occursOn(a)) {
				return counter;
			}
			counter++;
		}
		return -1;
	}

	public void rem(String Desc) {
		String text = Desc;
		int r = find(new Coach(text));
		if (r != -1)
			names.remove(r);}
	
	
	public void error(String Desc) {
		String text = Desc;
		int r = find(new Coach(text));
		if (r == -1)
			name.setText("No such name found on the list");
			
	}
	

}
