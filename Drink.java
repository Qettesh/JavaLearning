class Drink {
    protected String type;
    protected DrinkSize size;
    protected double basePrice;

    public Drink(String type, DrinkSize size) {
        this.type = type;
        this.size = size;
        this.basePrice = size.getPrice();   // Set base price according to initial size
    }
    public String getType() {
        return type;
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize newSize) {
        this.size = newSize;
        this.basePrice = newSize.getPrice();    //Update price when size changes
    }

    public double getPrice() {
        return basePrice;
    }
}
