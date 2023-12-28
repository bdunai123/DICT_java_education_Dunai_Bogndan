public class CreditCalculator {

    public static void main(String[] args) {
        // Вхідні дані
        double loanPrincipal = 1000; // Основна сума кредиту
        double interestRate = 0.05; // Відсоткова ставка (5%)

        // Вивід текстового повідомлення про початок розрахунків
        System.out.println("Loan principal: " + loanPrincipal);

        // Розрахунок та вивід інформації за кожен місяць
        int month = 1;
        while (loanPrincipal > 0) {
            double interest = loanPrincipal * interestRate; // Розрахунок відсотків за місяць
            double monthlyPayment = Math.min(loanPrincipal + interest, 250); // Щомісячний платіж

            // Вивід інформації за поточний місяць
            System.out.println("Month " + month + ": repaid " + monthlyPayment);

            // Оновлення залишку кредиту
            loanPrincipal -= (monthlyPayment - interest);

            // Інкремент місяця
            month++;
        }

        // Вивід повідомлення про завершення погашення кредиту
        System.out.println("The loan has been repaid!");
    }
}
