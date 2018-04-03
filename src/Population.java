import javax.naming.InitialContext;
import java.util.Arrays;
import java.util.Comparator;

public class Population {
    private Individual population[];
    private double populationFitness = -1;

    public Population(int populationSize) {
        this.population = new Individual[populationSize];
    }

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
}
