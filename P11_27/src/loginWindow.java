import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;


public class loginWindow {

	private JFrame loginFrame;
	private JFrame welcomeFrame;
	private JTextField idField;
	private JTextField passField;
	private ArrayList<String> usernames;
	private ArrayList<String> passwords;
	private JLabel idLabel;
	private JLabel passLabel;
	private JLabel lblNotification;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginWindow window = new loginWindow();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//load the user and passwords
		usernames = new ArrayList<>();
		passwords = new ArrayList<>();
		fillUserArray();
		
		welcomeFrame = new JFrame();
		welcomeFrame.setBounds(100, 100, 450, 300);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setLocationRelativeTo(null);

		loginFrame = new JFrame();
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setLocationRelativeTo(null);
		
		JButton btnLogn = new JButton("Login");
		btnLogn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idInput = idField.getText();
				String passString = passField.getText();
				
				if(validateID(idInput, passString)) {
					loginFrame.setVisible(false);
					welcomeFrame.setVisible(true);
				}
				else
					lblNotification.setText("Invalid.");
			}
		});
		btnLogn.setBounds(125, 166, 200, 50);
		loginFrame.getContentPane().add(btnLogn);
		
		idField = new JTextField();
		idField.setBounds(170, 82, 114, 19);
		loginFrame.getContentPane().add(idField);
		idField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(170, 113, 114, 19);
		loginFrame.getContentPane().add(passField);
		passField.setColumns(10);
		
		idLabel = new JLabel("ID : ");
		idLabel.setBounds(38, 82, 114, 19);
		loginFrame.getContentPane().add(idLabel);
		
		passLabel = new JLabel("PASS : ");
		passLabel.setBounds(38, 113, 114, 19);
		loginFrame.getContentPane().add(passLabel);
		
		lblNotification = new JLabel("");
		lblNotification.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNotification.setBounds(170, 26, 155, 50);
		loginFrame.getContentPane().add(lblNotification);
		
		lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 10, 400, 228);
		welcomeFrame.getContentPane().add(lblNewLabel);

	}
	
	private void fillUserArray() {
		File inputFile = new File("src/users.txt");
		Scanner in;
		try {
			in = new Scanner(inputFile);
			while (in.hasNext())
			{
				usernames.add(in.next());
				passwords.add(in.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean validateID(String id, String pass) {
		//search if in arraylist
		int token = 0; // keep track where to get pass
		for (String string : usernames) {
			if(string.equals(id))
				return passwords.get(token).equals(pass);
			token++;
		}
		
		return false;
	}
}
