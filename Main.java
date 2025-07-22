import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create a default meal
        System.out.println("---Default Meal Order---");
        MealOrder defaultMeal = new MealOrder();
        defaultMeal.PrintItemizedList();
        System.out.println("Total Due: $" + String.format("%.2f", defaultMeal.calculateTotalDue()));

        //Create a custom meal with 3 toppings
        System.out.println("\n----Custom Meal Order---");
        Burger customBurger = new Burger("Cheeseburger", 5.50, 3);
        customBurger.addTopping(Topping.CHEESE);
        customBurger.addTopping(Topping.LETTUCE);
        customBurger.addTopping(Topping.TOMATO);
        Drink customDrink = new Drink("Lemonade", DrinkSize.MEDIUM);
        SideItem customSide = new SideItem("Onion Rings", 2.75);
        MealOrder customMeal = new MealOrder(customBurger, customDrink, customSide);
        customMeal.PrintItemizedList();

        //Change drink size for custom meal
        System.out.println("\n----Change drink size for Custom Meal Order---");
        customMeal.changeDrinkSize(DrinkSize.LARGE);
        customMeal.PrintItemizedList();
        System.out.println("Total Due: $" + String.format("%.2f", customMeal.calculateTotalDue()));

        //Create a deluxe burger meal
        System.out.println("\n-----Deluxe Meal Order---");
        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addTopping(Topping.CHEESE); //Toppings don't change the price
        deluxeBurger.addTopping(Topping.BACON);
        deluxeBurger.addTopping(Topping.LETTUCE);
        deluxeBurger.addTopping(Topping.TOMATO);
        deluxeBurger.addTopping(Topping.PICKLES);    //5 toppings added
        deluxeBurger.addTopping(Topping.CHEESE); //This topping wwill not be added since it exceeds the limit
        Drink deluxeDrink = new Drink("Lemonade", DrinkSize.LARGE);
        SideItem deluxeSide = new SideItem("Salad", 3.75);
        MealOrder deluxeMeal = new MealOrder(deluxeBurger, deluxeDrink, deluxeSide);
        deluxeMeal.PrintItemizedList();
        System.out.println("Total: $" + String.format("%.2f", deluxeMeal.calculateTotalDue()));
    }
}