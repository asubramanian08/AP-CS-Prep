package Unit2Review;

public class Diploma {
    private String name, course;

    public Diploma(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return "This certifies that " + name + "\nhas completed a course in " + course;
    }

    public static void main() {
        Diploma d1 = new Diploma("Murray Smith", "Gardening");
        System.out.println(d1);
        System.out.println();
        Diploma d2 = new DiplomaWithHonor("Lisa Smith", "Evolutionary Psychology");
        System.out.println(d2);
        System.out.println();
    }
}