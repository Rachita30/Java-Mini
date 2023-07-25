package game;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[SIZE][SIZE];
        currentPlayer = PLAYER_X;

        // Initialize the board with empty spaces
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print the current board state
            printBoard();

            // Get the player's move
            System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Make the move
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;

                // Check for a win
                if (hasWon(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Check for a draw
                if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch players
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            } else {
                System.out.println("Invalid move! Please try again.");
            }
        }

        // Game over
        printBoard();
        scanner.close();
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    private boolean isValidMove(int row, int col) {
        // Check if the cell is empty and within the board boundaries
        return (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY);
    }

    private boolean hasWon(char player) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Row win
            }

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal win (top-left to bottom-right)
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal win (top-right to bottom-left)
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    return false; // Found an empty cell
                }
            }
        }
        return true; // All cells are filled
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
