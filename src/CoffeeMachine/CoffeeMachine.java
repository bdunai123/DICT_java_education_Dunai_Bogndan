import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvailable = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvailable = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansAvailable = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        makeCoffee(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsNeeded);

        scanner.close();
    }

    public static void makeCoffee(int waterAvailable, int milkAvailable, int coffeeBeansAvailable, int cupsNeeded) {
        int waterForOneCup = 200;
        int milkForOneCup = 50;
        int coffeeBeansForOneCup = 15;

        int maxCupsWater = waterAvailable / waterForOneCup;
        int maxCupsMilk = milkAvailable / milkForOneCup;
        int maxCupsBeans = coffeeBeansAvailable / coffeeBeansForOneCup;

        int possibleCups = Math.min(maxCupsWater, Math.min(maxCupsMilk, maxCupsBeans));

        if (cupsNeeded == 0 || (cupsNeeded <= possibleCups && cupsNeeded > 0)) {
            System.out.println("Yes, I can make that amount of coffee"
                    + (possibleCups > cupsNeeded ? " (and even " + (possibleCups - cupsNeeded) + " more than that)" : ""));
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }
    }
}
