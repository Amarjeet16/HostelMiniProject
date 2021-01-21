import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class frmInOut extends JFrame {

	private JPanel contentPane;
	private JTextField textUSN;
	private JTextField textStudentName;
	private JTextField textRoomNo;
	private JTextField textReason;
	private JTextField textTimeOut;
	private JTextField textTimeIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInOut frame = new frmInOut();
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
	public frmInOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "In/Out ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 387, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setBounds(20, 40, 46, 14);
		panel.add(lblUsn);
		
		textUSN = new JTextField();
		textUSN.setBounds(99, 37, 134, 20);
		panel.add(textUSN);
		textUSN.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(5, 71, 84, 14);
		panel.add(lblStudentName);
		
		textStudentName = new JTextField();
		textStudentName.setBounds(99, 68, 134, 20);
		panel.add(textStudentName);
		textStudentName.setColumns(10);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setBounds(20, 107, 63, 14);
		panel.add(lblRoomNo);
		
		textRoomNo = new JTextField();
		textRoomNo.setBounds(99, 99, 134, 20);
		panel.add(textRoomNo);
		textRoomNo.setColumns(10);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setBounds(20, 132, 46, 14);
		panel.add(lblReason);
		
		textReason = new JTextField();
		textReason.setBounds(99, 130, 134, 29);
		panel.add(textReason);
		textReason.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(20, 244, 89, 23);
		panel.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUSN.setText(" ");
				textStudentName.setText(" ");
				textRoomNo.setText(" ");
				textReason.setText(" ");
				textTimeOut.setText(" ");
				textTimeIn.setText(" ");
				
			}
		});
		btnReset.setBounds(144, 244, 89, 23);
		panel.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(89, 288, 89, 23);
		panel.add(btnClose);
		
		JLabel lblTimeOut = new JLabel("Time Out");
		lblTimeOut.setBounds(20, 168, 63, 14);
		panel.add(lblTimeOut);
		
		textTimeOut = new JTextField();
		textTimeOut.setBounds(99, 165, 134, 20);
		panel.add(textTimeOut);
		textTimeOut.setColumns(10);
		
		JLabel lblTimeIn = new JLabel("Time In");
		lblTimeIn.setBounds(20, 203, 63, 14);
		panel.add(lblTimeIn);
		
		textTimeIn = new JTextField();
		textTimeIn.setBounds(99, 196, 134, 20);
		panel.add(textTimeIn);
		textTimeIn.setColumns(10);
	}

}
