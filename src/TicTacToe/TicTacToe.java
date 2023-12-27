import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String userInput = scanner.nextLine();

        char[][] gameBoard = createGameBoard(userInput);
        printGameBoard(gameBoard);
        analyzeGame(gameBoard);
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

    // Метод для аналізу стану гри
    public static void analyzeGame(char[][] board) {
        if (checkImpossible(board)) {
            System.out.println("Impossible");
        } else if (checkWinner(board, 'X')) {
            System.out.println("X wins");
        } else if (checkWinner(board, 'O')) {
            System.out.println("O wins");
        } else if (checkDraw(board)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    // Метод для перевірки неможливості гри
    public static boolean checkImpossible(char[][] board) {
        int countX = countSymbol(board, 'X');
        int countO = countSymbol(board, 'O');

        int diff = Math.abs(countX - countO);
        return diff >= 2 || (checkWinner(board, 'X') && checkWinner(board, 'O'));
    }

    // Метод для перевірки переможця
    public static boolean checkWinner(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            // Перевірка по рядках та стовпцях
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Перевірка по діагоналям
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    // Метод для перевірки нічиєї
    public static boolean checkDraw(char[][] board) {
        return !checkWinner(board, 'X') && !checkWinner(board, 'O') && countSymbol(board, '_') == 0;
    }

    // Метод для підрахунку кількості символів на ігровому полі
    public static int countSymbol(char[][] board, char symbol) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }
}
