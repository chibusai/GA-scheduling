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

public class GeneticAlgorithm {
}
