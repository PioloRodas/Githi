import java.util.Scanner;
import java.util.Random;

public class PigGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] playerScores = {0, 0};
        int currentPlayer = 0;
        boolean gameOver = false;

        while (!gameOver) {
            System.out.printf("Player %d's turn\n", currentPlayer + 1);
            int turnScore = 0;

            // roll the dice
            int roll = random.nextInt(6) + 1;
            while (roll != 1) {
                System.out.printf("Roll: %d\n", roll);
                turnScore += roll;

                // ask the player if they want to roll again or hold
                System.out.print("Roll again? (y/n): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    roll = random.nextInt(6) + 1;
                } else {
                    break;
                }
            }

            // update the player's score and check for a winner
            playerScores[currentPlayer] += turnScore;
            System.out.printf("Player %d's turn score: %d\n", currentPlayer + 1, turnScore);
            System.out.printf("Player 1's score: %d, Player 2's score: %d\n", playerScores[0], playerScores[1]);
            if (playerScores[currentPlayer] >= 100) {
                System.out.printf("Player %d wins!\n", currentPlayer + 1);
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer + 1) % 2;
            }
        }

        scanner.close();
    }
}