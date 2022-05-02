public class DiplomaWithHonor extends Diploma {
    public DiplomaWithHonor(String name, String course) {
        super(name, course);
    }

    public String toString() {
        return super.toString() + "\n*** with honors ***";
    }
}