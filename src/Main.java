public class Main {
    public static void main(String[] args){
        // Create new Map (Constructor should generate random Vertices)
        Map flightMap = new Map(3, 'F');
        // find the minimum between dL and dR
        double minimumDistance = flightMap.findMinimumDistance();
        System.out.println("The minimum distance between the vertices is " + minimumDistance);

    }
}
