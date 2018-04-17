/**
 * Each chromosome is an array of arrays of integers.
 *
 * Each inner array represents a gene, containing subject, session, student group,
 * instructor, duration, location and start time.
 */

public class Chromosome {

    private int[] chromosome;
    private double fitness = -1;

//    public Chromosome(Schedule schedule, int[][] chromosome, double fitness) {
//        this.chromosome = chromosome;
//        this.fitness = fitness;
//    }


    public Chromosome(Schedule schedule) {
        int numClasses = schedule.getNumClasses();

        // 5 for class info, 1 for venue, 1 for start time
        int chromosomeLength = numClasses * 7;

        // create random individual
        int[] newChromosome = new int[chromosomeLength];
        int chromosomeIndex = 0; // or 5?



        // loop through all modules
        for (Module module : schedule.getModulesAsArray()) {

            // add fixed module at newChromosome[0n]
            newChromosome[chromosomeIndex] = module.getModuleId();

            // loop through all sessions of a module
            for (int sessionId : module.getSessionIds()) {
                // add fixed session at newChromosome[1n]
                newChromosome[chromosomeIndex + 1] = sessionId;
            }

            // loop through all student groups enrolled in a module
            for (int studentGroupId : module.getStudentGroupIds()){
                // add fixed student group at newChromosome[2n]
                newChromosome[chromosomeIndex + 2] = studentGroupId;
            }

            for (StudentGroup studentGroup : schedule.getStudentGroupsAsArray()) {

                
            }



            chromosomeIndex += 7;
        }
    }
    public int[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
}
