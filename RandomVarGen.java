public class RandomVarGen {
    private RandomNumGen randomnum;

    public RandomVarGen(RandomNumGen randomnum) {
        this.randomnum = randomnum;
    }

    public double ContinuousX() {
        double u = randomnum.nextRandom();
        return Math.pow(8 * u, 2.0 / 3.0); //inverse of the CDF
    }

    
}
