import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String userInput = scanner.nextLine();
        char[][] gameBoard = createGameBoard(userInput);
        printGameBoard(gameBoard);

        makeMove(scanner, gameBoard);

        printGameBoard(gameBoard);
    }

    public static char[][] createGameBoard(String input) {
        char[][] board = new char[3][3];
        int index = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = input.charAt(index);
                index++;
            }
        }

        return board;
    }

    public static void printGameBoard(char[][] board) {
        System.out.println("---------");

        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    public static void makeMove(Scanner scanner, char[][] board) {
        int row, col;

        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // Clear the input buffer
                continue;
            }

            if (isValidMove(row, col, board)) {
                board[3 - col][row - 1] = 'X';
                break;
            }
        }
    }

    public static boolean isValidMove(int row, int col, char[][] board) {
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (board[3 - col][row - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }
}
