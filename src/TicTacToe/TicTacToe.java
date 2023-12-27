public class TicTacToe {
    public static void main(String[] args) {
        // Ігрове поле
        char[][] gameBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };

        // Виведення ігрового поля
        printGameBoard(gameBoard);
    }

    // Метод для виведення ігрового поля
    public static void printGameBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
