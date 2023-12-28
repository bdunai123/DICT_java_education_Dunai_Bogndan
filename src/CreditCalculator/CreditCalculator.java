import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        // Створення об'єкта Scanner для отримання введених користувачем даних
        Scanner scanner = new Scanner(System.in);

        // Запит користувача на введення суми кредиту
        System.out.println("Enter the loan principal:");
        double loanPrincipal = scanner.nextDouble();

        // Запит користувача на вибір розрахунку
        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" – for number of monthly payments,");
        System.out.println("type \"p\" – for the monthly payment:");
        char calculationType = scanner.next().charAt(0);

        if (calculationType == 'm') {
            // Розрахунок кількості місяців
            System.out.println("Enter the monthly payment:");
            double monthlyPayment = scanner.nextDouble();
            int months = (int) Math.ceil(loanPrincipal / monthlyPayment);
            System.out.println("It will take " + months + " months to repay the loan");
        } else if (calculationType == 'p') {
            // Розрахунок щомісячного платежу
            System.out.println("Enter the number of months:");
            int numberOfMonths = scanner.nextInt();
            double monthlyPayment = loanPrincipal / numberOfMonths;
            double lastPayment = loanPrincipal - (numberOfMonths - 1) * monthlyPayment;
            System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment));
            System.out.println("and the last payment = " + (int) Math.ceil(lastPayment));
        }

        // Закриваємо Scanner
        scanner.close();
    }
}
