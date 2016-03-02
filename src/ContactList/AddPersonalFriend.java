package ContactList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;


public class AddPersonalFriend extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JDateChooser dateChooser;
	AcquaintanceDAO acquaintance = new AcquaintanceDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPersonalFriend dialog = new AddPersonalFriend();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public AddPersonalFriend() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		setTitle("Add Personal Friends!!!!");
		BufferedImage image = ImageIO.read(getClass().getResource("/personal.jpg"));
		this.setIconImage(image);
		setBounds(100, 100, 460, 245);
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
				RowSpec.decode("default:grow"),}));
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
			JLabel lblContextmaxChars = new JLabel("Context(Max. 100 chars)");
			contentPanel.add(lblContextmaxChars, "2, 8, right, default");
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3, "4, 8, fill, default");
			textField_3.setColumns(10);
		}
		{
			JLabel lblDateOfMeeting = new JLabel("Special Events(Max. 100 chars)");
			contentPanel.add(lblDateOfMeeting, "2, 10, right, default");
		}
		{
			textField_4 = new JTextField();
			contentPanel.add(textField_4, "4, 10, fill, default");
			textField_4.setColumns(10);
		}
		{
			JLabel lblDateOfMeeting_1 = new JLabel("Date Of Meeting");
			contentPanel.add(lblDateOfMeeting_1, "2, 12");
		}
		{
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd/MM/yyyy");
			contentPanel.add(dateChooser, "4, 12, fill, fill");
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
							String context = textField_3.getText();
							String dateofmeeting = formatter.format(dateChooser.getDate());
							String specialEvents = textField_4.getText();
							Acquaintance personalfriend = new PersonalFriend(name,mobnumber,Email,context,dateofmeeting,specialEvents);
							acquaintance.create_new_personal_friend((PersonalFriend) personalfriend);
							setVisible(false);
							dispose();
							JOptionPane.showMessageDialog(null, "Personal Friend Added to list,please click show all to see");
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Please Check the inputs!!", "Error", JOptionPane.ERROR_MESSAGE);
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
