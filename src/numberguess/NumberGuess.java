package numberguess;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

//This program generates a random number that the user must guess

public class NumberGuess {
	public static void main(String[] args) {
		//This sets up the variables and the random number used throughout the rest of the code
		Random randomNum = new Random();
		int num = randomNum.nextInt(100);
		int guessCount = 0;
		
		//This displays the instructions to the game.
		System.out.println("This program generates a random number 1-100.");
		System.out.println("You must enter a number and guess the correct one.");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		// This loops the question so that the user gets multiple guesses.
		while(true) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please enter a number: ");
			int question = userInput.nextInt();

			// This checks if the inputed number is greater than or less than the generated number
			try {
				numberChecker(question, guessCount);
				userInput.close();
				throw new NumberFormatException("That is not a valid integer.");
				break;
			}
			catch(NumberFormatException e){
				//throw new NumberFormatException("That is not a valid integer.");
				//System.out.println("That is not a valid integer.");
				//userInput.close();
				throw e;
			}
		}
	}
	public static void numberChecker(int question, int guessCount) {
		if(question > num ) {
			System.out.println("You entered " + question);
			System.out.println("Your number is too large. Please guess again.");
			guessCount++;					
		}else if (question < num){
			System.out.println("You entered " + question);
			System.out.println("Your number is too small. Please guess again.");
			guessCount++;
			// if the user guesses the randomly generated number, the game ends here.
		}else if (question == num){
			System.out.println("You got it right!");
			guessCount++;
			System.out.println("It took you " + guessCount + " guess(es)!");
}

