package swings;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ActivationPanel extends JPanel{
	Image img;
	public ActivationPanel(Image img){
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
}
