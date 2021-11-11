import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Representation and storage of Vertices that exist on the Linear Plane within view.
 * Each Vertex in the Map represents an object existing on the map along a 2D space (x,y)
 **/
public class Map {
    private ArrayList<Vertex> vertices;
    private double shortestDistance;

    /**
     * create a new map with randomized points in the 2D space
     * vertices list will then have a size of number of elements
     * @param numberOfElements size of vertices list
     */
    Map(int numberOfElements) {
        shortestDistance = 10000;
        vertices = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= numberOfElements; i++) {
            vertices.add(new Vertex(rand.nextFloat(),rand.nextFloat()));
        }
        printAllElements();
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    /**
     * Get size of map
     * @return count of vertices in map
     */
    public int getNumOfVertices() {
        return vertices.size();
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    /**
     * Get a vertex at a given index in the array
     * @param index place in array to retrieve vertex
     * @return vertex found
     */
    public Vertex getVertex(int index) {
        if(index < 0 || index > vertices.size()-1){
            System.out.println("Unable to retrieve vertex at invalid index " + index);
            return null;
        }
        return vertices.get(index);
    }

    /**
     * Sort the vertices along the x axis using built in array list mergesort
     */
    public void sortAlongXAxis() {
        vertices.sort(Comparator.comparing(vertex -> vertex.getX()));
        System.out.println("Elements Sorted:");
        printAllElements();
    }

    public void printAllElements() {
        printElements(0, vertices.size());
    }

    public void printElements(int start, int end) {
        System.out.print('[');
        for (int i = start; i < end; i++) {
            System.out.print(vertices.get(i));
            if (i + 1 != end) {
                System.out.print(',');
            }
        }
        System.out.println(']');
    }

    /**
     * Splits array in equal parts (n/2) based on the start and end values provided
     * Distance between each neighboring elements in their sections (powers of 2) are then found and compared with the smallest distance of other pairs
     * The minimum distance is then returned for the final answer of minimum distance between groups
     *
     * @param start beginning of array/ subarray
     * @param end end of array/subarray
     * @return minimum distance within the array/subarray
     */
    public double findMinimumDistance(int start, int end) {
        System.out.println("Finding the Minimum Distance between elements at index " + start + " and index " + end);
        printElements(start, end);
        // recursive function divide array and sub-arrays in half until 1 element remains
        // check distance between neighboring points and get the min value
        if (start >= end) {
            // compare the remaining two elements and return the distance between them
            return 10000;
        }
        int mid = (start + end) / 2;
        System.out.println("To The Left");
        double leftDistance = findMinimumDistance(start, mid);
        System.out.println("To The Right");
        double rightDistance = findMinimumDistance(mid + 1, end);
        if (leftDistance == 10000 && rightDistance == 10000) {
            return vertices.get(start).distanceFrom(vertices.get(mid+1 > vertices.size()? mid : mid + 1));
        } else if (leftDistance == 10000) {
            return rightDistance;
        } else if (rightDistance == 10000) {
            return leftDistance;
        } else if (leftDistance < rightDistance) {
            return leftDistance;
        } else {
            return rightDistance;
        }
        // single vertices sets
    }
}
