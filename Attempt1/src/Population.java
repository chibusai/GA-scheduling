import javax.naming.InitialContext;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * A population is a pool of potential solutions (individuals)
 */
public class Population {
    private Individual population[];
    private double populationFitness = -1;

    /**
     * Initiliaze population of individuals (empty)
     * @param populationSize
     */
    public Population(int populationSize) {
        this.population = new Individual[populationSize];
    }

    /**
     * Populate the population with individuals
     * @param populationSize
     * @param timetable
     */
    public Population(int populationSize, Timetable timetable) {
        this.population = new Individual[populationSize];

        // loop through population
        for (int individualIndex = 0; individualIndex < populationSize; individualIndex++) {
            Individual individual = new Individual(timetable);
            this.population[individualIndex] = individual;
        }
    }

    public Population(int populationSize, int chromosomeLength) {
        this.population = new Individual[populationSize];

        // loop through population
        for (int individualIndex = 0; individualIndex < populationSize; individualIndex++) {
            Individual individual = new Individual(chromosomeLength);
            this.population[individualIndex] = individual;
        }
    }

    public Individual[] getPopulation() {
        return this.population;
    }

    public Individual getFittest(int offset) {
        Arrays.sort(this.population, new Comparator<Individual>() {
            public int compare(Individual i1, Individual i2) {
                if (i1.getFitness() > i2.getFitness()) {
                    return -1;
                }
                else if (i1.getFitness() < i2.getFitness()) {
                    return 1;
                }
                return 0;
            }
        });
        return this.population[offset];
    }

    public void setPopulationFitness(double fitness) {
        this.populationFitness = fitness;
    }

    public double getPopulationFitness() {
        return this.populationFitness;
    }

    public int size() {
        return this.population.length;
    }

    public Individual setIndividual(int offset, Individual individual) {
        return population[offset] = individual;
    }

    public Individual getIndividual(int offset) {
        return population[offset];
    }

    public void shuffleIndividuals() {
        for (int i = population.length-1; i > 0; i--) {
            int individualIndex = new Random().nextInt(i+1);
            Individual individual = population[individualIndex];
            population[individualIndex] = population[i];
            population[i] = individual;
        }
    }
}
