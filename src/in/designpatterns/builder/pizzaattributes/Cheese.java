package in.designpatterns.builder.pizzaattributes;

public enum Cheese {
    AMERICAN {
        public float getCost() {
            return 40;
        }
    }, ITALIAN {
        public float getCost() {
            return 60;
        }
    };

    public abstract float getCost();

}
