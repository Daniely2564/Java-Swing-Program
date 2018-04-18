package swings;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LogInBtn extends JButton {
	public LogInBtn(ImageIcon icon){
		setPreferredSize(new Dimension(icon.getImage().getWidth(null),icon.getImage().getHeight(null)));
		setSize(new Dimension(icon.getImage().getWidth(null),icon.getImage().getHeight(null)));
		setIcon(icon);
	}
}
