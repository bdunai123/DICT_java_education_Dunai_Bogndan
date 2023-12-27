import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void displayIntro() {
        System.out.println("HANGMAN");
        System.out.println("Welcome to the Hangman Game!");
        System.out.println("The game will be available soon.");
        System.out.println();
    }

    public static String chooseWord() {
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    public static String displayWord(String word, String[] guessedLetters) {
        StringBuilder display = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (containsLetter(guessedLetters, letter)) {
                display.append(letter);
            } else {
                display.append('-');
            }
        }
        return display.toString();
    }

    public static boolean containsLetter(String[] array, char letter) {
        for (String str : array) {
            if (str != null && str.length() == 1 && str.charAt(0) == letter) {
                return true;
            }
        }
        return false;
    }

    public static void playHangman() {
        String wordToGuess = chooseWord();
        String[] guessedLetters = new String[26];
        int attemptsLeft = 8;

        System.out.println(displayWord(wordToGuess, guessedLetters));

        Scanner scanner = new Scanner(System.in);
        while (attemptsLeft > 0) {
            System.out.print("Input a letter: > ");
            String userInput = scanner.next().toLowerCase();

            if (userInput.equals("exit")) {
                break;
            } else if (userInput.equals("play")) {
                playHangman();
                return; // Return to the main menu after playing
            }

            if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
                System.out.println("Please enter a lowercase English letter.");
                continue;
            }

            char inputLetter = userInput.charAt(0);

            if (containsLetter(guessedLetters, inputLetter)) {
                System.out.println("You've already guessed this letter");
            } else if (wordToGuess.contains(userInput)) {
                guessedLetters[inputLetter - 'a'] = userInput;
                System.out.println(displayWord(wordToGuess, guessedLetters));
                if (!displayWord(wordToGuess, guessedLetters).contains("-")) {
                    System.out.println("You guessed the word " + wordToGuess + "!");
                    System.out.println("You survived!");
                    return; // Return to the main menu after winning
                }
            } else {
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word");
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.println(displayWord(wordToGuess, guessedLetters));
            }

            if (attemptsLeft == 0) {
                System.out.println("You lost!");
                return; // Return to the main menu after losing
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayIntro();
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String userChoice = scanner.next().toLowerCase();

            if (userChoice.equals("exit")) {
                break;
            } else if (userChoice.equals("play")) {
                playHangman();
            } else {
                System.out.println("Invalid choice. Please enter \"play\" or \"exit\".");
            }
        }
    }
}
