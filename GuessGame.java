import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.bind.Marshaller.Listener;

public class GuessGame extends JFrame
{
	private JTextField guessNumber;
	private JButton guessButton;
	private Container c;
	private JFrame window;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	
	public GuessGame()
	{
		// window and north panel into the frame
		
		window = new JFrame();
		window.setSize(500, 500);
		northPanel = new JPanel();
		JLabel intro = new JLabel("Guess a number between 1 and 10");
		northPanel.add(intro);
		window.add(northPanel, BorderLayout.NORTH);
		
		// center panel
		centerPanel = new JPanel();
		guessNumber = new JTextField(3);
		guessButton = new JButton("Guess");
		centerPanel.add(guessNumber);
		centerPanel.add(guessButton);
		window.add(centerPanel, BorderLayout.CENTER);
		
		southPanel = new JPanel();
		final Container c = window.getContentPane();
		southPanel.add(c);
		window.add(southPanel, BorderLayout.SOUTH);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		guesserButtonHandler ghandler = new guesserButtonHandler();

		
		


		
		class guesserButtonHandler implements ActionListener

	
		    {
			public void actionPerformed(ActionEvent e)

			
	        {


				int number = (int) (10*Math.random())+1;
				String triedNum;
				int guess;
				
				triedNum = guessNumber.getText();
				guess = Integer.parseInt(triedNum);
				
				while (guess != number){
				try
				{
					if (guess < 1 || guess > 10)
					{throw new BadGuessException("THAT NUMBER IS NOT BETWEEN 1 AND 10");}
					
					if (number == guess)
						{
							System.out.println("YOU GOT IT ");
							c.setBackground(Color.yellow);
						}
					//put in the number of trials counts
					else
					{
						System.out.println("Please try again.");
						c.setBackground(Color.gray);
					}
				}
				catch (BadGuessException i)
				{
					System.out.println(i.getMessage());
					c.setBackground(Color.red);
				}
				catch (InputMismatchException i)
				{
					System.out.println("Integers only");
					c.setBackground(Color.red);
				}
			}
			}
			}
		}


	
	public static void main(String[] args)
	{
		new GuessGame();
	}
}
