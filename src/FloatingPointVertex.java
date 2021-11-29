public class FloatingPointVertex {
    private float x;
    private float y;
    private float z;

    FloatingPointVertex(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public boolean lessThan(FloatingPointVertex that) {
        if (this.x < that.getX()) {
            return true;
        } else {
            return false;
        }
    }

    public double distanceFrom(FloatingPointVertex that) {
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
