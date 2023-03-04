import java.util.Scanner;
import java.util.Random;


class NumberGuessingGame {
	
	int systemGeneratedNumber;
	int userInput;
	int noOfGuesses = 0;
	Scanner sc=new Scanner(System.in);
	// generating random number in default constructor
	NumberGuessingGame() {
		Random randomobj = new Random();
		this.systemGeneratedNumber = randomobj.nextInt(100) + 1;
	}
	
	//method to take user input  
	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("Guess the number : ");
			this.userInput = sc.nextInt();
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...");
			return true;
		}
	}
	
	
	//method to check user guess status
	public boolean isCorrectGuess() {
		
		if ( systemGeneratedNumber == userInput ) {
			System.out.println("Congratulations!!");
			System.out.println("you have guessed the number " + systemGeneratedNumber +
			" in " + noOfGuesses + " guesses");
			switch(noOfGuesses) {
				case 1:
				System.out.println("Your score is 100");
				break;
				case 2:
				System.out.println("Your score is 90");
				break;
				case 3:
				System.out.println("Your score is 80");
				break;
				case 4:
				System.out.println("Your score is 70");
				break;
				case 5:
				System.out.println("Your score is 60");
				break;
				case 6:
				System.out.println("Your score is 50");
				break;
				case 7:
				System.out.println("Your score is 40");
				break;
				case 8:
				System.out.println("Your score is 30");
				break;
				case 9:
				System.out.println("Your score is 20");
				break;
				case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && userInput > systemGeneratedNumber ) {
			if ( userInput - systemGeneratedNumber >=10 ) 
				System.out.println(" Your number is very big");
			
			else 
			    System.out.println("Your number is little bigger");
			
		}
		else if ( noOfGuesses < 10 && userInput < systemGeneratedNumber) {
			if ( systemGeneratedNumber - userInput >=10 ) 
			    System.out.println("Your number is very small");
			
			else 
				System.out.println("Your number is little  smaller");
			
		}
		return false;
	}
}

// main class
public class  GuessNumber {
	 
	public static void main(String[] args) {
		
		// input for start the game
		System.out.println("1.Start the Game");
		System.out.println("2.Exit");
		System.out.print("Enter your choice : ");
		Scanner sc=new Scanner(System.in);
		int choice = sc.nextInt();
		int nextRound;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			do{
				// creating object of NumberGuessingGame class
				 NumberGuessingGame game = new NumberGuessingGame();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + (++noOfRound) + " starts...");
				
				// to check whether number is matched and limit is crossed for number of guesses 
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
				// input for next round
				System.out.println("1. Next Round");
				System.out.println("2.Exit");
				System.out.print("Enter your choice : ");
				nextRound = sc.nextInt();
			}while(nextRound==1);
		}
		else 
			System.exit(0);
		
	}
}
