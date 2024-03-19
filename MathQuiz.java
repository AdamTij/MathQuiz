import java.awt.event.*;
import java.awt.*;			// import of class 
import javax.swing.*;


/* This class runs the actual game*/

public class MathQuiz implements ActionListener {
	
	
	String[] questions = { "  What is 7 - 2?",
						   "  What is 9 - 4?",  
						   "  What is 4 - 1?",
						   "  What is 6 - 3?",
						   "  What is 8 - 5?",
						   "  What is 10 - 1?",  // string array of questions
						   "  What is 9 - 7?",
						   "  What is 3 - 2?",
						   "  What is 5 - 5?",
						   "  What is 3 - 1?",

			
							};
	
	
	String[][] options = {
								{"5","4","6","3"},
								{"7","2","5","4"},	// string array of options
								{"1","2","5","3"},
								{"3","2","7","4"},
								{"1","2","3","4"},
								{"2","6","9","7"},	// string array of options
								{"0","5","3","2"},
								{"1","3","2","4"},
								{"1","2","0","3"},
								{"0","1","3","2"}
			
							};
			
	
	char[] answers = {'A',
					  'C',		// char array of right answers
					  'D',
					  'A',
					  'C',
					  'C',
					  'D',
					  'A',
					  'C',
					  'D',
	};
	
	
	// data fields
	char guess;
	int index;
	int correctAnswers = 0;
	int totalQuestions = questions.length;
	int result;
	int seconds = 10;
	
	
	/* This portion of the code creates the title, question boxes, option buttons with their labels
	 * and timer
	 */
	JFrame frame = new JFrame();	
	
	JTextField titleBox = new JTextField();
	JTextArea questionBox = new JTextArea();
	
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel answerLabelC = new JLabel();
	JLabel answerLabelD = new JLabel();
	
	JLabel timeLabel = new JLabel();
	JLabel timeLeft = new JLabel();
	
	JTextField percentage = new JTextField();
	
	Timer time = new Timer(1000, new ActionListener() {    // timer object
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			timeLeft.setText(String.valueOf(seconds));
			
			if(seconds<=0) {
				answer();		// display answers if time elapsed
			}
			
		}
	});


public MathQuiz() {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // exit out of the application if window is closed
	
	// frame details
	frame.setSize(880, 780);	
	frame.setTitle("MathQuiz Test"); 	
	
	ImageIcon image = new ImageIcon("images.png");
	frame.setIconImage(image.getImage()); // sets game icon
	
	
	frame.getContentPane().setBackground(new Color(128,128,128));
	frame.setLayout(null);    	
	frame.setResizable(false);	// prevent the frame from being resized
	
	Title(titleBox);			// edits title box
	Questions(questionBox);		// edits question box
	
	// design buttons
	buttonA.setText("A");
	buttonA.setBounds(0, 350, 100, 100);
	buttonA.setFont(new Font("MV Boli", Font.PLAIN, 20));
	buttonA.setFocusable(true);  		// avoid highlighting 
	buttonA.addActionListener(this);
	
	buttonB.setText("B");
	buttonB.setBounds(0, 450, 100, 100);
	buttonB.setFont(new Font("MV Boli", Font.PLAIN, 20));
	buttonB.setFocusable(true);  		// avoid highlighting 
	buttonB.addActionListener(this);
	
	buttonC.setText("C");
	buttonC.setBounds( 0, 550, 100, 100);
	buttonC.setFont(new Font("MV Boli", Font.PLAIN, 20));
	buttonC.setFocusable(true);  		// avoid highlighting 
	buttonC.addActionListener(this);
	
	buttonD.setText("D");
	buttonD.setBounds(0, 650, 100, 100);
	buttonD.setFont(new Font("MV Boli", Font.PLAIN, 20));
	buttonD.setFocusable(true);  		// avoid highlighting 
	buttonD.addActionListener(this);	
	
	// put options next to buttons
	Label(answerLabelA,150, 350, 100, 100);
	Label(answerLabelB,150, 450, 100, 100);
	Label(answerLabelC,150, 550, 100, 100);
	Label(answerLabelD,150, 650, 100, 100);

	// edit timer
	TimeLeft(timeLeft);
	TimeLabel(timeLabel);
	
	// add all elements to the frame
	frame.add(timeLabel);
	frame.add(timeLeft);
	frame.add(titleBox);
	frame.add(questionBox);
	frame.add(buttonA);
	frame.add(buttonB);
	frame.add(buttonC);
	frame.add(buttonD);
	frame.add(answerLabelA);
	frame.add(answerLabelB);
	frame.add(answerLabelC);
	frame.add(answerLabelD);
	frame.setVisible(true);		// make the frame visible 
	
	nextQuestion(); // move on to next question		
}


