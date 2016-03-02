package ContactList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class ContactListWindow extends JFrame {

	private JPanel contentPane;
	private AcquaintanceDAO acquaintance = new AcquaintanceDAO();
	private List<Relative> theRelativeList;
	private List<PersonalFriend> thePersonalFriendList;
	private List<ProfessionalFriend> theProfessionalFriendList;
	private List<CasualFriend> theCasualFriendList;
	private static BufferedImage image;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					image = ImageIO.read(getClass().getResource("/Logo.png"));
					ContactListWindow frame = new ContactListWindow();
					frame.setResizable(true);
					frame.setMinimumSize(new Dimension(1200,300));
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setIconImage(image);
					frame.setTitle("See All Of Your Acquaintances!!!");
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
	private void updateRowHeights(JTable table){

		 for (int row = 0; row < table.getRowCount(); row++)
		    {
		        int rowHeight = table.getRowHeight();

		        for (int column = 0; column < table.getColumnCount(); column++)
		        {
		            Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
		            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
		        }

		        table.setRowHeight(row, rowHeight);
		    }
	}
	
	
	public ContactListWindow() throws ClassNotFoundException, IOException {
		setFont(new Font("Verdana", Font.BOLD, 22));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Verdana", Font.BOLD, 16));
		tabbedPane.setBorder(new TitledBorder(null, "ContactList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		
		theRelativeList = acquaintance.show_all_relatives();
		RelativeTableModel model = new RelativeTableModel(theRelativeList);
		JTable table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setGridColor(Color.RED);
		table.getTableHeader().setFont(new Font("verdana",Font.BOLD,15));
		table.setRowHeight(30);
		table.setFont(new Font("verdana",Font.PLAIN,15));
		updateRowHeights(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		tabbedPane.addTab("Relative", null, scrollPane, null);
		table.setFillsViewportHeight(true);
		
		thePersonalFriendList = acquaintance.show_all_personal_friends();
		PersonalFriendTableModel model1 = new PersonalFriendTableModel(thePersonalFriendList);
		JTable table_1 = new JTable();
		table_1.setModel(model1);
		table_1.setGridColor(Color.BLUE);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_1.getTableHeader().setFont(new Font("verdana",Font.BOLD,15));
		table_1.setRowHeight(30);
		table_1.setFont(new Font("verdana",Font.PLAIN,15));
		updateRowHeights(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		tabbedPane.addTab("Personal Friends", null, scrollPane_1, null);
		table_1.setFillsViewportHeight(true);
		
		theProfessionalFriendList = acquaintance.show_all_professional_friends();
		ProfessionalTableModel model2 = new ProfessionalTableModel(theProfessionalFriendList);
		JTable table_2 = new JTable();
		table_2.setModel(model2);
		table_2.setGridColor(Color.CYAN);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_2.getTableHeader().setFont(new Font("verdana",Font.BOLD,15));
		table_2.setRowHeight(30);
		table_2.setFont(new Font("verdana",Font.PLAIN,15));
		updateRowHeights(table_2);
		
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		tabbedPane.addTab("Professional Friends", null, scrollPane_2, null);
		table_2.setFillsViewportHeight(true);
		
		theCasualFriendList = acquaintance.show_all_casual_friends();
		CasualFriendTableModel model3 = new CasualFriendTableModel(theCasualFriendList);
		JTable table_3 = new JTable();
		table_3.setModel(model3);
		table_3.setGridColor(Color.RED);
		table_3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_3.getTableHeader().setFont(new Font("verdana",Font.BOLD,15));
		table_3.setRowHeight(30);
		table_3.setFont(new Font("verdana",Font.PLAIN,15));
		updateRowHeights(table_2);
		
		JScrollPane scrollPane_3 = new JScrollPane(table_3);
		tabbedPane.addTab("Casual Acquaintances", null, scrollPane_3, null);
		table_3.setFillsViewportHeight(true);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(50);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText().trim();
				if(name.length()!=0){
				try {
					theRelativeList = acquaintance.search_relative(name);
				} catch (ClassNotFoundException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					thePersonalFriendList = acquaintance.search_personal_friend(name);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theProfessionalFriendList = acquaintance.search_professional_friend(name);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					theCasualFriendList = acquaintance.search_casual_friend(name);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(new RelativeTableModel(theRelativeList));
				table_1.setModel(new PersonalFriendTableModel(thePersonalFriendList));
				table_2.setModel(new ProfessionalTableModel(theProfessionalFriendList));
				table_3.setModel(new CasualFriendTableModel(theCasualFriendList));
				}
				
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnSearch);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					theRelativeList = acquaintance.show_all_relatives();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					thePersonalFriendList = acquaintance.show_all_personal_friends();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theProfessionalFriendList = acquaintance.show_all_professional_friends();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					theCasualFriendList = acquaintance.show_all_casual_friends();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(new RelativeTableModel(theRelativeList));
				table_1.setModel(new PersonalFriendTableModel(thePersonalFriendList));
				table_2.setModel(new ProfessionalTableModel(theProfessionalFriendList));
				table_3.setModel(new CasualFriendTableModel(theCasualFriendList));
			}
		});
		btnShowAll.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnShowAll);
		
		
		
}
}
