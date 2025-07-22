class MealOrder extends Restaurant{
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public MealOrder(Burger burger, Drink drink, SideItem sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    //Default constructor for the most common meal order

    public MealOrder() {
        this.burger = new Burger("Regular Burger", 5.00, 3);
        this.drink = new Drink("Lemonade", DrinkSize.SMALL);
        this.sideItem = new SideItem("Fries", 1.50);
    }

    public Burger getBurger() {
        return burger;
    }

    public Drink getDrink() {
        return drink;
    }

    public SideItem getSideItem() {
        return sideItem;
    }

    public void addBurgerTopping(Topping topping){
        burger.addTopping(topping);
    }

    public void changeDrinkSize(DrinkSize newSize){
        drink.setSize(newSize);
    }

    public void PrintItemizedList(){
        System.out.println("\n---- Itemized Order ----");
        System.out.println("Burger: " + burger.getType() + " - $" + String.format("%.2f", burger.getBasePrice()));
        for (Topping topping : burger.getToppings()) {
            System.out.println(" + " + topping.getName() + " - $" + String.format("%.2f", topping.getPrice()));
        }
        System.out.println("Drink:  " + drink.getType() + " (" + drink.getSize().getSize() + ") - $" + String.format("%.2f", drink.getPrice()));
        System.out.println("Side: " + sideItem.getType() + " - $" + String.format("%.2f", sideItem.getPrice()));
    }

    public double calculateTotalDue() {
        double total = burger.calculateBurgerPrice() + drink.getPrice() + sideItem.getPrice();
        return total;
    }
}
