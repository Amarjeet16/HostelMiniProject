import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Dashborad.Dashboardimport frmProductMaster.frmProductMaster;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class frmMenu extends JFrame {

	private JPanel contentPane;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenu frame = new frmMenu();
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
	public frmMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 11, 669, 322);
		contentPane.add(panel);
		
		JButton btnStudent = new JButton("Add Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.this.dispose();
				frmStudent pm=new frmStudent();
				pm.setVisible(true);
			}
		});
		btnStudent.setBounds(10, 173, 136, 46);
		panel.add(btnStudent);
		
		JButton btnEditStudent = new JButton("Edit Student");
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.this.dispose();
				frmEditStudent pm=new frmEditStudent();
				pm.setVisible(true);
			}
		});
		btnEditStudent.setBounds(10, 257, 136, 46);
		panel.add(btnEditStudent);
		
		JButton btnAdmin = new JButton("Add Warden");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.this.dispose();
				frmAdmin pm=new frmAdmin();
				pm.setVisible(true);
			}
		});
		btnAdmin.setBounds(10, 21, 136, 46);
		panel.add(btnAdmin);
		
		JButton btnEditAdmin = new JButton("Edit Warden");
		btnEditAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.this.dispose();
				frmEditAdmin pm=new frmEditAdmin();
				pm.setVisible(true);
			}
		});
		btnEditAdmin.setBounds(10, 95, 136, 46);
		panel.add(btnEditAdmin);
		
		JLabel lblSmartDigitalHostel = new JLabel("Digital Hostel");
		lblSmartDigitalHostel.setForeground(Color.RED);
		lblSmartDigitalHostel.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblSmartDigitalHostel.setBounds(211, 72, 435, 75);
		panel.add(lblSmartDigitalHostel);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.this.dispose();
				frmAbout pm=new frmAbout();
				pm.setVisible(true);
			}
		});
		btnAbout.setBounds(368, 257, 136, 46);
		panel.add(btnAbout);
		
		JButton btnAllStudentsRecord = new JButton("Students Record");
		btnAllStudentsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.this.dispose();
				frmStudentRecord pm=new frmStudentRecord();
				pm.setVisible(true);
			}
		});
		btnAllStudentsRecord.setBounds(173, 257, 170, 46);
		panel.add(btnAllStudentsRecord);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(558, 257, 89, 46);
		panel.add(btnNewButton);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.this.dispose();
				Login pm=new Login();
				pm.setVisible(true);
			}
		});
		btnLogout.setBackground(new Color(255, 165, 0));
		btnLogout.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		btnLogout.setBounds(570, 11, 89, 23);
		panel.add(btnLogout);
	}
}
