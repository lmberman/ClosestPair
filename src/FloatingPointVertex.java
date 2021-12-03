public class FloatingPointVertex {
    private float x;
    private float y;

    FloatingPointVertex(float x, float y) {
        this.x = x;
        this.y = y;
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

    public boolean lessThan(FloatingPointVertex that) {
        if (this.x < that.getX()) {
            return true;
        } else {
            return false;
        }
    }

    public double distanceFrom(FloatingPointVertex that) {
        //System.out.println("Finding the distance between " + this + " and " + that);
        return Math.sqrt(Math.pow(that.getX() - this.x, 2)
                + (Math.pow(that.getY() - this.y, 2)));
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ")";
    }
}
