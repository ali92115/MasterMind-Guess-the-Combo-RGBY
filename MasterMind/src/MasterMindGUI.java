import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MasterMindGUI implements ActionListener {
	
	//Default Start is "RRRR"
	private JFrame frame;
	private JTextField txtWelcomeToThe;
	private int[] buttonValues = {0, 0, 0, 0};
	private JButton[] buttons;
	private String answer ="";
	private MasterMindLogic logicMaker;
	private String userAnswer = "";
	private JTextField txtHits;
	private JTextField txtPsuedohits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterMindGUI window = new MasterMindGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MasterMindGUI() {
		logicMaker = new MasterMindLogic();
		answer = logicMaker.createCombo();
		buttons = new JButton[4];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setBackground(Color.ORANGE);
		txtWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeToThe.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		txtWelcomeToThe.setBounds(0, 0, 552, 53);
		txtWelcomeToThe.setText("The Great Wizard Fohr Tea Chew Challenges you!");
		frame.getContentPane().add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
		
		JButton btnNewButton = new JButton("#1");
		buttons[0] = btnNewButton;
		colorSwap(0);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(21, 129, 119, 91);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("#2");
		buttons[1] = btnNewButton_1;
		colorSwap(1);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(150, 129, 119, 91);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("#3");
		buttons[2] = btnNewButton_2;
		colorSwap(2);
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(279, 129, 119, 91);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("#4");
		buttons[3] = btnNewButton_3;
		colorSwap(3);
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(408, 129, 119, 91);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\yushu\\eclipse-workspace\\MasterMind\\25433-9-submit-button-transparent-image-thumb2.png"));
		btnNewButton_4.setBounds(118, 271, 299, 85);
		frame.getContentPane().add(btnNewButton_4);
		
		txtHits = new JTextField();
		txtHits.setText("HITS : ");
		txtHits.setBounds(73, 75, 86, 20);
		frame.getContentPane().add(txtHits);
		txtHits.setColumns(10);
		
		txtPsuedohits = new JTextField();
		txtPsuedohits.setText("PSUEDOHITS: ");
		txtPsuedohits.setBounds(369, 75, 119, 20);
		frame.getContentPane().add(txtPsuedohits);
		txtPsuedohits.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]) {
			buttonValues[0]++;
			colorSwap(0);
		} else if(e.getSource() == buttons[1]) {
			buttonValues[1]++;
			colorSwap(1);
		} else if(e.getSource() == buttons[2]) {
			buttonValues[2]++;
			colorSwap(2);
		} else if(e.getSource() == buttons[3]) {
			buttonValues[3]++;
			colorSwap(3);
		} else {
			userAnswer = "";
			for(int i = 0; i < buttons.length; i++) {
				userAnswer += logicMaker.userGuessCombo(i, buttonValues[i]);
			}
			

			MasterMindHits compare = logicMaker.findHits(answer, userAnswer);
			txtHits.setText("Hits: " + compare.getHits());
			txtPsuedohits.setText("PsuedoHits: " + compare.getPsuedoHits());
		}
		
	}
	
	private void colorSwap(int button) {
		if(buttonValues[button] % 4 == 0) {
			buttons[button].setBackground(Color.RED);
		} else if(buttonValues[button] % 4 == 1) {
			buttons[button].setBackground(Color.YELLOW);
		} else if(buttonValues[button] % 4 == 2) {
			buttons[button].setBackground(Color.GREEN);
		} else {
			buttons[button].setBackground(Color.BLUE);
		}
	}
}
