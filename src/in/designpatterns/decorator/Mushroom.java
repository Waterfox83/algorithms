package in.designpatterns.decorator;

public class Mushroom extends PizzaDecorator {

    public Mushroom(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String bakePizza() {
        return super.bakePizza() + " with Mashroom Topings";
    }

    @Override
    public float getCost() {
        return super.getCost()+80;
    }
}
