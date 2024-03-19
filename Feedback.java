import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Feedback {	// class that give feedback after quiz
	
	public Feedback(int result) { // takes result percentage as argument
		
		ImageIcon awesome = new ImageIcon("ico.png"); // icon for awesome
		ImageIcon good = new ImageIcon("/ico2.png");   // icon for good
		ImageIcon bad = new ImageIcon("ico1.png");    // icon for bad
		
		// displays feedback with appropriate icon
		if(result>=75) {
			JOptionPane.showMessageDialog(null, "Your score was "+result+"% !\nAwesome! :)", "Feedback", JOptionPane.INFORMATION_MESSAGE, awesome);
		}
		else if(result>=50) {
		    JOptionPane.showMessageDialog(null, "Your score was "+result+"% !\nGood Job! You might want to do some review :)", "Feedback", JOptionPane.INFORMATION_MESSAGE,good);
		}
		else {
			JOptionPane.showMessageDialog(null, "Your score was "+result+"% !\nYou need to study :(", "Feedback", JOptionPane.INFORMATION_MESSAGE,bad);
		}
		
		new AnimationFrame();
		
		
	
	}
	
	
	
}
