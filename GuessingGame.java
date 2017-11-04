/*
 * Hau Truong
 * 05/ 08/ 2016
 * Assignment 9
 */
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame 
{
	public static void main (String [] args) throws BadGuessException 
	{
		
		
		// generate a new number in the range of 1 to 10, and count
			int correctNumber = (int)(Math.random()*10+1);
			int numberOfTrials = 1;
	
			// ask the user to enter a number
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Please guess a whole number between 1 and 10");
		
				// looping for after the catch
			boolean retry = true;
			while (retry == true){
				
			
				//try and catch	
				try
				{
				
					int guessNumber = keyboard.nextInt();
			
					if (guessNumber<1||guessNumber>10)
					{
						throw new BadGuessException();
					}
				//  for the guessing 
		
				while(guessNumber != correctNumber)
				{
					numberOfTrials++;
					System.out.println("Please enter another number!");
					guessNumber = keyboard.nextInt();
	
				}
				
					
					if (guessNumber == correctNumber)
					{
						System.out.println("YOU GOT IT, and you tried " + numberOfTrials + " times!");
						retry = false;
						System.exit(0);
					}else {}		
				}
				catch (BadGuessException bg)
				{
					System.out.println(bg.getMessage()+ " Try again.");
					retry = true;
					numberOfTrials++;
			
				}
				catch (InputMismatchException e) {
				    System.out.println("Sorry, you entered an invalid number format. Try again");
				    retry = true;
				    keyboard.next(); 
				    numberOfTrials++;
				} 
		
			}
	}
}
