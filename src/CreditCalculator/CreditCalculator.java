import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        // Створення об'єкта Scanner для отримання введених користувачем даних
        Scanner scanner = new Scanner(System.in);

        // Запит користувача на вибір параметра для обчислення
        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        char calculationType = scanner.next().charAt(0);

        double loanPrincipal = 0;
        double monthlyPayment = 0;
        int numberOfPayments = 0;
        double interestRate = 0;

        // Запит користувача на введення параметрів
        if (calculationType == 'n') {
            System.out.println("Enter the loan principal:");
            loanPrincipal = scanner.nextDouble();
            System.out.println("Enter the monthly payment:");
            monthlyPayment = scanner.nextDouble();
            System.out.println("Enter the loan interest:");
            interestRate = scanner.nextDouble();
        } else if (calculationType == 'a') {
            System.out.println("Enter the loan principal:");
            loanPrincipal = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            numberOfPayments = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            interestRate = scanner.nextDouble();
        } else if (calculationType == 'p') {
            System.out.println("Enter the annuity payment:");
            monthlyPayment = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            numberOfPayments = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            interestRate = scanner.nextDouble();
        }

        // Розрахунок і вивід результату
        calculateAndPrintResult(calculationType, loanPrincipal, monthlyPayment, numberOfPayments, interestRate);

        // Закриваємо Scanner
        scanner.close();
    }

    private static void calculateAndPrintResult(char calculationType, double loanPrincipal,
                                                double monthlyPayment, int numberOfPayments, double interestRate) {
        // Розрахунок номінальної процентної ставки
        double nominalRate = interestRate / 100 / 12;

        // Розрахунок залежно від типу обчислення
        switch (calculationType) {
            case 'n':
                // Розрахунок кількості місяців
                numberOfPayments = (int) Math.ceil(Math.log(monthlyPayment / (monthlyPayment - nominalRate * loanPrincipal))
                        / Math.log(1 + nominalRate));
                break;
            case 'a':
                // Розрахунок щомісячного платежу
                monthlyPayment = loanPrincipal * (nominalRate * Math.pow(1 + nominalRate, numberOfPayments))
                        / (Math.pow(1 + nominalRate, numberOfPayments) - 1);
                break;
            case 'p':
                // Розрахунок основної суми кредиту
                loanPrincipal = monthlyPayment / ((nominalRate * Math.pow(1 + nominalRate, numberOfPayments))
                        / (Math.pow(1 + nominalRate, numberOfPayments) - 1));
                break;
        }

        // Виведення результату
        printResult(calculationType, loanPrincipal, monthlyPayment, numberOfPayments);
    }

    private static void printResult(char calculationType, double loanPrincipal, double monthlyPayment, int numberOfPayments) {
        // Виведення результату в зрозумілій формі
        switch (calculationType) {
            case 'n':
                System.out.println("It will take " + formatMonthsToYearsAndMonths(numberOfPayments) + " to repay this loan!");
                break;
            case 'a':
                System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment) + "!");
                break;
            case 'p':
                System.out.println("Your loan principal = " + (int) Math.ceil(loanPrincipal) + "!");
                break;
        }
    }

    private static String formatMonthsToYearsAndMonths(int months) {
        int years = months / 12;
        int remainingMonths = months % 12;

        if (years > 0 && remainingMonths > 0) {
            return years + " years and " + remainingMonths + " months";
        } else if (years > 0) {
            return years + " years";
        } else {
            return remainingMonths + " months";
        }
    }
}
