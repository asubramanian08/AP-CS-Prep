public class Disk {
    private Point center;
    private double radius;

    public Disk(Disk d) {
        this.center = new Point(center);
        this.radius = d.radius;
    }
}