package in.algo.designpatterns.builder.pizzaattributes;

public enum Size {
    MEDIUM {
        public float getCost() {
            return 100;
        }
    }, LARGE {
        public float getCost() {
            return 160;
        }
    };

    public abstract float getCost();
}