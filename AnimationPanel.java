import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimationPanel extends JPanel implements ActionListener{

	final int WIDTH = 450;
	final int HEIGHT = 450;
	Image mathIcon;
	Image backgroundImage; 
	Timer timer;
	int xSpeed = 1;
	int ySpeed = 1;
	int x = 0;
	int y = 0;
	
	AnimationPanel(){	// sets the animation panel
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.black);
		mathIcon = new ImageIcon("images.png").getImage();	// background image
		backgroundImage = new ImageIcon("back.png").getImage(); // moving image
		timer = new Timer(10, this);
		timer.start();
	}

	public void paint(Graphics g) {
		
		super.paint(g); // paint background
		
		Graphics2D g2D = (Graphics2D) g;
		
		//g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(mathIcon, x, y, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x>=WIDTH-mathIcon.getWidth(null) || x<0) {
			xSpeed = xSpeed * -1;	// bounce back if it hits the right edge of the frame 
		}
		x = x + xSpeed;	// increase the horizontal speed as it moves 
		
		if(y>=HEIGHT-mathIcon.getHeight(null) || y<0) {
			ySpeed = ySpeed * -1;  // bounce back if it hits the bottom edge of the frame
		}
		y = y + ySpeed;	// increase the vertical speed as it moves
		repaint();  // repaints as it moves
	}
}