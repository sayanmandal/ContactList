package ContactList;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelativeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<Relative> thelist;
	private AcquaintanceDAO acquaintance;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelativeWindow frame = new RelativeWindow();
					frame.setTitle("See your Relatives Here!!!");
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
	public RelativeWindow() throws IOException, ClassNotFoundException {
		this.setMinimumSize(new Dimension(800,300));
		acquaintance = new AcquaintanceDAO();
		BufferedImage image = ImageIO.read(getClass().getResource("/relative.png"));
		this.setIconImage(image);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "RelativeList", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		thelist = acquaintance.show_all_relatives();
		RelativeTableModel model = new RelativeTableModel(thelist);
		JTable table = new JTable();
		table.setModel(model);
		table.getTableHeader().setFont(new Font("verdana",Font.BOLD,15));
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table.setFillsViewportHeight(true);
		
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddRelative dialog = new AddRelative();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
				int row = table.getSelectedRow();
				if(row<0){
					JOptionPane.showMessageDialog(null,"You Have to choose a row","Error",JOptionPane.ERROR_MESSAGE);
				}
				try {
					acquaintance.delete_relative(row);
				} catch (ClassNotFoundException | IOException e) {
					JOptionPane.showMessageDialog(null, "Something is wrong!!!");
				}
				JOptionPane.showMessageDialog(null, "Relative has been deleted!!!,please click show all to see");
			}catch(Exception e11){
				JOptionPane.showMessageDialog(null,"You Have to choose a row","Error",JOptionPane.ERROR_MESSAGE);
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
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(30);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText().trim();
				if(name.length()!=0){
					try {
						thelist = acquaintance.search_relative(name);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table.setModel(new RelativeTableModel(thelist));
				}else{
					try {
						thelist = acquaintance.show_all_relatives();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table.setModel(new RelativeTableModel(thelist));
				}
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnSearch);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					thelist = acquaintance.show_all_relatives();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(new RelativeTableModel(thelist));
			}
		});
		btnShowAll.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnShowAll);
	}

}
