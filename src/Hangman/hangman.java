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

        // Ініціалізація виведеного слова
        StringBuilder displayedWord = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            displayedWord.append("-");
        }

        // Виведення вказівки для гравця
        System.out.println(displayedWord);

        // Введення користувачем букв
        Scanner scanner = new Scanner(System.in);

        // Лічильник життів
        int lives = 8;

        // Масив для зберігання вже введених букв
        boolean[] guessedLetters = new boolean[26];

        while (lives > 0) {
            // Введення букви
            System.out.print("Input a letter: ");
            char guessedLetter = scanner.next().charAt(0);

            // Перевірка, чи буква вже вводилась
            if (guessedLetters[guessedLetter - 'a']) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }

            // Додавання букви до вже введених
            guessedLetters[guessedLetter - 'a'] = true;

            // Перевірка, чи буква є в слові
            if (checkLetter(secretWord, guessedLetter)) {
                // Перевірка, чи гравець вгадав всі літери і має ще спроби
                if (displayedWord.indexOf("-") == -1 && lives > 0) {
                    System.out.println("You guessed the word!");
                    System.out.println("You survived!");
                    break;
                }

                // Оновлення виведеного слова після введення правильної букви
                updateDisplayedWord(secretWord, displayedWord, guessedLetter);
                System.out.println(displayedWord);
            } else {
                // Зменшення кількості спроб і виведення відповідного повідомлення
                lives--;
                if (lives > 0) {
                    System.out.println("That letter doesn't appear in the word");
                    System.out.println(displayedWord);
                } else {
                    System.out.println("You lost!");
                }
            }
        }

        // Закриття сканера
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

    // Функція для перевірки, чи буква є в слові
    private static boolean checkLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }

    // Функція для оновлення виведеного слова після введення правильної букви
    private static void updateDisplayedWord(String secretWord, StringBuilder displayedWord, char guessedLetter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedLetter) {
                displayedWord.setCharAt(i, guessedLetter);
            }
        }
    }
}
