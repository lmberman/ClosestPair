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
    private ArrayList<FloatingPointVertex> floatingPointVertices;
    private ArrayList<IntegerVertex> integerVertices;

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
        floatingPointVertices = new ArrayList<>();
        integerVertices = new ArrayList<>();
        Random rand = new Random();
        switch (type) {
            case 'F':
            case 'f':
                for (int i = 1; i <= numberOfElements; i++) {
                    floatingPointVertices.add(new FloatingPointVertex(rand.nextFloat(), rand.nextFloat()));
                }
                break;
            case 'I':
            case 'i':
                for (int i = 1; i <= numberOfElements; i++) {
                    integerVertices.add(new IntegerVertex(rand.nextInt(10), rand.nextInt(10)));
                }
                break;
            default:
                break;
        }
        // Sort the Map along the x axis
        sortAlongXAxis();
        //printAllElements();
    }

    /**
     * Get size of map
     *
     * @return count of vertices in map
     */
    public int getSize() {
        return size;
    }

    public int getComparisonCount(){
        return comparisonCount;
    }

    /**
     * Sort the vertices along the x axis using built in array list mergesort
     */
    public void sortAlongXAxis() {
        if (floatingPointVertices.isEmpty()) {
            integerVertices.sort(Comparator.comparing(vertex -> vertex.getX()));
        } else {
            floatingPointVertices.sort(Comparator.comparing(vertex -> vertex.getX()));
        }
        //System.out.println("Elements Sorted:");
//        printAllElements();
    }

    public void printAllElements() {
        printElements(0, size);
    }

    public void printElements(int start, int end) {
        System.out.print("S = {");
        for (int i = start; i < end; i++) {
            System.out.print(floatingPointVertices.isEmpty() ? integerVertices.get(i) : floatingPointVertices.get(i));
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
            for (int j = start; j < end; j++) {
                if (i != j) {
                    double distance;
                    comparisonCount++;
                    if(floatingPointVertices.isEmpty()){
                        distance = integerVertices.get(i).distanceFrom(integerVertices.get(j));
                    } else {
                        distance = floatingPointVertices.get(i).distanceFrom(floatingPointVertices.get(j));
                    }
                    //System.out.println("Found Distance: " + distance);
                    if (distance < smallestDistance) {
                        smallestDistance = distance;
                    }
                }
            }
        }
        return smallestDistance;
    }

    /**
     * Finds the smallest distance between the points within the map using the recursive function to find SdL and SdR and another double for loop
     * to check the remaining element's distances
     *
     * @return smallest distance between points
     */
    public double findMinimumDistance() {
        double minimumGroupDistance = findMinimumDistanceRecursive(0, size);
        // Find Minimum Distance dLR among vertex pairs where one point is on left side of divide
        // and the other is to the right of the divide
        // this can be done by taking the minimum distance between all points to the left of the divide and the points to the right of the divide (median)
        double minimumPairDistance = 10000;
        int mid = size / 2;
        for (int leftIndex = mid - 1; leftIndex >= 0; leftIndex--) {
            for (int rightIndex = mid; rightIndex < size; rightIndex++) {
                double distance;
                comparisonCount++;
                if(floatingPointVertices.isEmpty()){
                    distance = integerVertices.get(leftIndex).distanceFrom(integerVertices.get(rightIndex));
                } else {
                    distance = floatingPointVertices.get(leftIndex).distanceFrom(floatingPointVertices.get(rightIndex));
                }
                if (distance < minimumPairDistance) {
                    minimumPairDistance = distance;
                }
            }
        }
        // Answer is the minimum between dL,dR, and dLR
        return minimumGroupDistance < minimumPairDistance ? minimumGroupDistance : minimumPairDistance;
    }

    /**
     * Splits array in equal parts (n/2) based on the start and end values provided
     * Distance between each neighboring elements in their sections (powers of 2) are then found and compared with the smallest distance of other pairs
     * The minimum distance is then returned for the final answer of minimum distance between groups
     *
     * @param start beginning of array/ subarray
     * @param end   end of array/subarray
     * @return minimum distance within the array/subarray
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
        //System.out.print("SdR distance:" + rightDistance);
        // return the smallest of the two
        // need to get the points for these smallest values
        comparisonCount++;
        return leftDistance < rightDistance ? leftDistance : rightDistance;
    }
}
