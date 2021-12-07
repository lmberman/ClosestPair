import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Representation and storage of Vertices that exist on the Linear Plane within view.
 * Each Vertex in the Map represents an object existing on the map along a 2D space (x,y)
 * <p>
 * It stores two representations of the vertices used for data structure and algorithm runtime comparisons.
 * One representation is of floating point vertices while the other is of integer vertices.
 **/
public class Map {
    private int size;
    private int comparisonCount;
    private ArrayList<FloatingPointVertex> floatingPointVerticesX;
    private ArrayList<IntegerVertex> integerVerticesX;
    private ArrayList<FloatingPointVertex> floatingPointVerticesY;
    private ArrayList<IntegerVertex> integerVerticesY;
    private ArrayList<FloatingPointVertex> floatingPointStrip;
    private ArrayList<IntegerVertex> integerStrip;

    /**
     * create a new map with randomized points in the 2D space
     * vertices list will then have a size of number of elements
     * and sort the list along the x axis
     *
     * @param numberOfElements size of vertices list
     */
    Map(int numberOfElements, char type) {
        comparisonCount = 0;
        size = numberOfElements;
        floatingPointVerticesX = new ArrayList<>();
        integerVerticesX = new ArrayList<>();
        floatingPointVerticesY = new ArrayList<>();
        integerVerticesY = new ArrayList<>();
        floatingPointStrip = new ArrayList<>();
        integerStrip = new ArrayList<>();
        Random rand = new Random();
        switch (type) {
            case 'F':
            case 'f':
                for (int i = 1; i <= numberOfElements; i++) {
                    floatingPointVerticesX.add(new FloatingPointVertex(rand.nextFloat(), rand.nextFloat()));
                    floatingPointVerticesY.add(floatingPointVerticesX.get(i-1));
                }
                break;
            case 'I':
            case 'i':
                for (int i = 1; i <= numberOfElements; i++) {
                    integerVerticesX.add(new IntegerVertex(rand.nextInt(10), rand.nextInt(10)));
                    integerVerticesY.add(integerVerticesX.get(i-1));
                }
                break;
            default:
                break;
        }
        // Sort the Map along the x axis
        sortAlongXAxis();
        sortAlongYAxis();
        //printAllElements();
    }

    /**
     * Sort the vertices along the x axis using built in array list mergesort
     */
    public void sortAlongXAxis() {
        if (floatingPointVerticesX.isEmpty()) {
            integerVerticesX.sort(Comparator.comparing(IntegerVertex::getX));
        } else {
            floatingPointVerticesX.sort(Comparator.comparing(FloatingPointVertex::getX));
        }
        // System.out.println("Elements Sorted:");
        //printAllElements();
    }

    public void sortAlongYAxis() {
        if (floatingPointVerticesY.isEmpty()) {
            integerVerticesY.sort(Comparator.comparing(IntegerVertex::getY));
        } else {
            floatingPointVerticesY.sort(Comparator.comparing(FloatingPointVertex::getY));
        }
    }

