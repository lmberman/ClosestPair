public class IntegerVertex {
    private int x;
    private int y;

    IntegerVertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean lessThan(IntegerVertex that) {
        if (this.x < that.getX()) {
            return true;
        } else {
            return false;
        }
    }

    public double distanceFrom(IntegerVertex that) {
        //System.out.println("Finding the distance between " + this + " and " + that);
        return Math.sqrt(Math.pow(that.getX() - this.x, 2)
                + (Math.pow(that.getY() - this.y, 2)));
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ")";
    }
}
