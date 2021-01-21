import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class frmEditAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textAdminId;
	private JTextField textAdminName;
	private JTextField textMobileNo;
	private JTextField textEmail;
	private JTextField textHostelName;
	private JTable table;
	protected AbstractButton txtAdminId;
	JRadioButton rdbMale;
	JRadioButton rdbFemale;
	private String gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditAdmin frame = new frmEditAdmin();
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
	public frmEditAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 774, 393);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Edit Warden Deatils", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		
		JLabel lblWardenId = new JLabel("Warden Id");
		lblWardenId.setBounds(10, 32, 62, 14);
		panel.add(lblWardenId);
		
		textAdminId = new JTextField();
		textAdminId.setColumns(10);
		textAdminId.setBounds(105, 29, 141, 20);
		panel.add(textAdminId);
		
		JLabel lblWardenName = new JLabel("Warden Name");
		lblWardenName.setBounds(10, 94, 79, 14);
		panel.add(lblWardenName);
		
		textAdminName = new JTextField();
		textAdminName.setColumns(10);
		textAdminName.setBounds(105, 91, 141, 20);
		panel.add(textAdminName);
		
		JLabel label_3 = new JLabel("Mobile No");
		label_3.setBounds(10, 140, 62, 14);
		panel.add(label_3);
		
		textMobileNo = new JTextField();
		textMobileNo.setColumns(10);
		textMobileNo.setBounds(105, 137, 141, 20);
		panel.add(textMobileNo);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setBounds(10, 184, 46, 14);
		panel.add(label_4);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(105, 181, 141, 20);
		panel.add(textEmail);
		
		JLabel label_5 = new JLabel("Hostel Name");
		label_5.setBounds(10, 217, 79, 14);
		panel.add(label_5);
		
		textHostelName = new JTextField();
		textHostelName.setColumns(10);
		textHostelName.setBounds(105, 217, 141, 20);
		panel.add(textHostelName);
		
		JLabel label_6 = new JLabel("Address");
		label_6.setBounds(10, 261, 46, 14);
		panel.add(label_6);
		
		JEditorPane textAddress = new JEditorPane();
		textAddress.setBounds(105, 260, 141, 83);
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
					String mySql="Update admindetails set AdminId='"+textAdminId.getText()+"', AdminName='"+textAdminName.getText()+"',EmailId='"+textEmail.getText()+"',MobileNo='"+textMobileNo.getText()+"',HostelName='"+textHostelName.getText()+"',Address='"+textAddress.getText()+"' where AdminId='"+textAdminId.getText()+"' ";
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
		btnUpdate.setBounds(660, 228, 89, 39);
		panel.add(btnUpdate);
		
		JButton button_2 = new JButton("Reset");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAdminId.setText(" ");
				textAdminName.setText(" ");
				//cbxGender.setSelectedItem(null);
				textMobileNo.setText(" ");
				textEmail.setText(" ");
				textHostelName.setText(" ");
				textAddress.setText(" ");
			}
		});
		button_2.setBounds(660, 272, 89, 39);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Back");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEditAdmin.this.dispose();
				frmMenu d=new frmMenu();
				d.setVisible(true);
			}
		});
		button_3.setBounds(660, 316, 89, 39);
		panel.add(button_3);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st=null;
				ResultSet rs=null;
				
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
					        String sql = "SELECT AdminId,AdminName,Gender,EmailId,MobileNo,HostelName,Address FROM admindetails WHERE AdminId =?";
					        st=con.prepareStatement(sql);
					        st.setString(1,textAdminId.getText());
					        rs = st.executeQuery();
					    if(rs.next())
					    { 
					    	String Id=rs.getString("AdminId");
					    	textAdminId.setText(Id);
					    	String name=rs.getString("AdminName");
					    	textAdminName.setText(name);
					    	/* String gn = rs.getString("Gender");
					    	 if (gn.equals("Female")){
					            rdbMale.setSelected(false);
					            rdbFemale.setSelected(true);

					        }
					        else{
					        	rdbFemale.setSelected(true);
					        	rdbMale.setSelected(false);
					        }*/
					    	String eid=rs.getString("EmailId");
					    	textEmail.setText(eid);
					    	String mn=rs.getString("MobileNo");
					    	textMobileNo.setText(mn);
					    	String hn=rs.getString("HostelName");
					    	textHostelName.setText(hn);
					    	String add=rs.getString("Address");
					    	textAddress.setText(add);
					    	
					    }
				} catch (SQLException es )
				{
			    	JOptionPane.showMessageDialog(null, es);
			    }
			}
		});
		
		btnSearch.setBounds(256, 28, 79, 23);
		panel.add(btnSearch);
		
		JLabel lblDigitalHostel = new JLabel("Digital Hostel");
		lblDigitalHostel.setForeground(Color.RED);
		lblDigitalHostel.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblDigitalHostel.setBounds(339, 52, 435, 75);
		panel.add(lblDigitalHostel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 404, 764, 95);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
