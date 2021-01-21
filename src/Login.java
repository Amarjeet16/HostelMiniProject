import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 460);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(241, 181, 70, 14);
		contentPane.add(lblUsername);
		
		textUserName = new JTextField();
		textUserName.setBounds(308, 178, 123, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(241, 234, 59, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbhostel","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					
					String sql="Select * from login where username='"+textUserName.getText()+"'and password='"+textPassword.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Sucessfully...");
						Login.this.dispose();
						frmMenu obj = new frmMenu();
						obj.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect User Id and Password..!");
					}
					con.close();		
				}
				catch( Exception e2)
				{
				
					System.out.println(e2);
				}

			}
		});
		btnLogin.setBounds(265, 302, 138, 23);
		contentPane.add(btnLogin);
		
		JLabel lblDigitalHostel = new JLabel("Digital Hostel");
		lblDigitalHostel.setForeground(Color.RED);
		lblDigitalHostel.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblDigitalHostel.setBounds(152, 11, 435, 75);
		contentPane.add(lblDigitalHostel);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setForeground(SystemColor.textHighlight);
		lblAdminLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblAdminLogin.setBounds(152, 97, 171, 43);
		contentPane.add(lblAdminLogin);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(308, 231, 123, 20);
		contentPane.add(textPassword);
	}
}
