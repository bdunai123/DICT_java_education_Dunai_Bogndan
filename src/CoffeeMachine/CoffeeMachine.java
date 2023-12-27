import java.util.Scanner;

class CoffeeMachine {
    private int waterAvailable;
    private int milkAvailable;
    private int coffeeBeansAvailable;
    private int disposableCups;
    private int moneyEarned;

    public CoffeeMachine() {
        this.waterAvailable = 400;
        this.milkAvailable = 540;
        this.coffeeBeansAvailable = 120;
        this.disposableCups = 9;
        this.moneyEarned = 550;
    }

    public void processUserInput(String userInput) {
        switch (userInput) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printMachineStatus();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid action. Please choose buy, fill, take, remaining, or exit.");
        }
    }

    private void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        String coffeeType = scanner.nextLine();

        switch (coffeeType) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid coffee type.");
        }
    }

    private void makeCoffee(int water, int milk, int coffeeBeans, int cost) {
        if (waterAvailable >= water && milkAvailable >= milk && coffeeBeansAvailable >= coffeeBeans && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            waterAvailable -= water;
            milkAvailable -= milk;
            coffeeBeansAvailable -= coffeeBeans;
            disposableCups--;
            moneyEarned += cost;
        } else {
            System.out.println("Sorry, not enough resources to make coffee.");
        }
    }

    private void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        waterAvailable += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkAvailable += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansAvailable += scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        disposableCups += scanner.nextInt();
    }

    private void takeMoney() {
        System.out.println("I gave you " + moneyEarned);
        moneyEarned = 0;
    }

    private void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(waterAvailable + " of water");
        System.out.println(milkAvailable + " of milk");
        System.out.println(coffeeBeansAvailable + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(moneyEarned + " of money");
    }
}

class CoffeeMachineSimulator {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            coffeeMachine.processUserInput(action);
        }
    }
}

// Rest of the CoffeeMachine class remains the same

