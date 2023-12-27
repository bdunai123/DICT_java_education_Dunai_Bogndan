import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        // Виведення привітання
        displayIntro();

        // Загадане слово
        String secretWord = "java";

        // Виведення вказівки для гравця
        System.out.print("Guess the word: ");

        // Введення користувачем слова
        Scanner scanner = new Scanner(System.in);
        String guessedWord = scanner.next();

        // Перевірка правильності введеного слова
        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }

    // Функція для виведення анонсу гри
    private static void displayIntro() {
        System.out.println("HANGMAN");
        System.out.println("Welcome to the Hangman Game!");
    }
}
