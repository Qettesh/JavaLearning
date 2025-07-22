public enum Topping {
    //Enum for topping types and their prices

        LETTUCE("Lettuce", 0.50),
        TOMATO("Tomato", 0.75),
        ONION("onion", 0.40),
        PICKLES("Pickles", 0.25),
        CHEESE("Cheese", 0.85),
        BACON("Bacon", 1.25);

        protected String name;
        protected double price;

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
