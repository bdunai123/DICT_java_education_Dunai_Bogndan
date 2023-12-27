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

        // Підказка для гравця
        String wordHint = generateWordHint(secretWord);

        // Виведення вказівки для гравця
        System.out.println("HANGMAN");
        System.out.println("Guess the word " + wordHint + ": ");

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

    // Функція для генерації підказки для гравця
    private static String generateWordHint(String word) {
        StringBuilder wordHint = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i < 2) {
                wordHint.append(word.charAt(i));
            } else {
                wordHint.append("-");
            }
        }
        return wordHint.toString();
    }
}
