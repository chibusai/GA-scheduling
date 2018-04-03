public class Individual {

    private int[] chromosome;
    private double fitness = -1;

    private Individual(Timetable timetable) {
        int numLessons = timetable.getNumLessons();

        // 1 gene for location, 1 for time slot, 1 for instructor
        int chromosomeLength = numLessons * 3;

        // create random individual
        int newChromosome[] = new int[chromosomeLength];
        int chromosomeIndex = 0;

        // loop through different groups
        for (Group group : timetable.getGroupsAsArray()) {
            // loop through subjects
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

    public Individual(int chromosomeLength) {
        int[] individual;
        individual = new int[chromosomeLength];

        for (int gene = 0; gene < chromosomeLength; gene++) {
            individual[gene] = gene;
        }

        this.chromosome = individual;
    }

    public Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public int[] getChromosome() {
        return this.chromosome;
    }

    public int getChromosomeLength() {
        return this.chromosome.length;
    }

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
