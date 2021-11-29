public class IntegerVertex {
    private int x;
    private int y;
    private int z;

    IntegerVertex(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean lessThan(IntegerVertex that) {
        if (this.x < that.getX()) {
            return true;
        } else {
            return false;
        }
    }

    public double distanceFrom(IntegerVertex that) {
        System.out.println("Finding the distance between " + this + " and " + that);
        return Math.sqrt(Math.pow(that.getX() - this.x, 2)
                + (Math.pow(that.getY() - this.y, 2))
                + (Math.pow(that.getZ() - this.z, 2)));
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ',' + z + ")";
    }
}
