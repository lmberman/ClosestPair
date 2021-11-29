import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

public class MapTest {

    @Test
    public void testMapRunTimesOfDifferentSizes(){
        Instant start = Instant.now();
        Map map = new Map(3, 'I');
        map.findMinimumDistance();
        Instant end = Instant.now();

        long timeElapsedForThreeInt = Duration.between(start, end).toMillis();
        int comparisonsForThreeInt = map.getComparisonCount();

        start = Instant.now();
        map = new Map(3, 'F');
        map.findMinimumDistance();
        end = Instant.now();

        long timeElapsedForThreeFloat = Duration.between(start, end).toMillis();
        int comparisonsForThreeFloat = map.getComparisonCount();

        start = Instant.now();
        map = new Map(8,'I');
        map.findMinimumDistance();
        end = Instant.now();
        long timeElapsedForEightInt = Duration.between(start, end).toMillis();
        int comparisonsForEightInt = map.getComparisonCount();

        start = Instant.now();
        map = new Map(8,'F');
        map.findMinimumDistance();
        end = Instant.now();
        long timeElapsedForEightFloat = Duration.between(start, end).toMillis();
        int comparisonsForEightFloat = map.getComparisonCount();

        start = Instant.now();
        map = new Map(200, 'I');
        map.findMinimumDistance();
        end = Instant.now();
        long timeElapsedForTwoHundInt = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundInt = map.getComparisonCount();

        start = Instant.now();
        map = new Map(200, 'F');
        map.findMinimumDistance();
        end = Instant.now();
        long timeElapsedForTwoHundFloat = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundFloat = map.getComparisonCount();

        start = Instant.now();
        map = new Map(256, 'I');
        map.findMinimumDistance();
        end = Instant.now();
        long timeElapsedForTwoHundFiveInt = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundFiveInt = map.getComparisonCount();

        start = Instant.now();
        map = new Map(256, 'F');
        map.findMinimumDistance();
        end = Instant.now();
        long timeElapsedForTwoHundFiveFloat = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundFiveFloat = map.getComparisonCount();

        start = Instant.now();
        map = new Map(200, 'I');
        map.findMinimumDistanceBrute(0,map.getSize());
        end = Instant.now();
        long timeElapsedForTwoHundBrute = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundBrute = map.getComparisonCount();

        start = Instant.now();
        map = new Map(200, 'F');
        map.findMinimumDistanceBrute(0,map.getSize());
        end = Instant.now();
        long timeElapsedForTwoHundBruteFloat = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundBruteFloat = map.getComparisonCount();

        start = Instant.now();
        map = new Map(256, 'I');
        map.findMinimumDistanceBrute(0, map.getSize());
        end = Instant.now();
        long timeElapsedForTwoHundFiveBrute = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundFiveBrute = map.getComparisonCount();

        start = Instant.now();
        map = new Map(256, 'F');
        map.findMinimumDistanceBrute(0, map.getSize());
        end = Instant.now();
        long timeElapsedForTwoHundFiveBruteFloat = Duration.between(start, end).toMillis();
        int comparisonsForTwoHundFiveBruteFloat = map.getComparisonCount();

//        assert(timeElapsedForThreeFloat < timeElapsedForTwoHundFloat && timeElapsedForThreeFloat > timeElapsedForEightFloat);
//        assert(timeElapsedForEightFloat < timeElapsedForThreeInt && timeElapsedForEightFloat < timeElapsedForTwoHundFloat); // 8 is the smallest
//        assert(timeElapsedForTwoHundFiveFloat > timeElapsedForEightFloat && timeElapsedForTwoHundFiveFloat < timeElapsedForTwoHundFloat); // greater than 8 but less than 200 time due to evenly distributed tree


        System.out.println("Time elapsed to solve list of size 3 using Integers: " + timeElapsedForThreeInt + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 3 using Integers: " + comparisonsForThreeInt);

        System.out.println("Time elapsed to solve list of size 3 using Floats: " + timeElapsedForThreeFloat + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 3 using Floats: " + comparisonsForThreeFloat);

        System.out.println("Time elapsed to solve list of size 8 using Integers: " + timeElapsedForEightInt + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 8 using Integers: " + comparisonsForEightInt);

        System.out.println("Time elapsed to solve list of size 8 using Floats: " + timeElapsedForEightFloat + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 8 using Floats: " + comparisonsForEightFloat);

        System.out.println("Time elapsed to solve list of size 200 using Integers: " + timeElapsedForTwoHundInt + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 200 using Integers: " + comparisonsForTwoHundInt);

        System.out.println("Time elapsed to solve list of size 200 using Floats: " + timeElapsedForTwoHundFloat + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 200 using Floats: " + comparisonsForTwoHundFloat);

        System.out.println("Time elapsed to solve list of size 200 using Integers brute force: " + timeElapsedForTwoHundBrute + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 200 using Integers brute force: " + comparisonsForTwoHundBrute);

        System.out.println("Time elapsed to solve list of size 200 using Floats brute force: " + timeElapsedForTwoHundBruteFloat + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 200 using Floats brute force: " + comparisonsForTwoHundBruteFloat);

        System.out.println("Time elapsed to solve list of size 256 using Integers: " + timeElapsedForTwoHundFiveInt + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 256 using Integers: " + comparisonsForTwoHundFiveInt);

        System.out.println("Time elapsed to solve list of size 256 using Floats: " + timeElapsedForTwoHundFiveFloat + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 256 using Floats: " + comparisonsForTwoHundFiveFloat);

        System.out.println("Time elapsed to solve list of size 256 using Integers brute force: " + timeElapsedForTwoHundFiveBrute + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 256 using Integers brute force: " + comparisonsForTwoHundFiveBrute);

        System.out.println("Time elapsed to solve list of size 256 using Floats brute force: " + timeElapsedForTwoHundFiveBruteFloat + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 256 using Float brute force: " + comparisonsForTwoHundFiveBruteFloat);
    }
}
