package ContactList;

import java.awt.BorderLayout;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ProfessionalWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<ProfessionalFriend> thelist;
	private AcquaintanceDAO acquaintance = new AcquaintanceDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessionalWindow frame = new ProfessionalWindow();
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
	public ProfessionalWindow() throws IOException, ClassNotFoundException {
		setTitle("You Can See Your Professional Friends");
		BufferedImage image = ImageIO.read(getClass().getResource("/professional.jpg"));
		this.setIconImage(image);
		this.setMinimumSize(new Dimension(800,300));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Professional Friend List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		thelist = acquaintance.show_all_professional_friends();
		ProfessionalTableModel model = new ProfessionalTableModel(thelist);
		JTable table = new JTable();
		table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table.setFillsViewportHeight(true);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddProfessional dialog = new AddProfessional();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd_1.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnAdd_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int row = table.getSelectedRow();
				if(row<0){
					JOptionPane.showMessageDialog(null, "You Have To Select A Row!!");
				}
				try {
					acquaintance.delete_professional_friend(row);
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Something is wrong!!");
				}
				JOptionPane.showMessageDialog(null, "Data has been deleted,please click show all to see");
				
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "You Have To Select A Row!!");
			}}
		});
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnDelete);
		
		JButton btnAdd = new JButton("Close");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.BOLD, 16));
		panel.add(btnAdd);
		
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
						thelist = acquaintance.search_professional_friend(name);
					} catch (ClassNotFoundException | IOException e1) {
						JOptionPane.showMessageDialog(null, "Something is wrong!!!");
					}
					table.setModel(new ProfessionalTableModel(thelist));
				}else{
					try {
						thelist = acquaintance.show_all_professional_friends();
					} catch (ClassNotFoundException | IOException e1) {
						JOptionPane.showMessageDialog(null, "Something is wrong!!!");
					}
					table.setModel(new ProfessionalTableModel(thelist));
				}
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnSearch);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					thelist = acquaintance.show_all_professional_friends();
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Something is wrong!!!");
				}
				table.setModel(new ProfessionalTableModel(thelist));
			}
		});
		btnShowAll.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_1.add(btnShowAll);
	}

}
