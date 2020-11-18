package in.designpatterns.builder.pizzaattributes;

public enum Crust {

    THIN  {
        public float getCost(){
            return 70;
        }
    } , STUFFED{
        public float getCost(){
            return 90;
        }
    };

    public abstract float getCost();
}
