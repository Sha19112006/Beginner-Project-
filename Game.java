import java.util.Random;
import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to Stone Paper Scissors!");
        boolean playAgain = true;
        
        while (playAgain) {
            System.out.println("\nEnter your choice: ");
            System.out.println("1. Stone");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.print("Your choice (1-3): ");
            
            int playerChoice = scanner.nextInt();
            
            if (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                continue;
            }
            
            int computerChoice = random.nextInt(3) + 1;
            
            String playerMove = getMove(playerChoice);
            String computerMove = getMove(computerChoice);
            
            System.out.println("\nYou chose: " + playerMove);
            System.out.println("Computer chose: " + computerMove);
            
            int result = determineWinner(playerChoice, computerChoice);
            
            if (result == 0) {
                System.out.println("It's a Tie!");
            } else if (result == 1) {
                System.out.println("You Win!");
            } else {
                System.out.println("Computer Wins!");
            }
            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
    
    private static String getMove(int choice) {
        switch (choice) {
            case 1:
                return "Stone";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Unknown";
        }
    }
    
    private static int determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0; // Tie
        }
        
        if ((playerChoice == 1 && computerChoice == 3) ||
            (playerChoice == 2 && computerChoice == 1) ||
            (playerChoice == 3 && computerChoice == 2)) {
            return 1; // Player wins
        }
        
        return -1; // Computer wins
    }
}
