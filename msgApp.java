package MEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class msgApp {

	private JFrame frame;
	private JTextField toEmail;
	private JTextField subject;
	private JLabel lblEmail_1;
	private JButton btnCancel;
	private JTextField message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					msgApp window = new msgApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public msgApp() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Message");
		frame.setBounds(100, 100, 595, 400);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Client Email");
		lblEmail.setBounds(29, 44, 81, 14);
		frame.getContentPane().add(lblEmail);
		
		toEmail = new JTextField();
		toEmail.setBounds(101, 41, 416, 20);
		frame.getContentPane().add(toEmail);
		toEmail.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message ");
		lblMessage.setBounds(29, 159, 80, 14);
		frame.getContentPane().add(lblMessage);
		
		message = new JTextField();
		message.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		message.setBounds(101, 159, 416, 130);
		frame.getContentPane().add(message);
		message.setColumns(10);
		
		lblEmail_1 = new JLabel("(Seperate by commas)");
		lblEmail_1.setBounds(10, 65, 150, 32);
		frame.getContentPane().add(lblEmail_1);
		
		JButton btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				sendEmail SE = new sendEmail(toEmail.getText(),subject.getText(),message.getText());
				//System.out.println(toEmail.getText());
				
				message.setText("Message Sent");
			}
		});
		btnSend.setBounds(402, 300, 115, 32);
		frame.getContentPane().add(btnSend);
		
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(29, 112, 46, 14);
		frame.getContentPane().add(lblSubject);
		
		subject = new JTextField();
		subject.setBounds(101, 109, 416, 20);
		frame.getContentPane().add(subject);
		subject.setColumns(10);
	}
}
