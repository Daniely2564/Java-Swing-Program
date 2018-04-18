package swings;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Testing {
	private Panel actPanel;
	
	private JFrame frame;
	private JLabel lblName;
	private JLabel lName;
	private JLabel lactivation;
	private JTextField nameField;
	private JTextField phoneField;
	private JLabel lActCode;
	private JButton submitBtn;
	private JLabel lDays;
	private JTextField dayField;
	private JLabel lPlan;
	private JTextField planField;
	private JLabel lSimNo;
	private JTextField simNoField;
	private JLabel lDesc;
	private JComboBox descBox;
	private JLabel lblNote;
	private JTextArea noteArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testing window = new Testing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Testing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		actPanel = new Panel(new ImageIcon("C:\\Users\\kim\\Desktop\\Daniel\\Image Sources\\Activation.jpg").getImage());
		actPanel.setBounds(0, 0, 1574, 1);
		lactivation = new JLabel("asd");
		lactivation.setLocation(323, 11);
		lactivation.setSize(317, 184);
		lactivation.setIcon(new ImageIcon("C:\\Users\\kim\\Desktop\\Daniel\\Image Sources\\lactivation.png"));
		submitBtn = new JButton("");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		submitBtn.setLocation(1330, 551);
		submitBtn.setSize(201, 50);
		submitBtn.setBorder(null);
		submitBtn.setContentAreaFilled(false);
		submitBtn.setOpaque(false);
		submitBtn.setIcon(new ImageIcon("C:\\Users\\kim\\Desktop\\Daniel\\Image Sources\\submitBtn.png"));
		submitBtn.setPressedIcon(new ImageIcon("C:\\Users\\kim\\Desktop\\Daniel\\Image Sources\\submitClicked.png"));
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(29, 108, 261, 50);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		actPanel.add(btnNewButton);
		
		frame.setBounds(0, 0, actPanel.getWidth(), actPanel.getHeight());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		
		frame.getContentPane().add(actPanel);
		
		lName = new JLabel("Name");
		lName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lName.setBounds(536, 206, 57, 37);
		actPanel.add(lName);
		actPanel.add(lactivation);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameField.setBounds(605, 208, 192, 34);
		actPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel lPhoneNo = new JLabel("Phone NO");
		lPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lPhoneNo.setBounds(508, 268, 85, 37);
		actPanel.add(lPhoneNo);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneField.setColumns(10);
		phoneField.setBounds(605, 268, 192, 34);
		actPanel.add(phoneField);
		
		lActCode = new JLabel("Act. Code");
		lActCode.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lActCode.setBounds(508, 326, 85, 37);
		actPanel.add(lActCode);
		
		JComboBox actCodeBox = new JComboBox(new String[]{"61438","UNION","EDISON"});
		actCodeBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actCodeBox.setBounds(605, 328, 192, 34);
		actCodeBox.setBackground(Color.WHITE);
		
		actPanel.add(submitBtn);
		actPanel.add(actCodeBox);
		
		lDays = new JLabel("Days");
		lDays.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lDays.setBounds(553, 386, 40, 37);
		actPanel.add(lDays);
		
		dayField = new JTextField();
		dayField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dayField.setColumns(10);
		dayField.setBounds(605, 388, 192, 34);
		actPanel.add(dayField);
		
		lPlan = new JLabel("Plan ($)");
		lPlan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lPlan.setBounds(528, 446, 65, 37);
		actPanel.add(lPlan);
		
		planField = new JTextField();
		planField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		planField.setColumns(10);
		planField.setBounds(605, 448, 192, 34);
		actPanel.add(planField);
		
		lSimNo = new JLabel("SIM NO.");
		lSimNo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lSimNo.setBounds(968, 206, 79, 37);
		actPanel.add(lSimNo);
		
		simNoField = new JTextField();
		simNoField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		simNoField.setColumns(10);
		simNoField.setBounds(1081, 208, 294, 34);
		actPanel.add(simNoField);
		
		lDesc = new JLabel("Desc.");
		lDesc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lDesc.setBounds(990, 268, 57, 37);
		actPanel.add(lDesc);
		
		descBox = new JComboBox(new String[]{"Simple Mobile","Net 10","Lyca Mobile","H2O","Ultra Mobile","Page Plus","T-Mobile","Others"});
		descBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		descBox.setBackground(Color.WHITE);
		descBox.setBounds(1081, 268, 294, 34);
		actPanel.add(descBox);
		
		lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNote.setBounds(990, 326, 57, 37);
		actPanel.add(lblNote);
		
		noteArea = new JTextArea();
		noteArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		noteArea.setBounds(1081,328, 294, 158);
		noteArea.setBorder(BorderFactory.createEtchedBorder());
		actPanel.add(noteArea);
	
	}
}
