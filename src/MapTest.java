import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

public class MapTest {

    Instant start;
    Instant end;
    Map intMap;
    Map floatMap;
    long intTimeElapsed;
    int intComparisons;
    long floatTimeElapsed;
    int floatComparisons;

    @Test
    public void testMapSize3() {
        intMap = new Map(3, 'I');
        floatMap = new Map(3,'F');

        start = Instant.now();
        intMap.findMinimumDistance();
        end = Instant.now();

        intTimeElapsed = Duration.between(start, end).toMillis();
        intComparisons = intMap.getComparisonCount();

        start = Instant.now();
        floatMap.findMinimumDistance();
        end = Instant.now();

        floatTimeElapsed = Duration.between(start, end).toMillis();
        floatComparisons = floatMap.getComparisonCount();

        assert(intComparisons == floatComparisons);

        System.out.println("Time elapsed to solve list of size 3 using Integers: " + intTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 3 using Integers: " + intComparisons);

        System.out.println("Time elapsed to solve list of size 3 using Floats: " + floatTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 3 using Floats: " + floatComparisons);
    }

    @Test
    public void testMapSize8() {
        intMap = new Map(8, 'I');
        floatMap = new Map(8,'F');

        start = Instant.now();
        intMap.findMinimumDistance();
        end = Instant.now();

        intTimeElapsed = Duration.between(start, end).toMillis();
        intComparisons = intMap.getComparisonCount();

        start = Instant.now();
        floatMap.findMinimumDistance();
        end = Instant.now();

        floatTimeElapsed = Duration.between(start, end).toMillis();
        floatComparisons = floatMap.getComparisonCount();

        System.out.println("Time elapsed to solve list of size 8 using Integers: " + intTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 8 using Integers: " + intComparisons);

        System.out.println("Time elapsed to solve list of size 8 using Floats: " + floatTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 8 using Floats: " + floatComparisons);
    }

    @Test
    public void testMapSize200() {
        intMap = new Map(200, 'I');
        floatMap = new Map(200,'F');

        start = Instant.now();
        intMap.findMinimumDistance();
        end = Instant.now();

        intTimeElapsed = Duration.between(start, end).toMillis();
        intComparisons = intMap.getComparisonCount();

        start = Instant.now();
        floatMap.findMinimumDistance();
        end = Instant.now();

        floatTimeElapsed = Duration.between(start, end).toMillis();
        floatComparisons = floatMap.getComparisonCount();

        System.out.println("Time elapsed to solve list of size 200 using Integers: " + intTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 200 using Integers: " + intComparisons);

        System.out.println("Time elapsed to solve list of size 200 using Floats: " + floatTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 200 using Floats: " + floatComparisons);
    }

    @Test
    public void testMapSize200Brute() {
        intMap = new Map(200, 'I');
        floatMap = new Map(200,'F');

        start = Instant.now();
        intMap.findMinimumDistanceBrute(0, intMap.getSize());
        end = Instant.now();

        intTimeElapsed = Duration.between(start, end).toMillis();
        intComparisons = intMap.getComparisonCount();

        start = Instant.now();
        floatMap.findMinimumDistanceBrute(0, floatMap.getSize());
        end = Instant.now();

        floatTimeElapsed = Duration.between(start, end).toMillis();
        floatComparisons = floatMap.getComparisonCount();

        System.out.println("Brute Force : Time elapsed to solve list of size 200 using Integers: " + intTimeElapsed + " milliseconds");
        System.out.println("Brute Force : Num of comparisons to solve list of size 200 using Integers: " + intComparisons);

        System.out.println("Brute Force : Time elapsed to solve list of size 200 using Floats: " + floatTimeElapsed + " milliseconds");
        System.out.println("Brute Force : Num of comparisons to solve list of size 200 using Floats: " + floatComparisons);
    }

    @Test
    public void testMapSize256() {
        intMap = new Map(256, 'I');
        floatMap = new Map(256,'F');

        start = Instant.now();
        intMap.findMinimumDistance();
        end = Instant.now();

        intTimeElapsed = Duration.between(start, end).toMillis();
        intComparisons = intMap.getComparisonCount();

        start = Instant.now();
        floatMap.findMinimumDistance();
        end = Instant.now();

        floatTimeElapsed = Duration.between(start, end).toMillis();
        floatComparisons = floatMap.getComparisonCount();

        System.out.println("Time elapsed to solve list of size 256 using Integers: " + intTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 256 using Integers: " + intComparisons);

        System.out.println("Time elapsed to solve list of size 256 using Floats: " + floatTimeElapsed + " milliseconds");
        System.out.println("Num of comparisons to solve list of size 256 using Floats: " + floatComparisons);
    }

    @Test
    public void testMapSize256Brute() {
        intMap = new Map(256, 'I');
        floatMap = new Map(256,'F');

        start = Instant.now();
        intMap.findMinimumDistanceBrute(0, intMap.getSize());
        end = Instant.now();

        intTimeElapsed = Duration.between(start, end).toMillis();
        intComparisons = intMap.getComparisonCount();

        start = Instant.now();
        floatMap.findMinimumDistanceBrute(0, floatMap.getSize());
        end = Instant.now();

        floatTimeElapsed = Duration.between(start, end).toMillis();
        floatComparisons = floatMap.getComparisonCount();

        System.out.println("Brute Force: Time elapsed to solve list of size 256 using Integers: " + intTimeElapsed + " milliseconds");
        System.out.println("Brute Force: Num of comparisons to solve list of size 256 using Integers: " + intComparisons);

        System.out.println("Brute Force: Time elapsed to solve list of size 256 using Floats: " + floatTimeElapsed + " milliseconds");
        System.out.println("Brute Force: Num of comparisons to solve list of size 256 using Floats: " + floatComparisons);
    }
}
