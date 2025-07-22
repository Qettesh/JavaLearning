import java.util.*;
class Burger extends Restaurant{
    private String type;
    private double basePrice;
    private List<Topping> toppings;
    private int maxToppings;

    public Burger(String type, double basePrice, int maxToppings) {
        this.type = type;
        this.basePrice = basePrice;
        this.toppings = new ArrayList<>();
        this.maxToppings = maxToppings;
    }

    public String getType() {
        return type;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void addTopping(Topping topping){
        if (toppings.size() < maxToppings) {
            toppings.add(topping);
            System.out.println("Adding " + topping.getName() + " to " + type + " burger.");
        } else {
            System.out.println("You have added the maximum amount of topings for  " + type + " burger.");
        }
    }

    public double getToppingsPrice(){
        double toppingsPrice = 0;
        for(Topping topping : toppings){
            toppingsPrice += topping.getPrice();
        }
        return toppingsPrice;
    }

    public List<Topping> getToppings(){
        return toppings;
    }

    public double calculateBurgerPrice(){
        return basePrice + getToppingsPrice();
    }
}
