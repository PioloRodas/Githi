# Githi
import java.util.Scanner;
import java.util.Random;

public class PigGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int computerScore = 0;
            int playerScore = 0;

            System.out.println("Let's play Pig Game!");
            System.out.println("You will roll a die and try to accumulate points.");
            System.out.println("If you roll a 1, your turn is over and you lose all points accumulated in that turn.");
            System.out.println("If you want to hold, you can end your turn and add the points you've accumulated to your total score.");
            System.out.println("The first player to reach 100 points wins!");

            while (playerScore < 100 && computerScore < 100) {
                System.out.println();
                System.out.println("Player score: " + playerScore);
                System.out.println("Computer score: " + computerScore);
                System.out.print("Roll or hold? (r/h): ");
                String choice = input.nextLine();

                switch (choice.toLowerCase()) {
                    case "r":
                        int roll = rand.nextInt(6) + 1;
                        System.out.println("You rolled a " + roll);

                        if (roll == 1) {
                            System.out.println("You lose all points accumulated in this turn.");
                            playerScore -= playerScore;
                            break;
                        } else {
                            playerScore += roll;
                        }
                        break;

                    case "h":
                        System.out.println("You chose to hold. Your turn is over.");
                        break;

                    default:
                        System.out.println("Invalid input. Try again.");
                        break;
                }

                int computerRoll = rand.nextInt(6) + 1;
                System.out.println("The computer rolled a " + computerRoll);

                if (computerRoll == 1) {
                    System.out.println("The computer loses all points accumulated in this turn.");
                    computerScore -= computerScore;
                    break;
                } else {
                    computerScore += computerRoll;
                }
            }

            System.out.println();
            System.out.println("Final scores:");
            System.out.println("Player score: " + playerScore);
            System.out.println("Computer score: " + computerScore);

            if (playerScore >= 100) {
                System.out.println("Congratulations! You win!");
            } else if (computerScore >= 100) {
                System.out.println("Sorry, the computer wins.");
            } else {
                System.out.println("Game over.");
            }

            System.out.print("Would you like to play again? (y/n): ");
            String playAgainChoice = input.nextLine();

            if (playAgainChoice.toLowerCase().equals("n")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
    }
}
