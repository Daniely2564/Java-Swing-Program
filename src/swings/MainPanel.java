package swings;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private Image img;
	public MainPanel(){
		
	}
	public MainPanel(Image img){
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setMaximumSize(null);
		setMinimumSize(null);
		setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(img, 0,0,null);
	}
}
