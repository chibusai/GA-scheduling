/**
 * Equivalent of POPULATION
 */
public class Pool {
    private Chromosome[] pool;
    private double poolFitness = -1;

    public Pool(int poolSize) {
        this.pool = new Chromosome[poolSize];
    }

    public Pool(int poolSize, Schedule schedule) {
        this.pool = new Chromosome[poolSize];

        // loop through pool to populate with individuals
        for (int individualIndex = 0; individualIndex < poolSize; individualIndex++) {
            Chromosome individual = new Chromosome(schedule);
            this.pool[individualIndex] = individual;
        }
    }

    public Pool(int poolSize, int chromosomeLength) {
        this.pool = new Chromosome[poolSize];

        for (int individualIndex = 0; individualIndex < poolSize; individualIndex++) {
            Chromosome individual = new Chromosome(chromosomeLength);
        }
    }

    public Pool(Chromosome[] pool, double poolFitness) {
        this.pool = pool;
        this.poolFitness = poolFitness;
    }

    public Chromosome[] getPool() {
        return pool;
    }

    public void setPool(Chromosome[] pool) {
        this.pool = pool;
    }

    public double getPoolFitness() {
        return poolFitness;
    }

    public void setPoolFitness(double poolFitness) {
        this.poolFitness = poolFitness;
    }
}
