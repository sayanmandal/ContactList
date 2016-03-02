package ContactList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpeningWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningWindow frame = new OpeningWindow();
					frame.setVisible(true);
					frame.getContentPane().setBackground(Color.WHITE);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public OpeningWindow() throws IOException {
		BufferedImage image = ImageIO.read(getClass().getResource("/ContactList.png"));
		BufferedImage icon = ImageIO.read(getClass().getResource("/Icon.png"));
		BufferedImage icon1 = ImageIO.read(getClass().getResource("/Main.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setIconImage(icon);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(image));
		contentPane.add(label, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(icon1));
		contentPane.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedImage image = ImageIO.read(getClass().getResource("/Logo.png"));
					ContactListWindow frame = new ContactListWindow();
					frame.setResizable(true);
					frame.setMinimumSize(new Dimension(1200,300));
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setIconImage(image);
					frame.setTitle("See All Of Your Acquaintances!!!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowAll.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnShowAll);
		
		JButton btnPersonalFriend = new JButton("Personal Friend");
		btnPersonalFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PersonalWindow frame = new PersonalWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnPersonalFriend.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnPersonalFriend);
		
		JButton btnProfessionalFriend = new JButton("Professional Friend");
		btnProfessionalFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProfessionalWindow frame = new ProfessionalWindow();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnProfessionalFriend.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(btnProfessionalFriend);
		
		JButton btnCasualFriend = new JButton("Casual Friend");
		btnCasualFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CasualWindow frame = new CasualWindow();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCasualFriend.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnCasualFriend);
		
		JButton btnRelative = new JButton("Relative");
		btnRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RelativeWindow frame = new RelativeWindow();
					frame.setTitle("See your Relatives Here!!!");
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRelative.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnRelative);
		
		JButton btnClose = new JButton("CLose");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Verdana", Font.BOLD, 12));
		contentPane.add(btnClose, BorderLayout.SOUTH);
	}

}
