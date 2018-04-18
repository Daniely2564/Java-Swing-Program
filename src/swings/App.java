package swings;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Panel panel = new Panel(new ImageIcon(".\\src\\Image Sources\\Activation.jpg").getImage());
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(64, 83, 10, 10);
		panel.add(panel_1);
		frame.setSize(new Dimension(327, 379));
		frame.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
		frame.setMaximumSize(new Dimension(panel.getWidth(), panel.getHeight()));
		frame.setMinimumSize(new Dimension(panel.getWidth(), panel.getHeight()));
		frame.setVisible(true);

		frame.getContentPane().setSize(new Dimension(panel.getWidth(), panel.getHeight()));
		frame.getContentPane().setMaximumSize(new Dimension(panel.getWidth(), panel.getHeight()));
		frame.getContentPane().setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
