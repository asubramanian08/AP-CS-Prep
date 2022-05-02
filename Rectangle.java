public class Rectangle {
    private int width, height;

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public Rectangle(int side) {
        this(side, side);
    }

    public Rectangle() {
        this(1);
    }

    public String toString() {
        return String.valueOf(width) + "x" + String.valueOf(height) + " Rectangle";
    }

    public boolean isSquare() {
        return width == height;
    }

    public void quardasize() {
        int rectArea = width * height;
        int floorSqrt = (int) Math.sqrt(rectArea);
        int ceilSqrt = floorSqrt + 1;
        if (rectArea - floorSqrt * floorSqrt < ceilSqrt * ceilSqrt - rectArea)
            width = height = floorSqrt;
        else
            width = height = ceilSqrt;
    }
}