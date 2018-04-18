package swings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;


public class Main{

	private JFrame frame;
	private Panel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private LogInBtn btn;
	private MainPanel mainPanel;
	private JButton activationBtn;
	private Panel actPanel;
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
	private JLabel lNote;
	private JTextArea noteArea;
	private JButton searchBtn;
	private JPanel tablePanel;
	private JTable table;
	private TableData tdata;
	private Panel searchPanel;
	private JButton searchMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception
	 */
	public Main() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		//initialize

		//////////////////////////////////// Log in page Start //////////////////////////////

		searchPanel = new Panel(new ImageIcon(".\\src\\Image Sources\\search.jpg").getImage());
		frame = new JFrame();
		panel = new Panel(new ImageIcon(".\\src\\Image Sources\\theme.jpg").getImage());
		btn = new LogInBtn(new ImageIcon(".\\src\\Image Sources\\button.jpg"));
		mainPanel = new MainPanel(new ImageIcon(".\\src\\Image Sources\\template.jpg").getImage());
		activationBtn = new JButton();
		actPanel = new Panel(new ImageIcon(".\\src\\Image Sources\\Activation.jpg").getImage());
		searchBtn = new JButton();
		tdata= new TableData();
		table = new JTable(tdata);
		searchMenu = new JButton("");


		final int WIDTH = panel.getWidth();
		final int HEIGHT = panel.getHeight();


		frame.setBounds(100, 100, panel.getWidth(), panel.getHeight());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(panel);
		frame.setResizable(false);

		btn.setLocation(1185,468);
		btn.setPressedIcon(new ImageIcon(".\\src\\Image Sources\\btnClicked.jpg"));
		frame.add(actPanel);
		actPanel.setVisible(false);
		frame.add(searchPanel);
		searchPanel.setVisible(false);


		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(1192, 442, 97, 23);
		chckbxNewCheckBox.setOpaque(false);
		panel.add(chckbxNewCheckBox);
		panel.add(btn);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(1225, 308, 296, 48);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField.setBounds(1225, 386, 296, 49);
		panel.add(passwordField);


		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(passwordField.getText().equals("1234")&&textField.getText().equals("Danny")){
					//TODO show different panel
					panel.setVisible(false);
					frame.add(mainPanel);
				}else{
					JOptionPane.showMessageDialog(null, "Your Password is incorrect, or your ID doenst Exists");

				}
			}
		});

		///////////////////////////////////// Log In End //////////////////////////////////////////////


		///////////////////////////////////// Main Menu ///////////////////////////////////////////////

		ImageIcon activation = new ImageIcon(".\\src\\Image Sources\\activationBtn.jpg");
		activationBtn.setIcon(activation);
		activationBtn.setBounds(25,145,activation.getImage().getWidth(null),activation.getImage().getHeight(null));
		activationBtn.setBorder(null);

		activationBtn.addActionListener(new ActionListener(){



			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				actPanel.setVisible(true);

			}

		});

		searchMenu.setBounds(28,208,260,54);
		searchMenu.setContentAreaFilled(false);
		searchMenu.setBorder(null);
		searchMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mainPanel.setVisible(false);
				searchPanel.setVisible(true);
				}
			});
		mainPanel.add(searchMenu);
		JLabel lblSearch = new JLabel("Search : ");
		lblSearch.setBounds(420,43,220,30);
		lblSearch.setFont(new Font("Sansserif", Font.BOLD, 22));
		
		JTextField srchField = new JTextField(30);
		srchField.setBounds(550,45,800,30);
		srchField.setFont(new Font("Sansserif", Font.BOLD, 22));
		srchField.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent event){
				String srch = srchField.getText();
				TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(tdata);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(srch));
			}
		});
		
		table.setRowHeight(30);
		table.setFont(new Font("Sansserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Sansserif", Font.BOLD, 15));
		header.setBackground(new Color( 92, 179, 255));
		header.setForeground(Color.white);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(14);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(7).setPreferredWidth(15);
		columnModel.getColumn(8).setPreferredWidth(20);
		columnModel.getColumn(11).setPreferredWidth(140);
		table.setSize(1250,500);
		table.setPreferredScrollableViewportSize(new Dimension(1200,500));
		JPanel tp = new JPanel();
		tp.setOpaque(false);
		mainPanel.add(srchField);
		mainPanel.add(lblSearch);
		table.setFillsViewportHeight(true);
		tp.setBounds(300, 80, 1250, 600);
		tp.add(new JScrollPane(table));
		mainPanel.add(activationBtn);
		mainPanel.add(tp);


		//////////////////////////////////// Activation ////////////////////////////////////////////////////
		lactivation = new JLabel("asd");
		lactivation.setLocation(323, 11);
		lactivation.setSize(317, 184);
		lactivation.setIcon(new ImageIcon(".\\src\\Image Sources\\lactivation.png"));
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
		submitBtn.setIcon(new ImageIcon(".\\src\\Image Sources\\submitBtn.png"));
		submitBtn.setPressedIcon(new ImageIcon(".\\src\\Image Sources\\submitClicked.png"));



		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				actPanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnNewButton.setBounds(29, 108, 261, 50);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		actPanel.add(btnNewButton);

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

		lNote = new JLabel("Note");
		lNote.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lNote.setBounds(990, 326, 57, 37);
		actPanel.add(lNote);

		noteArea = new JTextArea();
		noteArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		noteArea.setBounds(1081,328, 294, 158);
		noteArea.setBorder(BorderFactory.createEtchedBorder());
		actPanel.add(noteArea);

		submitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					new ActivateClass(nameField.getText(), phoneField.getText(),actCodeBox.getSelectedItem().toString(),Integer.parseInt(dayField.getText()),Integer.parseInt(planField.getText()),simNoField.getText(),descBox.getSelectedItem().toString(),noteArea.getText());
					tdata.refresh();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		///////////////////////////////////////////////////////////Search////////////////////////////////////////////

				JButton menBut = new JButton("");
				menBut.setBounds(28,100,260,54);
				menBut.setBorder(null);
				menBut.setContentAreaFilled(false);
				menBut.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						searchPanel.setVisible(false);
						mainPanel.setVisible(true);
					}
				});
				JButton actiBut = new JButton("");
				actiBut.setBounds(28,155,260,54);
				actiBut.setBorder(null);
				actiBut.setContentAreaFilled(false);
				actiBut.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						searchPanel.setVisible(false);
						actPanel.setVisible(true);
					}
				});
					
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(".\\src\\Image Sources\\searchLabel.jpg"));
				label.setBounds(650,0,600,400);

				JComboBox searchBox = new JComboBox(new String[]{"Name","Phone Number","Sim Number"});
				searchBox.setBounds(436,379,170,40);
				searchBox.setBackground(Color.WHITE);
				searchBox.setFont(new Font("Tahoma", Font.PLAIN, 22));

				JTextField searchField = new JTextField(30);
				searchField.setBounds(606,379,640,40);
				searchField.setFont(new Font("Tahoma", Font.PLAIN, 22));

				JButton searchBtn = new JButton("");
				searchBtn.setBounds(1246,378,100,40);
				searchBtn.setIcon(new ImageIcon(".\\src\\Image Sources\\searchBtn.jpg"));
				searchBtn.setPressedIcon(new ImageIcon(".\\src\\Image Sources\\searchBtnClicked.jpg"));

				searchPanel.add(menBut);
				searchPanel.add(actiBut);
				searchPanel.add(label);
				searchPanel.add(searchBox);
				searchPanel.add(searchField);
		searchPanel.add(searchBtn);
	}
}
