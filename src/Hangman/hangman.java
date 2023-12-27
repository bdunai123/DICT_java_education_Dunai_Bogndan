import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        // Список слів
        String[] words = {"python", "java", "javascript", "kotlin"};

        // Виведення привітання
        displayIntro();

        // Випадковий вибір слова
        String secretWord = chooseWord(words);

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

    // Функція для вибору випадкового слова зі списку
    private static String chooseWord(String[] words) {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }
}