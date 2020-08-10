package machine;
import java.util.Scanner;

public class CoffeeMachine {
    Scanner scanner;
    int[] resourcesArray;

    public CoffeeMachine() {
        scanner = new Scanner(System.in);
        resourcesArray = new int[]{400, 540, 120, 9, 550};
    }

    public void coffeeMethod(String userChoice) {
        //System.out.println("inside mathod");
        States state = States.valueOf(userChoice.toUpperCase());
        switch (state) {

            case BUY:
                //case "back":
                System.out.println("what do you want to buy? 1- espresso, 2 - latte, 3 - cappuccino:");
                String coffeeType = scanner.next();
                switch (coffeeType) {
                    case "1":
                        //make(250, 0, 16, 4, resourcesArray);
                        System.out.println(make(CoffeeType.espresso, resourcesArray));
                        break;
                    case "2":
                        //make(350, 75, 20, 7, resourcesArray);
                        System.out.println(make(CoffeeType.latte, resourcesArray));
                        break;
                    case "3":
                        //make(200, 100, 12, 6, resourcesArray);
                        System.out.println(make(CoffeeType.cappuccino, resourcesArray));
                        break;
                    default:
                        //continue;
                        break;
                }
                break;
            case FILL:
                fill(scanner, resourcesArray);
                break;
            case REMAINING:
                printStatus(resourcesArray);
                break;
            case TAKE:
                System.out.println("I gave you $" + resourcesArray[4]);
                resourcesArray[4] = 0;
                break;
            case EXIT:
                // exit =true;
                break;

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit) :");
            String userChoice = scanner.next();
            System.out.println((userChoice.equals("exit")));
            if (!userChoice.equals("exit")) {
                coffeeMachine.coffeeMethod(userChoice);
            } else
                exit = true;
            System.out.println();
        }
    }

    private static String make(CoffeeType coffeeType, int[] resourcesArray) {
        int resource = coffeeType.getWater();
        if (resourcesArray[0] >= resource) {
            resourcesArray[0] -= resource;
        } else {
            return ("Sorry, not enough water");
        }
        resource = coffeeType.getMilk();
        if (resourcesArray[1] >= resource) {
            resourcesArray[1] -= resource;
        } else {
            return ("Sorry, not enough milk");
        }
        resource = coffeeType.getBeans();
        if (resourcesArray[2] >= resource) {
            resourcesArray[2] -= resource;
        } else {
            return ("Sorry, not enough beans");
        }
        if (resourcesArray[3] >= 1) {
            resourcesArray[3]--;
        } else {
            return ("Sorry, not enough cups");
        }
        resourcesArray[4] += coffeeType.getMoney();
        return "I have enough resources, making you a coffee";
    }


    private static void printStatus(int[] resourcesArray) {
        System.out.println("The coffee machine has: ");
        System.out.println(resourcesArray[0] + " of water");
        System.out.println(resourcesArray[1] + " of milk");
        System.out.println(resourcesArray[2] + " of coffee beans");
        System.out.println(resourcesArray[3] + " of disposable cups");
        System.out.println("$" + resourcesArray[4] + " of money");
        //System.out.println();
    }

    private static void fill(Scanner scanner, int[] resourcesArray) {
        System.out.println("Write how many ml of water do you want to add:");
        resourcesArray[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        resourcesArray[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        resourcesArray[2] += scanner.nextInt();
        System.out.println(" Write how many disposable cups of coffee do you want to add:");
        resourcesArray[3] += scanner.nextInt();
    }

    private static int howManyCoffeesCanMake(int requiredWater, int requiredMilk, int requiredCoffeeBeans) {
        int cupsOfCoffee = 0;
        while (true) {
            if (requiredWater >= 200 && requiredMilk >= 50 && requiredCoffeeBeans >= 15) {
                cupsOfCoffee++;
                requiredWater -= 200;
                requiredMilk -= 50;
                requiredCoffeeBeans -= 15;
                continue;
            }
            return cupsOfCoffee;
        }
    }


}
