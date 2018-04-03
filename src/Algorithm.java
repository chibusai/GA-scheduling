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

        for (int individualIndex = 0; individualIndex < this.tournamentSize; individualIndex++) {
            Individual tournamentIndividual = population.getIndividual(individualIndex);
            tournament.setIndividual(individualIndex,tournamentIndividual);
        }

        return tournament.getFittest(0);
    }
}