    public void printAllElements() {
        printElements(0, size);
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSize() {
        return size;
    }

    public void printElements(int start, int end) {
        System.out.print("S = {");
        for (int i = start; i < end; i++) {
            System.out.print(floatingPointVerticesX.isEmpty() ? integerVerticesX.get(i) : floatingPointVerticesX.get(i));
            if (i + 1 != end) {
                System.out.print(',');
            }
        }
        System.out.println('}');
    }

    /**
     * Find the smallest distance amongst all elements of the map using the brute force method O(n^2) if start and end are 0 and the length of the map
     *
     * @param start the starting index for the comparison
     * @param end   the end index for the comparison
     * @return smallest distance between the points within the vertex range
     */
    public double findMinimumDistanceBrute(int start, int end) {
        double smallestDistance = 1000;
        for (int i = start; i < end; i++) {
            for (int j = start+1; j < end; j++) {
                if (i != j) {
                    double distance;
                    if (floatingPointVerticesX.isEmpty()) {
                        distance = integerVerticesX.get(i).distanceFrom(integerVerticesX.get(j));
                    } else {
                        distance = floatingPointVerticesX.get(i).distanceFrom(floatingPointVerticesX.get(j));
                    }
                    //System.out.println("Found Distance: " + distance);
                    comparisonCount++;
                    if (distance < smallestDistance) {
                        smallestDistance = distance;
                    }
                }
            }
        }
        return smallestDistance;
    }

    /**
     * A utility function to find the
     * distance between the closest points of
     * strip of given size. All points in
     * strip[] are sorted according to
     * y coordinate. They all have an upper
     * bound on minimum distance as d.
     * Note that this method seems to be
     * a O(n^2) method, but it's a O(n)
     * method as the inner loop runs at most 6 times
     **/
    private double stripClosestFloatingPoint(double d) {
        double min = d; // Initialize the minimum distance as d

        // sort along the Y axis
        floatingPointStrip.sort(Comparator.comparing(FloatingPointVertex::getY));

        // Pick all points one by one and try the next points till the difference
        // between y coordinates is smaller than d.
        // This is a proven fact that this loop runs at most 6 times
        for (int i = 0; i < floatingPointStrip.size(); ++i) {
            for (int j = i + 1; (j < floatingPointStrip.size() &&
                    (floatingPointStrip.get(j).getY() - floatingPointStrip.get(i).getY()) < min); j++) {
                if (floatingPointStrip.get(i).distanceFrom(floatingPointStrip.get(j)) < min) {
                    comparisonCount++;
                    min = floatingPointStrip.get(i).distanceFrom(floatingPointStrip.get(j));
                }

            }
        }

        return min;
    }

    private double stripClosestIntegerPoint(double d) {
        double min = d; // Initialize the minimum distance as d

        // Pick all points one by one and try the next points till the difference
        // between y coordinates is smaller than d.
        // This is a proven fact that this loop runs at most 6 times
        for (int i = 0; i < integerStrip.size(); ++i) {
            for (int j = i + 1; (j < integerStrip.size() &&
                    (integerStrip.get(j).getY() - integerStrip.get(i).getY()) < min); j++) {
                if (integerStrip.get(i).distanceFrom(integerStrip.get(j)) < min) {
                    comparisonCount++;
                    min = integerStrip.get(i).distanceFrom(integerStrip.get(j));
                }

            }
        }

        return min;
    }

    /**
     * Build Integer Strip of all points within the provided distance of the midPointX along the x axis
     *
     * @param midPointX the x coordinate of the mid point
     * @param distance  the provided distance
     */
    private void buildIntegerStrip(int midPointX, double distance) {
        integerStrip = new ArrayList<>();
        for (IntegerVertex vertex : integerVerticesY) {
            if (vertex.getX() >= (midPointX - (int)distance) && vertex.getX() <= (midPointX + (int)distance))
                integerStrip.add(vertex);
        }
    }

    /**
     * Build Floating Point Strip of all points within the provided distance of the midPointX along the x axis
     *
     * @param midPointX the x coordinate of the mid point
     * @param distance  the provided distance
     */
    private void buildFloatingPointStrip(float midPointX, double distance) {
        floatingPointStrip = new ArrayList<>();
        for (FloatingPointVertex vertex : floatingPointVerticesY) {
            if (vertex.getX() >= (float)(midPointX - distance) && vertex.getX() <= (float)(midPointX + distance)) {
                floatingPointStrip.add(vertex);
            }
        }
    }

    /**
     * Finds the smallest distance between the points within the map using the recursive function
     * for the entire array
     *
     * @return smallest distance between points
     */
    public double findMinimumDistance() {
        return findMinimumDistanceRecursive(0, size);
    }

    /**
     * Splits array in equal parts (n/2) based on the start and end values provided
     * Distance between each neighboring elements in their sections (powers of 2) are then found and compared with the smallest distance of other pairs
     * The minimum distance is then returned for the final answer of minimum distance between groups
     *
     * @param start beginning of array/ sub_array
     * @param end   end of array/sub_array
     * @return minimum distance within the array/sub_array
     */
    public double findMinimumDistanceRecursive(int start, int end) {
        //System.out.println("Finding the Minimum Distance between elements at index " + start + " and index " + end);
//        printElements(start, end);
        // recursive function divide array and sub-arrays in half until no more than 3 elements remain
        // check distance between neighboring points and get the min value
        if (end - start <= 3) {
            //System.out.println("List has a size of 3 elements or less Using Brute Force Approach to find smallest distance");
            // compare the remaining 2,3 elements and return smallest distance
            return findMinimumDistanceBrute(start, end);
        }
        int mid = (start + end) / 2;
        //System.out.println("To The Left");
        double leftDistance = findMinimumDistanceRecursive(start, mid);
        //System.out.print("SdL: " + leftDistance);
        //System.out.println("To The Right");
        double rightDistance = findMinimumDistanceRecursive(mid, end);
        double minSubDistance = Math.min(leftDistance,rightDistance);
        comparisonCount++;
        // Build an array strip that contains points closer than minDistance to lin
        //System.out.print("SdR distance:" + rightDistance);
        // return the smallest of the two
        // need to get the points for these smallest values
        double stripMinDistance;
        if (floatingPointVerticesX.isEmpty()) {
            buildIntegerStrip(integerVerticesX.get(mid).getX(), minSubDistance);
            stripMinDistance = stripClosestIntegerPoint(minSubDistance);
        } else {
            buildFloatingPointStrip(floatingPointVerticesX.get(mid).getX(), minSubDistance);
            stripMinDistance = stripClosestFloatingPoint(minSubDistance);
        }
        return Math.min(minSubDistance,stripMinDistance);
    }
}
