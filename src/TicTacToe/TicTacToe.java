import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = createEmptyGameBoard();

        printGameBoard(gameBoard);

        char currentPlayer = 'X';
        boolean gameFinished = false;

        while (!gameFinished) {
            makeMove(scanner, gameBoard, currentPlayer);
            printGameBoard(gameBoard);

            if (checkGameStatus(gameBoard, currentPlayer)) {
                System.out.println(currentPlayer + " wins");
                gameFinished = true;
            } else if (isBoardFull(gameBoard)) {
                System.out.println("Draw");
                gameFinished = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    public static char[][] createEmptyGameBoard() {
        return new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
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

    public static void makeMove(Scanner scanner, char[][] board, char currentPlayer) {
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
                board[3 - col][row - 1] = currentPlayer;
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

    public static boolean checkGameStatus(char[][] board, char currentPlayer) {
        for (int i = 0; i < board.length; i++) {
            // Check rows and columns
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
