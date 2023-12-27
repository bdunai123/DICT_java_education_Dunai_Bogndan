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

        // Етап 3-rd stage: Вгадування віку
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        // Зчитування залишків від ділення на 3, 5 і 7
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        // Обчислення віку за формулою
        int yourAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + yourAge + "; that's a good time to start programming!");

        // Етап 4-th stage: Підрахунок до введеного користувачем числа
        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userInp = scanner.nextInt();

        for (int i = 1; i <= userInp; i++) {
            System.out.println(i + "!");
        }

        // Етап 5-th stage: Тестування з програмування
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods in programming?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        // Зчитування відповіді користувача
        int userAnswer = scanner.nextInt();

        // Перевірка правильності відповіді
        while (userAnswer != 2) {
            System.out.println("Your answer is incorrect. Please, try again.");
            userAnswer = scanner.nextInt();
        }

        // Повідомлення про правильну відповідь
        System.out.println("Congratulations! That's correct.");

        // Завершення програми
        System.out.println("Goodbye, have a nice day!");
    }
}




