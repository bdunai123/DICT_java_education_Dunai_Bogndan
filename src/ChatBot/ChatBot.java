package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Етап 1-st stage: Привітання бота
        String botName = "JavaBot";
        int birthYear = java.time.Year.now().getValue();

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");

        // Етап 2-nd stage: Представлення боту
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, remind me your name.");

        // Зчитування ім'я користувача зі стандартного введення
        String userName = scanner.nextLine();

        System.out.println("What a great name you have, " + userName + "!");
    }
}


