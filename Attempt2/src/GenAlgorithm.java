/**
 * Description of GA
 * Population of possible solutions to the given problem
 * The solutions undergo recombination and mutation, producing new children
 * The process is repeated over various generations
 * Each individual (or candidate solution) is assigned a fitness value based on objective function value
 * Fitter individuals are given a higher chance to mate and yield more "fitter" individuals
 * We keep "evolving" better individuals or solutions over generations until we reach a terminating criterion.
 * GA is randomized but performs better than random local search as they exploit historical information as well.
 *
 * GA()
 *      initialize population
 *      find fitness of population
 *      while (termination criteria is reached) do
 *          parent selection
 *          crossover with probability pc
 *          mutation with probability pm
 *          decode and fitness calculation
 *          survivor selection
 *          find best
 *      return best
 */

public class GenAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    protected int tournamentSize;


    public GenAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }


    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public int getElitismCount() {
        return elitismCount;
    }

    public void setElitismCount(int elitismCount) {
        this.elitismCount = elitismCount;
    }
}
