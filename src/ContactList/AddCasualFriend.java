package ContactList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCasualFriend extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	AcquaintanceDAO acquaintance = new AcquaintanceDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {/*
		try {
			AddCasualFriend dialog = new AddCasualFriend();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public AddCasualFriend() throws IOException {
		setTitle("Add Casual Friends!!!");
		BufferedImage image = ImageIO.read(getClass().getResource("/casual.jpg"));
		this.setIconImage(image);
		setBounds(100, 100, 449, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblName = new JLabel("Name");
			contentPanel.add(lblName, "2, 2, right, default");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "4, 2, fill, default");
			textField.setColumns(10);
		}
		{
			JLabel lblMobileNo = new JLabel("Mobile No.");
			contentPanel.add(lblMobileNo, "2, 4, right, default");
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1, "4, 4, fill, default");
			textField_1.setColumns(10);
		}
		{
			JLabel lblEmailAddress = new JLabel("Email Address");
			contentPanel.add(lblEmailAddress, "2, 6, right, default");
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2, "4, 6, fill, default");
			textField_2.setColumns(10);
		}
		{
			JLabel lblTimeOfMeeting = new JLabel("Time of Meeting");
			contentPanel.add(lblTimeOfMeeting, "2, 8, right, default");
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3, "4, 8, fill, default");
			textField_3.setColumns(10);
		}
		{
			JLabel lblPlaceOfMeeting = new JLabel("Place of meeting");
			contentPanel.add(lblPlaceOfMeeting, "2, 10, right, default");
		}
		{
			textField_4 = new JTextField();
			contentPanel.add(textField_4, "4, 10, fill, default");
			textField_4.setColumns(10);
		}
		{
			JLabel lblCircumstances = new JLabel("Circumstances");
			contentPanel.add(lblCircumstances, "2, 12, right, default");
		}
		{
			textField_5 = new JTextField();
			contentPanel.add(textField_5, "4, 12, fill, default");
			textField_5.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							String name = textField.getText();
							String mobnumber = textField_1.getText();
							if(!Pattern.matches("[0-9]{10}",mobnumber)){
								throw new Exception();
							}
							String Email = textField_2.getText();
							String timeofmeeting = textField_3.getText();
							String place = textField_4.getText();
							String circumstances = textField_5.getText();
							
							Acquaintance casualfriend = new CasualFriend(name,mobnumber,Email,timeofmeeting,place,circumstances);
							acquaintance.create_new_casual_friend((CasualFriend) casualfriend);
							setVisible(false);
							dispose();
							JOptionPane.showMessageDialog(null, "The Casual Friend Has been ADDED to the list,please click show all to see");
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Please Check Your Inputs!!!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
