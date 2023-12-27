import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String userInput = scanner.nextLine();

        char[][] gameBoard = createGameBoard(userInput);
        printGameBoard(gameBoard);
    }

    // Метод для створення ігрового поля на основі введеного рядка
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

    // Метод для виведення ігрового поля
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
}
