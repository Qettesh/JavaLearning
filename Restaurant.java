import java.util.*;
public class Restaurant {
    //Enum for topping types and their prices
    enum Topping {
        LETTUCE("Lettuce", 0.50),
        TOMATO("Tomato", 0.75),
        ONION("onion", 0.40),
        PICKLES("Pickles", 0.25),
        CHEESE("Cheese", 0.85),
        BACON("Bacon", 1.25);

        private String name;
        private double price;

        Topping(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return this.name;
        }

        public double getPrice() {
            return this.price;
        }
    }

    //Enum for drink sizes and their prices
    enum DrinkSize {
        SMALL("Small", 1.25),
        MEDIUM("Medium", 1.65),
        LARGE("Large", 1.85);

        private String size;
        private double price;

        DrinkSize(String size, double price) {
            this.size = size;
            this.price = price;
        }

        public String getSize() {
            return size;
        }

        public String getName() {
            return this.size;
        }

        public double getPrice() {
            return this.price;
        }
    }
}
