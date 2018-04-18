package swings;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Panel extends JPanel{
	Image img;
	public Panel(Image img){
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setMaximumSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setMinimumSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
		
	}
	
	public Dimension getDimension(){
		return new Dimension(img.getWidth(null),img.getHeight(null));
	}
	
	public int getWidth(){
		return img.getWidth(null);
	}
	
	public int getHeight(){
		return img.getHeight(null);
	}
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
}
