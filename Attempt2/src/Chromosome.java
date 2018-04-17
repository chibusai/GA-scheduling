/**
 * Each chromosome is an array of arrays of integers.
 *
 * Each inner array represents a gene, containing subject, session, student group,
 * instructor, duration, location and start time.
 */

public class Chromosome {

    private int[][] chromosome;
    private double fitness = -1;

//    public Chromosome(Schedule schedule, int[][] chromosome, double fitness) {
//        this.chromosome = chromosome;
//        this.fitness = fitness;
//    }

    public Chromosome(Schedule schedule) {
        int numClasses = schedule.getNumClasses();

        // 1 for class info, 1 for venue, 1 for start time
        int chromosomeLength = 
    }
    public int[][] getChromosome() {
        return chromosome;
    }

    public void setChromosome(int[][] chromosome) {
        this.chromosome = chromosome;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
}
