import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAbout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAbout frame = new frmAbout();
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
	public frmAbout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 491);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigitalHostel_1 = new JLabel("Digital Hostel");
		lblDigitalHostel_1.setForeground(Color.RED);
		lblDigitalHostel_1.setFont(new Font("Elephant", Font.PLAIN, 36));
		lblDigitalHostel_1.setBounds(145, 11, 435, 75);
		contentPane.add(lblDigitalHostel_1);
		
		JLabel lblVfbgb = new JLabel("Project Title:");
		lblVfbgb.setForeground(new Color(255, 0, 0));
		lblVfbgb.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblVfbgb.setBounds(72, 149, 162, 14);
		contentPane.add(lblVfbgb);
		
		JLabel lblDeveloper = new JLabel("Developer:");
		lblDeveloper.setForeground(new Color(255, 0, 0));
		lblDeveloper.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblDeveloper.setBounds(72, 196, 162, 14);
		contentPane.add(lblDeveloper);
		
		JLabel lblVersion = new JLabel("Version:");
		lblVersion.setForeground(new Color(255, 0, 0));
		lblVersion.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblVersion.setBounds(72, 244, 162, 14);
		contentPane.add(lblVersion);
		
		JLabel lblProjectGuide = new JLabel("Project Guide:");
		lblProjectGuide.setForeground(new Color(255, 0, 0));
		lblProjectGuide.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblProjectGuide.setBounds(72, 294, 162, 14);
		contentPane.add(lblProjectGuide);
		
		JLabel lblSPSreeja = new JLabel("S P Sreeja");
		lblSPSreeja.setForeground(new Color(0, 0, 139));
		lblSPSreeja.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblSPSreeja.setBounds(290, 294, 162, 14);
		contentPane.add(lblSPSreeja);
		
		JLabel lblVersion_1 = new JLabel("1.0.1");
		lblVersion_1.setForeground(new Color(0, 0, 139));
		lblVersion_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblVersion_1.setBounds(290, 244, 162, 14);
		contentPane.add(lblVersion_1);
		
		JLabel lblShivamShingh = new JLabel("Shivam Kumar");
		lblShivamShingh.setForeground(new Color(0, 0, 139));
		lblShivamShingh.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblShivamShingh.setBounds(290, 196, 162, 14);
		contentPane.add(lblShivamShingh);
		
		JLabel lblDigitalHostel = new JLabel("Digital Hostel");
		lblDigitalHostel.setForeground(new Color(0, 0, 139));
		lblDigitalHostel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblDigitalHostel.setBounds(290, 149, 162, 21);
		contentPane.add(lblDigitalHostel);
		
		JButton btnBack = new JButton("HOME");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAbout.this.dispose();
				frmMenu d=new frmMenu();
				d.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBackground(new Color(30, 144, 255));
		btnBack.setBounds(570, 403, 89, 38);
		contentPane.add(btnBack);
	}

}
