/**
 * Description of GA
 * Population of possible solutions to the given problem
 * The solutions undergo recombination and mutation, producing new children
 * The process is repeated over various generations
 * Each individual (or candidate solution) is assigned a fitness value based on objective function value
 * Fitter individuals are given a higher chance to mate and yield more "fitter" individuals
 * We keep "evolving" better individuals or solutions over generations until we reach a terminating criterion.
 * GA is randomized but performs better than random local search as they exploit historical information as well.
 */

public class Algorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    protected int tournamentSize;



    public Algorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    /**
     * Initialize population
     * @param timetable
     * @return the newly generated population
     */
    public Population population(Timetable timetable) {
        Population population = new Population(this.populationSize, timetable);
        return population;
    }

    public boolean isTerminationConditionMet(int generationsCount, int generationsTotal, Population population) {
        return ((generationsCount > generationsTotal) || population.getFittest(0).getFitness() == 1.0);
    }

    public double calculateFitness(Individual individual, Timetable timetable) {
        Timetable cloneTimetable = new Timetable(timetable);
        cloneTimetable.createLessons(individual);

        int clashes = cloneTimetable.calculateClashes();
        double fitness = 1 / (double) (clashes+1);

        individual.setFitness(fitness);

        return fitness;
    }

    public void evaluatePopulation(Population population, Timetable timetable) {
        double populationFitness = 0;

        for (Individual individual : population.getPopulation()) {
            populationFitness += this.calculateFitness(individual,timetable);
        }

        population.setPopulationFitness(populationFitness);
    }

    public Individual selectParent(Population population) {
        Population tournament = new Population(this.tournamentSize);

        population.shuffleIndividuals();

        for (int tournamentIndex = 0; tournamentIndex < this.tournamentSize; tournamentIndex++) {
            Individual tournamentIndividual = population.getIndividual(tournamentIndex);
            tournament.setIndividual(tournamentIndex,tournamentIndividual);
        }

        return tournament.getFittest(0);
    }

    public Population mutatePopulation(Population population, Timetable timetable) {
        Population newPopulation =  new Population(this.populationSize);

        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual individual = population.getFittest(populationIndex);

            Individual randomIndividual = new Individual(timetable);

            for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
                if (populationIndex > this.elitismCount) {
                    if (this.mutationRate > Math.random()) {
                        individual.setGene(geneIndex, randomIndividual.getGene(geneIndex));
                    }
                }
            }

            newPopulation.setIndividual(populationIndex,individual);
        }
        return newPopulation;
    }

    public Population crossoverPopulation(Population population) {
        Population newPopulation = new Population(population.size());

        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Individual parent1 = population.getFittest(populationIndex);

            if (populationIndex >= this.elitismCount && this.crossoverRate > Math.random()) {
                Individual child = new Individual(parent1.getChromosomeLength());

                Individual parent2 = selectParent(population);

                for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
                    if (Math.random() < 0.5) {
                        child.setGene(geneIndex, parent1.getGene(geneIndex));
                    } else {
                        child.setGene(geneIndex, parent2.getGene(geneIndex));
                    }
                }
                newPopulation.setIndividual(populationIndex,child);
            }
            else {
                newPopulation.setIndividual(populationIndex,parent1);
            }
        }
        return newPopulation;
    }
}
