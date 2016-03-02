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


public class AddRelative extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser1;
	private AcquaintanceDAO acquaintance = new AcquaintanceDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddRelative dialog = new AddRelative();
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
	public AddRelative() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		BufferedImage image = ImageIO.read(getClass().getResource("/addRelative.png"));
		this.setIconImage(image);
		setTitle("Add Relative");
		setBounds(100, 100, 451, 241);
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
				RowSpec.decode("default:grow"),
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
			JLabel lblDateOfBirth = new JLabel("Date Of Birth");
			contentPanel.add(lblDateOfBirth, "2, 8, right, default");
		}
		{
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd/MM/yyyy");
			contentPanel.add(dateChooser, "4, 8, fill, fill");
		}
		{
			JLabel lblDateOfLast = new JLabel("Date Of Last Meeting");
			contentPanel.add(lblDateOfLast, "2, 10, right, default");
		}
		{
			dateChooser1 = new JDateChooser();
			dateChooser1.setDateFormatString("dd/MM/yyyy");
			contentPanel.add(dateChooser1, "4, 10, fill, fill");
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
						String Mobnumber = textField_1.getText();
						if(!Pattern.matches("[0-9]{10}",Mobnumber)){
							throw new Exception();
						}
						String Email = textField_2.getText();
						String dateofbirth = formatter.format(dateChooser.getDate());
						String dateoflastmeeting = formatter.format(dateChooser1.getDate());
						Acquaintance therelative = new Relative(name,Mobnumber,Email,dateofbirth,dateoflastmeeting);
						try {
							acquaintance.create_new_relative((Relative) therelative);
						} catch (ClassNotFoundException | IOException e1) {
							JOptionPane.showMessageDialog(null, "Please Check the Input", "Error", JOptionPane.ERROR_MESSAGE);
						}
						setVisible(false);
						dispose();
						JOptionPane.showMessageDialog(null, "The Entry Added to the list,please click show all to see");
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Please Check the Input", "Error", JOptionPane.ERROR_MESSAGE);
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
