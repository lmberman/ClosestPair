public class Main {
    public static void main(String[] args){
        // Create new Map (Constructor should generate random Vertices)
        Map flightMap = new Map(4);
        // Sort the Map along the x axis
        flightMap.sortAlongXAxis();
                // find the minimum between dL and dR
        double minimumGroupDistance = flightMap.findMinimumDistance(0,flightMap.getVertices().size()-1);
        // Find Minimum Distance dLR among vertex pairs where one point is on left side of divide
        // and the other is to the right of the divide
        // this can be done by taking the minimum distance between all points to the left of the divide and the points to the right of the divide (median)
        double minimumPairDistance = 10000;
        for(int leftIndex=0; leftIndex< (flightMap.getNumOfVertices()/2) ; leftIndex++) {
            for(int rightIndex=(flightMap.getNumOfVertices()/2); rightIndex< flightMap.getNumOfVertices(); rightIndex++){
                double distance = flightMap.getVertex(leftIndex).distanceFrom(flightMap.getVertex(rightIndex));
                if(distance < minimumPairDistance){
                    minimumPairDistance = distance;
                }
            }
        }
        // Answer is the minimum between dL,dR, and dLR
        double minimumDistance = minimumGroupDistance < minimumPairDistance? minimumGroupDistance : minimumPairDistance;
        System.out.println("The minimum distance between the vertices is " + minimumDistance);

    }
}
