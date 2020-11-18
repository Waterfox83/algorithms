package in.designpatterns.decorator;

public class BasePizza implements Pizza{

    public String bakePizza() {
        return "Basic Pizza";
    }
    public float getCost(){
        return 100;
    }
}

