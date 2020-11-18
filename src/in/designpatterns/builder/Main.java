package in.designpatterns.builder;

import in.designpatterns.builder.pizzaattributes.Crust;
import in.designpatterns.builder.pizzaattributes.Size;
import in.designpatterns.builder.pizzaattributes.Topping;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder().
                withCrust(Crust.THIN).
                withTopping(Topping.CHICKEN).
                withSize(Size.LARGE).build();
        System.out.println(pizza.getTopping()); //Topping.CHICKEN
        System.out.println(pizza.getSize());//Size.LARGE
        System.out.println(pizza.getCrust());//Crust.THIN
        System.out.println(pizza.getTotalPrice());//265.0
    }
}
