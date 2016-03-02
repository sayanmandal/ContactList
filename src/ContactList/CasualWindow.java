package ContactList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class CasualWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<CasualFriend> thelist;
	AcquaintanceDAO acquaintance = new AcquaintanceDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CasualWindow frame = new CasualWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public CasualWindow() throws IOException, ClassNotFoundException {
		setTitle("See Your Casual Friends!!!");
		this.setMinimumSize(new Dimension(1000,300));
		BufferedImage image = ImageIO.read(getClass().getResource("/casual.jpg"));
		this.setIconImage(image);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1200, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Casual Friend List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		thelist = acquaintance.show_all_casual_friends();
		CasualFriendTableModel model = new CasualFriendTableModel(thelist);
		JTable table = new JTable();
		table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table.setFillsViewportHeight(true);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddCasualFriend dialog = new AddCasualFriend();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int row = table.getSelectedRow();
					if(row<0){
						JOptionPane.showMessageDialog(null, "You Have To select a row", "Error", JOptionPane.ERROR_MESSAGE);
					}
					acquaintance.delete_casual_friend(row);
					JOptionPane.showMessageDialog(null, "The Entry has been deleted,please click show all to see");
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "You Have To select a row", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnClose);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(30);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText().trim();
				if(name.length()!=0){
					try {
						thelist = acquaintance.search_casual_friend(name);
					} catch (ClassNotFoundException | IOException e1) {
						JOptionPane.showMessageDialog(null, "Something is wrong!!!");
					}
					table.setModel(new CasualFriendTableModel(thelist));
				}else{
					try {
						thelist = acquaintance.show_all_casual_friends();
					} catch (ClassNotFoundException | IOException e1) {
						JOptionPane.showMessageDialog(null, "Something is wrong!!!");
					}
					table.setModel(new CasualFriendTableModel(thelist));
				}
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnSearch);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					thelist = acquaintance.show_all_casual_friends();
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Something is wrong!!!");
				}
				table.setModel(new CasualFriendTableModel(thelist));
			}
		});
		btnShowAll.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnShowAll);
	}

}
