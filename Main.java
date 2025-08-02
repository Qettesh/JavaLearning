import java.util.*;

public class Main{
    public static void main(String[] args) {
        //Create a default meal
        System.out.println("-----Default Meal Order-----");
        MealOrder defaultMeal = new MealOrder();
        defaultMeal.PrintItemizedlist();
        System.out.println("Total Due: $" + String.format("%.2f" , defaultMeal.calculateTotalDue()));

        //Create a custom meal with user input
        System.out.println("\n-----Custom Meal Order (User Iput)-----");
        Scanner input = new Scanner(System.in); //Create a sanner object for user input

        //Get burger type and price
        System.out.println("\n------Custom Meal Order (User Input)-----");
        Scanner input2 = new Scanner(System.in); // Create a scanner object for user input

        //Get burger type and price
        System.out.print("Enter custom burger name (e.g., Cheeseburger): ");
        String burgerName = input.nextLine(); // Read the entire line for the burger name

        double burgerPrice = 0.0;
        boolean validInput = false;
        while (!validInput){
            System.out.print("Enter custom burger price: $");
            try{
                burgerPrice = input.nextDouble(); //Read the pruce as a double
                validInput = true;
            } catch (InputMismatchException e){
                System.out.println("Invalid input....Please enter a valid number for a burger price...");
                input.next(); //Consume the invalid input to prevent an infinite loop
            }
        }

        //Get topping choices (up to three for a regular burger)
        int numToppings = 0;
        validInput = false; //Reset for topping count
        while (!validInput){
            System.out.print("Enter number of toppings (up to 3): ");
            try{
                numToppings = input.nextInt(); //Read the number of toppings as an integer
                if (numToppings >= 0 && numToppings <= 3){
                    validInput = true;
                }  else {
                    System.out.println("Invalid input....Please enter a valid number for a toppings...");
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter a valid whole number for toppings.");
                input.next(); //Consume the invalid input
            }
        }
        input.nextLine(); // Consume the remaining newline character after nextInt()

        Burger customBurger = new Burger(burgerName, burgerPrice, numToppings); //Create the burger object

        for (int i = 0; i < numToppings; i++){
            System.out.print("Enter topping amount" + (i + 1) + "(CHEESE, LETTUCE, TOMATO, PICKLES, BACON, ONION):");
            String toppingAmount = input.nextLine().toUpperCase(); //Convert to uppercase for enum matching

            try{
                Topping topping = Topping.valueOf(toppingAmount); //Convert string to Topping enum
                customBurger.addTopping(topping);
            } catch (IllegalArgumentException e){
                System.out.println("Invalid topping:" + toppingAmount + "Please choose from the available options.");
                i--; //Decrement to allow the user to re-enter a valid topping
            }
        }

        //Get drink and side choices (similar input handling applied here)
        System.out.print("Enter custom drink name (e.g., Lemonade):");
        String drinkName = input.nextLine(); //Read the entire line for the drink name

        System.out.print("ENter drink size (SMALL, MEDIUM, LARGE):");
        String drinkSizeInput = input.nextLine().toUpperCase();

        DrinkSize customDrinkSize;
        try{
            customDrinkSize = DrinkSize.valueOf(drinkSizeInput);
        } catch (IllegalArgumentException e){
            System.out.println("Invalid drink size, defaulting to MEDIUM...");
            customDrinkSize = DrinkSize.MEDIUM;
        }

        System.out.println("ENter custom size name (e.g., Fries): ");
        String sideName = input.nextLine(); //Read the entire line for the side item

        double sidePrice = 0.0;
        validInput = false; //Reset for side price

        while(!validInput){
            System.out.println("Enter custom side item price: $");
            try{
                sidePrice = input.nextDouble(); //Read the price as a double
                validInput = true;
            } catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter a valid number for the price.");
                input.next(); //Consume the invalid input
            }
        }

        input.nextLine(); //Consume the remaining newline character after nextDouble()

        Drink customDrink = new Drink(drinkName, customDrinkSize);
        SideItem customSide = new SideItem(sideName, sidePrice);
        MealOrder customMeal = new MealOrder(customBurger, customDrink, customSide);
        customMeal.PrintItemizedlist();
        System.out.println("Total Due: $" + String.format("%.2f", customMeal.calculateTotalDue()));

        //Change drink size for custom meal
        System.out.println("\n-----Change drink size for Custom Meal Order------");
        System.out.print("Enter new drink size (SMALL, MEDIUM, LARGE):");
        String newDrinkSizeInput = input.nextLine().toUpperCase();
        DrinkSize newCustomDrinkSize;
        try{
            newCustomDrinkSize = DrinkSize.valueOf(newDrinkSizeInput);
            customMeal.changeDrinkSize(newCustomDrinkSize);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid drink size, keeping the current size. ");
        }

        customMeal.PrintItemizedlist();
        System.out.println("Total Due: $" + String.format("%.2f", customMeal.calculateTotalDue()));

        //Create a deluxe burger meal
        System.out.println("\n-----Deluxe Meal Order-----");
        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addTopping(Topping.CHEESE);//Toppings do not change the price
        deluxeBurger.addTopping(Topping.LETTUCE);
        deluxeBurger.addTopping(Topping.PICKLES);
        deluxeBurger.addTopping(Topping.BACON);
        deluxeBurger.addTopping(Topping.TOMATO);
        deluxeBurger.addTopping(Topping.ONION);//6 toppings to choose but only 5 are allowed

        Drink deluxeDrink = new Drink("Lemonade", DrinkSize.LARGE);
        SideItem deluxeSide = new SideItem("Salad", 2.75);
        MealOrder deluxeMeal = new MealOrder(deluxeBurger, deluxeDrink, deluxeSide);

        deluxeMeal.PrintItemizedlist();
        System.out.println("Total: $" + String.format("%.2f", deluxeMeal.calculateTotalDue()));

        input.close(); //Close the scanner when finished...
    }
}
