import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
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

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Font;

public class frmStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textUSN;
	private JTextField textStudentName;
	private JTextField textRoomNo;
	private JTextField textMobileNo;
	private JTextField textEmail;
	private JTextField textDOB;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStudent frame = new frmStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void USN()
    {
        try
        {
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbhostel","root","Root@311vb.net");
			String mysql="SELECT USN FROM studentdetails ORDER BY USN DESC LIMIT 1"; 
        	PreparedStatement st=con.prepareStatement(mysql);
        	ResultSet rs=st.executeQuery();
		      if(rs.next())
		      {
		          String rnno=rs.getString("USN");
		          int co=rnno.length();
		          String txt= rnno.substring(0, 2);
		          String num=rnno.substring(2, co);
		          int n=Integer.parseInt(num);
		          n++;
		          String snum=Integer.toString(n);
		          String ftxt=txt+snum;
		          textUSN.setText(ftxt);
		
		      }
		      else
		      {
		    	  textUSN.setText("UI1000");
		      }

        } 
        catch (Exception e)
        {
        	JOptionPane.showMessageDialog(rootPane, e);
        }
    }
 
	 //*TAble Admin
	 
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
	public frmStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 783, 390);
		panel.setBorder(new TitledBorder(null, "Add Student Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setBounds(21, 50, 46, 14);
		panel.add(lblUsn);
		
		textUSN = new JTextField();
		textUSN.setBounds(95, 47, 181, 20);
		panel.add(textUSN);
		textUSN.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(21, 81, 73, 14);
		panel.add(lblStudentName);
		
		textStudentName = new JTextField();
		textStudentName.setBounds(95, 78, 181, 20);
		panel.add(textStudentName);
		textStudentName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(21, 112, 46, 14);
		panel.add(lblGender);
		
		JComboBox cbxGender = new JComboBox();
		cbxGender.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE", "TRANGENDER"}));
		cbxGender.setBounds(95, 106, 181, 20);
		panel.add(cbxGender);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(21, 137, 46, 14);
		panel.add(lblBranch);
		
		JComboBox cbxBranch = new JComboBox();
		cbxBranch.setModel(new DefaultComboBoxModel(new String[] {"MCA", "BCA", "MBA", "BBA", "B.TECH"}));
		cbxBranch.setBounds(95, 137, 181, 20);
		panel.add(cbxBranch);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setBounds(21, 176, 46, 14);
		panel.add(lblRoomNo);
		
		textRoomNo = new JTextField();
		textRoomNo.setBounds(95, 168, 181, 20);
		panel.add(textRoomNo);
		textRoomNo.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile No");
		lblMobile.setBounds(21, 201, 46, 14);
		panel.add(lblMobile);
		
		textMobileNo = new JTextField();
		textMobileNo.setBounds(95, 199, 181, 20);
		panel.add(textMobileNo);
		textMobileNo.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 233, 46, 14);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(95, 230, 181, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(21, 290, 46, 14);
		panel.add(lblAddress);
		
		JEditorPane textAddress = new JEditorPane();
		textAddress.setBounds(95, 290, 181, 71);
		panel.add(textAddress);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					String mySql="insert into studentdetails(USN,StudentName,Gender,Branch,RoomNo,Mobile,Email,DOB,Address)values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(mySql);
					st.setString(1,textUSN.getText());
					st.setString(2,textStudentName.getText());
					String value=cbxGender.getSelectedItem().toString();
					st.setString(3,value);
					String value1=cbxBranch.getSelectedItem().toString();
					st.setString(4,value1);
					st.setString(5,textRoomNo.getText());
					st.setString(6,textMobileNo.getText());
					st.setString(7,textEmail.getText());
					st.setString(8,textDOB.getText());
					st.setString(9,textAddress.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Save Sucessfully");
					st.close();
					con.close();
					USN();
					Table();
					//SupplierTable();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			
			}
		});
		btnSubmit.setBounds(574, 176, 105, 46);
		panel.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textUSN.setText(" ");
				textStudentName.setText(" ");
				cbxGender.setSelectedItem(null);
				cbxBranch.setSelectedItem(null);
				textRoomNo.setText(" ");
				textMobileNo.setText(" ");
				textEmail.setText(" ");
				textDOB.setText(" ");
				textAddress.setText(" ");
			}
		});
		btnReset.setBounds(574, 245, 105, 47);
		panel.add(btnReset);
		
		JButton btnClose = new JButton("Back");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmStudent.this.dispose();
				frmMenu d=new frmMenu();
				d.setVisible(true);
			}
		});
		btnClose.setBounds(574, 318, 105, 46);
		panel.add(btnClose);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setBounds(21, 265, 46, 14);
		panel.add(lblDob);
		
		textDOB = new JTextField();
		textDOB.setBounds(95, 261, 181, 20);
		panel.add(textDOB);
		textDOB.setColumns(10);
		
		JLabel lblDigitalHostel = new JLabel("Digital Hostel");
		lblDigitalHostel.setForeground(Color.RED);
		lblDigitalHostel.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblDigitalHostel.setBounds(299, 47, 435, 75);
		panel.add(lblDigitalHostel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 394, 793, 80);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		USN();
		Table();
	}
}
