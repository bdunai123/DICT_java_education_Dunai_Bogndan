import java.util.Scanner;

public class CoffeeMachine {

    private static int waterAvailable = 400;
    private static int milkAvailable = 540;
    private static int coffeeBeansAvailable = 120;
    private static int disposableCups = 9;
    private static int moneyEarned = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMachineStatus();

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                buyCoffee(scanner);
                break;
            case "fill":
                fillMachine(scanner);
                break;
            case "take":
                takeMoney();
                break;
            default:
                System.out.println("Invalid action. Please choose buy, fill, or take.");
        }

        printMachineStatus();

        scanner.close();
    }

    private static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffeeType = scanner.nextInt();

        switch (coffeeType) {
            case 1:
                makeCoffee(250, 0, 16, 4);
                break;
            case 2:
                makeCoffee(350, 75, 20, 7);
                break;
            case 3:
                makeCoffee(200, 100, 12, 6);
                break;
            default:
                System.out.println("Invalid coffee type.");
        }
    }

    private static void makeCoffee(int water, int milk, int coffeeBeans, int cost) {
        if (waterAvailable >= water && milkAvailable >= milk && coffeeBeansAvailable >= coffeeBeans && disposableCups > 0) {
            System.out.println("I have enough resources, making coffee!");
            waterAvailable -= water;
            milkAvailable -= milk;
            coffeeBeansAvailable -= coffeeBeans;
            disposableCups--;
            moneyEarned += cost;
        } else {
            System.out.println("Sorry, not enough resources to make coffee.");
        }
    }

    private static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        waterAvailable += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkAvailable += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansAvailable += scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        disposableCups += scanner.nextInt();
    }

    private static void takeMoney() {
        System.out.println("I gave you " + moneyEarned);
        moneyEarned = 0;
    }

    private static void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(waterAvailable + " of water");
        System.out.println(milkAvailable + " of milk");
        System.out.println(coffeeBeansAvailable + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(moneyEarned + " of money");
    }
}
