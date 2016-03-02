package ContactList;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonalWindow extends JFrame {

	private JPanel contentPane;
	private AcquaintanceDAO acquaintance = new AcquaintanceDAO();
	private List<PersonalFriend> thelist;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalWindow frame = new PersonalWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public PersonalWindow() throws IOException, ClassNotFoundException {
		setTitle("See All your Personal Friends!!!!");
		BufferedImage image = ImageIO.read(getClass().getResource("/personal.jpg"));
		this.setIconImage(image);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 367);
		this.setMinimumSize(new Dimension(900,300));
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Personal Friend List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		thelist = acquaintance.show_all_personal_friends();
		PersonalFriendTableModel model = new PersonalFriendTableModel(thelist);
		JTable table = new JTable();
		table.setModel(model);
		table.getTableHeader().setFont(new Font("verdana",Font.BOLD,15));
		//table.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
		updateRowHeights(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
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
					AddPersonalFriend dialog = new AddPersonalFriend();
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
					JOptionPane.showMessageDialog(null, "You Have to Select a row!!");
				}
				try {
					acquaintance.delete_personal_friend(row);
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "You Have to Select a row!!");
				}
				JOptionPane.showMessageDialog(null, "The entry has been deleted,please click show all to see");
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "You Have to Select a row!!");
			}}
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
						thelist = acquaintance.search_personal_friend(name);
						table.setModel(new PersonalFriendTableModel(thelist));
						updateRowHeights(table);
					} catch (ClassNotFoundException | IOException e1) {
						JOptionPane.showMessageDialog(null, "Something is Wrong!!!!");
					}
				}else{
					try {
						thelist = acquaintance.show_all_personal_friends();
						table.setModel(new PersonalFriendTableModel(thelist));
						updateRowHeights(table);
					} catch (ClassNotFoundException | IOException e1) {
						JOptionPane.showMessageDialog(null, "Something is Wrong!!!!");
					}
				}
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnSearch);
		
		JButton btnNewButton = new JButton("Show All");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					thelist = acquaintance.show_all_personal_friends();
					table.setModel(new PersonalFriendTableModel(thelist));
					updateRowHeights(table);
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Something is Wrong!!!!");
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnNewButton);
	}

}
