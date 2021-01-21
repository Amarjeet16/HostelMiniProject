import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmStudentRecord extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStudentRecord frame = new frmStudentRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public  void Table() {
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbhostel","root","Root@311vb.net");
				String query="select * from studentdetails";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e) {
					System.out.print(e);
				}
		}
	
	/**
	 * Create the frame.
	 */
	public frmStudentRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 853, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDigitalHostel = new JLabel("Digital Hostel");
		lblDigitalHostel.setForeground(Color.RED);
		lblDigitalHostel.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblDigitalHostel.setBounds(238, 11, 435, 75);
		contentPane.add(lblDigitalHostel);
		
		JLabel lblStudentRecords = new JLabel("Student Records");
		lblStudentRecords.setForeground(SystemColor.textHighlight);
		lblStudentRecords.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 20));
		lblStudentRecords.setBounds(10, 65, 218, 36);
		contentPane.add(lblStudentRecords);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStudentRecord.this.dispose();
				frmMenu d=new frmMenu();
				d.setVisible(true);
			}
		});
		btnHome.setBounds(774, 65, 89, 36);
		contentPane.add(btnHome);
		Table();
	}

}
