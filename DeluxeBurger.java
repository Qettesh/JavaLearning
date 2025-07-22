class DeluxeBurger extends Burger{
    public DeluxeBurger() {
        super("Deluxe Burger", 10.00, 5); //Deluxe burger with a set price and 5 topping slots
    }

    /**
     * @return
     */
    @Override
    public double calculateBurgerPrice() {
        return getBasePrice();  //Toppings are included in the set price for deluxe burgers.
    }
}
