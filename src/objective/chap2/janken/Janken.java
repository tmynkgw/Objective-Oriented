package objective.chap2.janken;

/**
 * ジャンケン
 *
 * @author Tomoya
 */
public class Janken {

    public static final int STONE = 0;
    public static final int SCISSORS = 1;
    public static final int PAPER = 2;

    public static void main(String[] args) {

        System.out.println("************************************************");
        System.out.println("** Game Start");
        System.out.println("************************************************");

        double randomNum = 0;

        int player1Hand = 0;
        int player2Hand = 0;

        int player1WinCount = 0;
        int player2WinCount = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Game" + (i + 1) + "：");
            // Player1
            randomNum = Math.random() * 3;
            if (randomNum < 1) {
                player1Hand = STONE;
                System.out.println("Player1：STONE");
            } else if (randomNum < 2) {
                player1Hand = SCISSORS;
                System.out.println("Player1：SCISSORS");
            } else {
                player1Hand = PAPER;
                System.out.println("Player1：PAPER");
            }

            // Player2
            randomNum = Math.random() * 3;
            if (randomNum < 1) {
                player2Hand = STONE;
                System.out.println("Player2：STONE");
            } else if (randomNum < 2) {
                player2Hand = SCISSORS;
                System.out.println("Player2：SCISSORS");
            } else {
                player2Hand = PAPER;
                System.out.println("Player2：PAPER");
            }
            if ((player1Hand == STONE && player2Hand == SCISSORS)
                    || (player1Hand == SCISSORS && player2Hand == PAPER)
                    || (player1Hand == PAPER && player2Hand == STONE)) {
                player1WinCount++;
                System.out.println("Winner：Player1");
            } else if ((player1Hand == STONE && player2Hand == PAPER)
                    || (player1Hand == SCISSORS && player2Hand == STONE)
                    || (player1Hand == PAPER && player2Hand == SCISSORS)) {
                player2WinCount++;
                System.out.println("Winner：Player2");
            } else {
                System.out.println("Winner：Draw Game");
            }
        }

        System.out.println("************************************************");
        System.out.println("** Game End");
        System.out.println("************************************************");

        if (player2WinCount < player1WinCount) {
            System.out.println("Result Winner：Player1（" + player1WinCount + "/" + player2WinCount + "）" );
        } else if (player1WinCount < player2WinCount) {
            System.out.println("Result Winner：Player2（" + player1WinCount + "/" + player2WinCount + "）" );
        } else {
            System.out.println("Result Winner：Draw Game" );
        }
    }
}
