package in.designpatterns.builder;

import in.designpatterns.builder.pizzaattributes.Cheese;
import in.designpatterns.builder.pizzaattributes.Crust;
import in.designpatterns.builder.pizzaattributes.Size;
import in.designpatterns.builder.pizzaattributes.Topping;

public class Pizza {

    private float totalPrice = 0;

    private Size size;
    private Topping topping;
    private Crust crust;
    private Cheese cheese;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void addToPrice(float price) {
        this.totalPrice = totalPrice + price;
    }
}
