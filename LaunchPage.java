import java.awt.*;
import java.awt.event.*;	// import of classes to create a launch page 
import javax.swing.*;		


public class LaunchPage implements ActionListener{

	JFrame frame = new JFrame();		//frame and text box for the launch page
	JTextArea text = new JTextArea();
	
	// create yes and no buttons to start or quit the game
	JButton playButton = new JButton("Yes");	
	JButton endButton = new JButton("No");			
	
	
	public LaunchPage(){	// default constructor
		
		// welcome page and instructions
		String welcome = ("Welcome to MathQuiz Test! \n\n"+
				"* Once you click yes, the timer will start\n"+
				"* You have 10 seconds for each question\n"+
				"* The wrong anwsers will be marked in red\n"+
				"* You will get feedback at the end of the quiz\n"+
				"\nAre you ready to play?");
		text.setText(welcome);
		
		// text style and color
		text.setFont(new Font("Ink Free", Font.ITALIC, 20));
		text.setBounds(20, 50, 500, 450);		// where the question appears
		text.setLineWrap(true); 		// go back to the line if question is long
		text.setWrapStyleWord(true);	
		text.setForeground(new Color(255, 255, 255));
		text.setBackground(new Color(25,25,112));
		text.setEditable(false);
		
		
		playButton.setBounds(50, 300, 50, 50);
		playButton.setFocusable(false);
		playButton.addActionListener(this);			/* This portion places the buttons
													to the frame and perform operations when
													clicked on 
														*/
		endButton.setBounds(150, 300, 50, 50);
		endButton.setFocusable(false);
		endButton.addActionListener(this);
		
		
		// design the frame
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 450);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(25,25,112));
		frame.setResizable(false);
		
		
		// add all the elements to the frame
		frame.add(playButton);
		frame.add(endButton);
		frame.add(text);
		
		frame.setVisible(true); // make the frame visible
		
	}


	@Override
	public void actionPerformed(ActionEvent e) { // handle events
		if(e.getSource()==playButton) {
			frame.dispose();
			new MathQuiz();					// close the window and launch the game if user clicks on yes
			
		}
		else if(e.getSource()==endButton) {
			System.exit(0);					// exits the program if user clicks on no
		}
		
	}
}
