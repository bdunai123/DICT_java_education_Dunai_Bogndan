import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("Type \"n\" for the number of monthly payments,");
        System.out.println("Type \"a\" for annuity monthly payment amount,");
        System.out.println("Type \"p\" for loan principal:");

        String calculationType = scanner.next();

        double principal = 0, payment = 0, interest = 0;
        int periods = 0;

        switch (calculationType) {
            case "n":
                System.out.println("Enter the loan principal:");
                principal = scanner.nextDouble();
                System.out.println("Enter the monthly payment:");
                payment = scanner.nextDouble();
                System.out.println("Enter the loan interest:");
                interest = scanner.nextDouble() / 100 / 12;
                periods = calculateNumberOfPayments(principal, payment, interest);
                break;

            case "a":
                System.out.println("Enter the loan principal:");
                principal = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                periods = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                interest = scanner.nextDouble() / 100 / 12;
                payment = calculateAnnuityPayment(principal, periods, interest);
                break;

            case "p":
                System.out.println("Enter the annuity payment:");
                payment = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                periods = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                interest = scanner.nextDouble() / 100 / 12;
                principal = calculateLoanPrincipal(payment, periods, interest);
                break;

            default:
                System.out.println("Incorrect calculation type");
                return;
        }

        System.out.println(getResultMessage(calculationType, principal, payment, periods, interest));
    }

    private static int calculateNumberOfPayments(double principal, double payment, double interest) {
        return (int) Math.ceil(Math.log(payment / (payment - interest * principal)) / Math.log(1 + interest));
    }

    private static double calculateAnnuityPayment(double principal, int periods, double interest) {
        return principal * interest * Math.pow(1 + interest, periods) / (Math.pow(1 + interest, periods) - 1);
    }

    private static double calculateLoanPrincipal(double payment, int periods, double interest) {
        return payment / (interest * Math.pow(1 + interest, periods) / (Math.pow(1 + interest, periods) - 1));
    }

    private static String getResultMessage(String type, double principal, double payment, int periods, double interest) {
        switch (type) {
            case "n":
                return String.format("It will take %d years and %d months to repay this loan!", periods / 12, periods % 12);

            case "a":
                return String.format("Your monthly payment = %.0f!", payment);

            case "p":
                return String.format("Your loan principal = %.0f!", principal);

            default:
                return "Incorrect calculation type";
        }
    }
}
