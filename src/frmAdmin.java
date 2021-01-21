import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

//import Dashborad.Dashboard;
//import frmProductMaster.frmProductMaster;
import net.proteanit.sql.DbUtils;

//import com.sun.corba.se.pept.transport.Connection;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class frmAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdminId;
	private JTextField txtAdminName;
	private JTextField textMobileNo;
	private JTextField textEmail;
	private JTextField textHostelName;
	private JTable table;
	private String gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAdmin frame = new frmAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 void adminId()
	    {
	        try
	        {
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbhostel","root","Root@311vb.net");
				String mysql="SELECT AdminId FROM admindetails ORDER BY AdminId DESC LIMIT 1"; 
	        	PreparedStatement st=con.prepareStatement(mysql);
	        	ResultSet rs=st.executeQuery();
			      if(rs.next())
			      {
			          String rnno=rs.getString("AdminId");
			          int co=rnno.length();
			          String txt= rnno.substring(0, 2);
			          String num=rnno.substring(2, co);
			          int n=Integer.parseInt(num);
			          n++;
			          String snum=Integer.toString(n);
			          String ftxt=txt+snum;
			          txtAdminId.setText(ftxt);
			
			      }
			      else
			      {
			    	  txtAdminId.setText("AI1000");
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
					String query="select * from admindetails";
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
	public frmAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 766, 393);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Warden Deatils", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Warden Id");
		lblNewLabel.setBounds(10, 32, 79, 14);
		panel.add(lblNewLabel);
		
		txtAdminId = new JTextField();
		txtAdminId.setEditable(false);
		txtAdminId.setBounds(105, 29, 141, 20);
		panel.add(txtAdminId);
		txtAdminId.setColumns(10);
		
		JLabel lblAdminName = new JLabel("Warden Name");
		lblAdminName.setBounds(10, 94, 79, 14);
		panel.add(lblAdminName);
		
		txtAdminName = new JTextField();
		txtAdminName.setBounds(105, 91, 141, 20);
		panel.add(txtAdminName);
		txtAdminName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 152, 46, 14);
		panel.add(lblGender);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(10, 217, 62, 14);
		panel.add(lblMobileNo);
		
		textMobileNo = new JTextField();
		textMobileNo.setColumns(10);
		textMobileNo.setBounds(105, 214, 141, 20);
		panel.add(textMobileNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 272, 46, 14);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(105, 269, 141, 20);
		panel.add(textEmail);
		
		JLabel lblHostelName = new JLabel("Hostel Name");
		lblHostelName.setBounds(10, 322, 79, 14);
		panel.add(lblHostelName);
		
		textHostelName = new JTextField();
		textHostelName.setColumns(10);
		textHostelName.setBounds(105, 319, 141, 20);
		panel.add(textHostelName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 368, 46, 14);
		panel.add(lblAddress);
		
		JEditorPane textAddress = new JEditorPane();
		textAddress.setBounds(103, 362, 358, 20);
		panel.add(textAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
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
					String mySql="insert into admindetails(AdminId,AdminName,Gender,EmailId,MobileNo,HostelName,Address)values(?,?,?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(mySql);
					st.setString(1,txtAdminId.getText());
					st.setString(2,txtAdminName.getText());      
					st.setString(3,gender);
					st.setString(4,textEmail.getText());
					st.setString(5,textMobileNo.getText());
					st.setString(6,textHostelName.getText());
					st.setString(7,textAddress.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Save Sucessfully");
					st.close();
					con.close();
					adminId();
					Table();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		
		btnSave.setBounds(652, 214, 89, 34);
		panel.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//txtAdminId.setText(" ");
				txtAdminName.setText(" ");
				//rdbMale.setSelectedItem(null);
				textMobileNo.setText(" ");
				textEmail.setText(" ");
				textHostelName.setText(" ");
				textAddress.setText(" ");
				
				
			}
		});
		btnReset.setBounds(652, 258, 89, 34);
		panel.add(btnReset);
		
		JButton btnClose = new JButton("Back");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdmin.this.dispose();
				frmMenu d=new frmMenu();
				d.setVisible(true);
				
			}
		});
		btnClose.setBounds(652, 302, 89, 34);
		panel.add(btnClose);
		
		JRadioButton rdbMale = new JRadioButton("Male");
		rdbMale.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gender="Male";
			}
		});
		rdbMale.setBounds(105, 148, 79, 23);
		panel.add(rdbMale);
		
		JRadioButton rdbFemale = new JRadioButton("Female");
		rdbFemale.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 gender="Female";
			}
		});
		rdbFemale.setBounds(202, 148, 89, 23);
		panel.add(rdbFemale);
		
		JLabel lblDigitalHostel = new JLabel("Digital Hostel");
		lblDigitalHostel.setForeground(Color.RED);
		lblDigitalHostel.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblDigitalHostel.setBounds(321, 29, 435, 75);
		panel.add(lblDigitalHostel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 404, 766, 64);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		adminId();
		Table();
	}
}
