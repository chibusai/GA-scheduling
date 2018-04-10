/**
 * An individual is a candidate solution - a potentially optimized timetable
 */

public class Individual {

    /**
     * chromosome is an array of integers
     */
    private int[] chromosome;
    private double fitness = -1;

    /**
     * Initialize a random indidual based on a timetable
     *
     * Timetable holds fixed information (all subjects, instructors, locations available),
     * excluding information about how to unpack chromosomes to obtain term specific information.
     *
     * Create a chromosome that randomly assigns locations, time slots and instructors to the
     * chromosome for each student group and subject.
     * @param timetable
     */
    public Individual(Timetable timetable) {
        int numLessons = timetable.getNumLessons();

        // 1 gene for location, 1 for time slot, 1 for instructor
        int chromosomeLength = numLessons * 3;

        // create random individual
        int newChromosome[] = new int[chromosomeLength];
        int chromosomeIndex = 0;

        // loop through all student groups
        for (Group group : timetable.getGroupsAsArray()) {

            // loop through all subjects
            for (int subjectId : group.getSubjectIds()) {

                // add random time slots
                int timeslotID = timetable.getRandomTimeslot().getTimeslotId();
                newChromosome[chromosomeIndex] = timeslotID;
                chromosomeIndex++;

                // add random location
                int locationId = timetable.getRandomLocation().getLocationId();
                newChromosome[chromosomeIndex] = locationId;
                chromosomeIndex++;

                // add random instructor
                Subject subject = timetable.getSubject(subjectId);
                newChromosome[chromosomeIndex] = subject.getRandomInstructorId();
                chromosomeIndex++;
            }
        }

        this.chromosome = newChromosome;
    }

    /**
     * Initialize an individual with a chromosome of a given size
     * To be used in crossoverPopulation to initialize offspring.
     * @param chromosomeLength
     */
    public Individual(int chromosomeLength) {

        // create a random individual as integer array with a given chromosome size
        int[] individual = new int[chromosomeLength];

        for (int gene = 0; gene < chromosomeLength; gene++) {
            individual[gene] = gene;
        }

        this.chromosome = individual;
    }

    /**
     * Initialize individual with a specific chromosome
     * @param chromosome
     */
    public Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }

    /**
     * Get individual's chromosome
     * @return individual's chromosome
     */
    public int[] getChromosome() {
        return this.chromosome;
    }

    /**
     * Get individual's chromosome length
     * @return chromosome length
     */
    public int getChromosomeLength() {
        return this.chromosome.length;
    }

    /**
     * Set gene at offset
     * @param offset
     * @param gene
     */
    public void setGene(int offset, int gene) {
        this.chromosome[offset] = gene;
    }

    public int getGene(int offset) {
        return this.chromosome[offset];
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    public String toString() {
        String s = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            s += this.chromosome[gene] + ",";
        }
        return s;
    }

    public boolean containsGene(int gene) {
        for (int i = 0; i < this.chromosome.length; i++) {
            if (this.chromosome[i] == gene) {
                return true;
            }
        }
        return false;
    }
}
