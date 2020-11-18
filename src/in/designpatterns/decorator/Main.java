package in.designpatterns.decorator;

public class Main {
    public static void main(String args[]){
        Pizza pizza = new Pepperoni(new BasePizza());
        System.out.println(pizza.bakePizza());
        System.out.println(pizza.getCost());
    }
}
