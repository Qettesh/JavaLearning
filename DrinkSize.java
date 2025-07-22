public enum DrinkSize {
    //Enum for drink sizes and their prices

        SMALL("Small", 1.25),
        MEDIUM("Medium", 1.65),
        LARGE("Large", 1.85);

        protected DrinkSize size;
        protected double price;

        DrinkSize(DrinkSize size, double price) {
            this.size = size;
            this.price = price;
        }

    DrinkSize(String small, double v) {
    }

    public DrinkSize getSize() {
            return size;
        }

        public DrinkSize getName() {
            return this.size;
        }

        public double getPrice() {
            return this.price;
        }

}
