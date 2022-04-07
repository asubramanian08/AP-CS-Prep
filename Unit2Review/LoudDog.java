package Unit2Review;

public class LoudDog extends Dog {
    public LoudDog(String name) {
        super(name);
    }

    public String speak() {
        return super.speak() + ' ' + super.speak();
    }
}