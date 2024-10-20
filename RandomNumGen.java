import java.util.ArrayList;
import java.util.List;


public class RandomNumGen {
    private static final int seed = 1000; //starting value seed
    private static final int multiplier = 24693; //multiplier a
    private static final int increment = 3517; // increment c
    private static final int modulus = (int) Math.pow(2, 17); //modulus K

    private int current; //current value in the sequence

    public RandomNumGen() {
        this.current = seed; // initializing w/ the seed value
    }

    // method to get the next pseudo-random # in the sequence
    public double nextRandom() {
        current = ((multiplier * current) + increment) % modulus; //rule 1a: generating the next
        return (double) current / modulus; //rule 1b: scaling to between 0 and 1
    }

    //method to output a sequence of pseudo-random #s
    public List<Double> generateRandomNumbers(int n) {
        List<Double> RandomNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            RandomNumbers.add(nextRandom());
        }
        return RandomNumbers;
    }

}