@Override
public void actionPerformed(ActionEvent e) {
	buttonA.setEnabled(false);
	buttonB.setEnabled(false); // prevent user from answering multiple times
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);
	
	// increment correctAnswers by 1 if right answer is clicked
	if(e.getSource()==buttonA) {
		guess = 'A';
		if(guess==answers[index]) {
			correctAnswers++;
		}
	}
	if(e.getSource()==buttonA) {
		guess = 'A';
		if(guess==answers[index]) {
			correctAnswers++;
		}
	}
	if(e.getSource()==buttonB) {
			guess = 'B';
		if(guess==answers[index]) {
			correctAnswers++;
		}
	}
	if(e.getSource()==buttonC) {
				guess = 'C';
		if(guess==answers[index]) {
				correctAnswers++;
		}
	}
	
	if(e.getSource()==buttonD) {
		guess = 'D';
		if(guess==answers[index]) {
		correctAnswers++;
		}
	}						
	
	answer(); // display answer at the end of the quiz
	
	}


public void answer() {
	
	time.stop();	// stop the timer when time elapsed
	buttonA.setEnabled(false);
	buttonB.setEnabled(false);	// disable the buttons
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);
	
	// leave right answer in green and turn wrong answers in red
	if(answers[index] != 'A') {
		answerLabelA.setForeground(new Color(255,0,0));
	}
	if(answers[index] != 'B') {
		answerLabelB.setForeground(new Color(255,0,0));
	}
	if(answers[index] != 'C') {
		answerLabelC.setForeground(new Color(255,0,0));
	}
	if(answers[index] != 'D') {
		answerLabelD.setForeground(new Color(255,0,0));
	}
	
	
	
	Timer pause = new Timer(2000, new ActionListener() { // make a delay before moving on to the next question
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// set everything to initial state after answer is displayed 
			answerLabelA.setForeground(new Color(50,205,50));
			answerLabelB.setForeground(new Color(50,205,50));
			answerLabelC.setForeground(new Color(50,205,50));
			answerLabelD.setForeground(new Color(50,205,50));
			
			buttonA.setEnabled(true);
			buttonB.setEnabled(true);
			buttonC.setEnabled(true);
			buttonD.setEnabled(true);
			
			guess = ' ';
			
			seconds = 10;
			timeLeft.setText(String.valueOf(seconds));
			
			// move on to next question
			index++; 
			nextQuestion(); 	
		}
	});
	
	pause.setRepeats(false); 	// reset the timer
	pause.start();
	
	}


public void result() {
	
	buttonA.setEnabled(false);
	buttonB.setEnabled(false);  // disable buttons at the end of the quiz
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);
	
	// calculate percentage of correct answers
	result = (int)((correctAnswers/(double)totalQuestions)*100-30);
	
	time.stop();	// stop timer
	new Feedback(result);	// display feedback
	}


public void nextQuestion() {
	if(index>= totalQuestions) {
		result();	// display result after last question
		
	}
	else { 
		// else increment question number, display new question and options
		titleBox.setText("Question "+(index+1));
		questionBox.setText(questions[index]);
		answerLabelA.setText(options[index][0]);
		answerLabelB.setText(options[index][1]);
		answerLabelC.setText(options[index][2]);
		answerLabelD.setText(options[index][3]);
		
		time.start(); // start timer
	}
}


//------- The following methods build up the frame with its components and reduce the code above -----------------//

public void Title(JTextField title) {
	title.setBounds(0, 0, 880, 100);		// where the question appears
	title.setBackground(new Color(25,25,112));
	title.setForeground(new Color(255,255,255));
	title.setFont(new Font("Ink Free", Font.PLAIN, 30));
	title.setBorder(BorderFactory.createEtchedBorder(1));
	title.setHorizontalAlignment(JTextField.CENTER);
	title.setEditable(false);		// not editable
	title.setText("Math Quiz test");
}


public void Questions(JTextArea textArea) {
	textArea.setBounds(0, 150, 880, 150);		// where the question appears
	textArea.setLineWrap(true); 		// go back to the line if question is long
	textArea.setWrapStyleWord(true);	
	textArea.setBackground(new Color(25,25,112));
	textArea.setForeground(new Color(255, 255, 255));
	textArea.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
	textArea.setBorder(BorderFactory.createEtchedBorder(1));
	textArea.setEditable(false);	
}


public void Label(JLabel label, int x, int y, int w, int h) {
	label.setBounds(x, y, w, h);
	label.setBackground(new Color(50,50,50));
	label.setForeground(new Color(50,205,50));
	label.setFont(new Font("MV Boli",Font.PLAIN,35));
}


public void TimeLeft(JLabel time) {
	time.setBounds(782, 652, 100, 105);
	time.setBackground(new Color(100, 100, 100));
	time.setForeground(new Color(140,0,32));
	time.setFont(new Font("Ink Free", Font.BOLD, 60));
	time.setBorder(BorderFactory.createBevelBorder(1));
	time.setOpaque(true);
	time.setHorizontalAlignment(JTextField.CENTER);
	time.setText(String.valueOf(seconds));
}


public void TimeLabel(JLabel timeTitle) {
	timeTitle.setBounds(782, 580, 100, 105);
	timeTitle.setBackground(new Color(100, 100, 100));
	timeTitle.setForeground(new Color(140,0,32));
	timeTitle.setFont(new Font("Ink Free", Font.PLAIN, 20));
	timeTitle.setHorizontalAlignment(JTextField.CENTER);
	timeTitle.setText("time left: ");
}

}