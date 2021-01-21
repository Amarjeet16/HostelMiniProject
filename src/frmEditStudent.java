import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Font;

public class frmEditStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textUSN;
	private JTextField textStudentName;
	private JTextField textRoomNo;
	private JTextField textMobileNo;
	private JTextField textEmail;
	private JTable table;
	private JTextField textDOB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditStudent frame = new frmEditStudent();
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
	public frmEditStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Edit Student Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 782, 390);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setBounds(21, 50, 46, 14);
		panel.add(lblUsn);
		
		textUSN = new JTextField();
		textUSN.setBounds(105, 47, 171, 20);
		panel.add(textUSN);
		textUSN.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 81, 85, 14);
		panel.add(lblStudentName);
		
		textStudentName = new JTextField();
		textStudentName.setBounds(105, 78, 171, 20);
		panel.add(textStudentName);
		textStudentName.setColumns(10);
		
		JLabel lblMobileNo_1 = new JLabel("Room No");
		lblMobileNo_1.setBounds(10, 122, 57, 14);
		panel.add(lblMobileNo_1);
		
		textRoomNo = new JTextField();
		textRoomNo.setBounds(105, 119, 171, 20);
		panel.add(textRoomNo);
		textRoomNo.setColumns(10);
		
		JLabel lblEmail = new JLabel("Mobile No");
		lblEmail.setBounds(10, 153, 57, 14);
		panel.add(lblEmail);
		
		textMobileNo = new JTextField();
		textMobileNo.setBounds(105, 150, 171, 20);
		panel.add(textMobileNo);
		textMobileNo.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(21, 205, 46, 14);
		panel.add(lblEmail_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(105, 202, 171, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 301, 57, 14);
		panel.add(lblAddress);
		
		JEditorPane textAddress = new JEditorPane();
		textAddress.setBounds(105, 295, 171, 68);
		panel.add(textAddress);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					}
					catch(ClassNotFoundException ce)
					{
						JOptionPane.showMessageDialog(null,"Loding Driver Failed");
					}
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbhostel","root","Root@311vb.net");
					String mySql="Update studentdetails set USN='"+textUSN.getText()+"', StudentName='"+textStudentName.getText()+"',RoomNo='"+textRoomNo.getText()+"',Mobile='"+textMobileNo.getText()+"',Email='"+textEmail.getText()+"',DOB='"+textDOB.getText()+"',Address='"+textAddress.getText()+"' where USN='"+textUSN.getText()+"' ";
					PreparedStatement st=con.prepareStatement(mySql);
					/*st.setString(1,txtAdminId.getText());
					st.setString(2,txtAdminName.getText());
					String value=cbxGender.getSelectedItem().toString();
					st.setString(3,value);
					st.setString(4,textEmail.getText());
					st.setString(5,textMobileNo.getText());
					st.setString(6,textHostelName.getText());
					st.setString(7,textAddress.getText());*/
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Update Sucessfully");
					st.close();
					con.close();
					//adminId();
					//Table();
					//SupplierTable();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		btnUpdate.setBounds(673, 230, 89, 37);
		panel.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUSN.setText(" ");
				textStudentName.setText(" ");
				/*cbxGender.setSelectedItem(null);
				cbxBranch.setSelectedItem(null);*/
				textRoomNo.setText(" ");
				textMobileNo.setText(" ");
				textEmail.setText(" ");
				textAddress.setText(" ");
			}
		});
		btnReset.setBounds(673, 278, 89, 37);
		panel.add(btnReset);
		
		JButton btnClose = new JButton("Back");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEditStudent.this.dispose();
				frmMenu d=new frmMenu();
				d.setVisible(true);
			}
		});
		btnClose.setBounds(673, 326, 89, 37);
		panel.add(btnClose);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			//private AbstractButton table;

			public void actionPerformed(ActionEvent e) {
				try
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					}
					catch(ClassNotFoundException ce)
					{
						JOptionPane.showMessageDialog(null,"Loding Driver Failed");
					}
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbhostel","root","Root@311vb.net");
					String mysql="select USN,StudentName,RoomNo,Mobile,Email,DOB,Address from studentdetails where USN=?";
					PreparedStatement st=con.prepareStatement(mysql);
					st.setString(1, textUSN.getText());
					ResultSet rs=st.executeQuery();
					if(rs.next())
				    { 
				    	String Id=rs.getString("USN");
				    	textUSN.setText(Id);
				    	String name=rs.getString("StudentName");
				    	textStudentName.setText(name);
				    	String rm=rs.getString("RoomNo");
				    	textRoomNo.setText(rm);
				    	String mn=rs.getString("Mobile");
				    	textMobileNo.setText(mn);
				    	String eid=rs.getString("Email");
				    	textEmail.setText(eid);
				    	String hn=rs.getString("DOB");
				    	textDOB.setText(hn);
				    	String add=rs.getString("Address");
				    	textAddress.setText(add);
				    	
				    }

					
					  Table();
					//st.close();
				}
					catch(Exception e1)
					{
						System.out.println(e1);
					}	
			
			}
		});
		btnSearch.setBounds(308, 40, 89, 35);
		panel.add(btnSearch);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(21, 274, 46, 14);
		panel.add(lblDob);
		
		textDOB = new JTextField();
		textDOB.setBounds(105, 264, 171, 20);
		panel.add(textDOB);
		textDOB.setColumns(10);
		
		JLabel lblDigitalHostel = new JLabel("Digital Hostel");
		lblDigitalHostel.setForeground(Color.RED);
		lblDigitalHostel.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblDigitalHostel.setBounds(327, 81, 435, 75);
		panel.add(lblDigitalHostel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 394, 782, 107);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Table();
	}
}