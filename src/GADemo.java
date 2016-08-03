import java.util.Arrays;

/**
 * Created by peteroid on 8/1/16.
 */
public class GADemo {

    public static void main (String[] args) {
//        FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");
        FitnessCalc.setSolutionString("H#l10 W0rl6!");
        Algorithm.uniformRate = 0.5;
        Algorithm.mutationRate = 0.02;
        Algorithm.tournamentSize = 10;
        int repeatCount = 50;


        for (int k = 0; k < 9; k++) {
//            Algorithm.uniformRate = 0.1 * (k + 1);
//            Algorithm.mutationRate = 0.015 + (k + 1) * 0.001;
//            Algorithm.tournamentSize = 2 * (k + 1);

            int[] counts = new int[repeatCount];
            int totalCount = 0;
            for (int i = 0; i < repeatCount; i++) {
                int generationCount = 0;
                Population myPop = new Population(5, true);
                while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
                    generationCount++;
//                    System.out.println(myPop.getFittest().getPhenoType());
//            System.out.println("Generation: "+generationCount+" Fittest: "+myPop.getFittest().getFitness());
                    myPop = Algorithm.evolvePopulation(myPop);
                }
//                System.out.println(myPop.getFittest().getPhenoType());
                counts[i] = generationCount;
                totalCount += generationCount;
            }
            Arrays.sort(counts);
            System.out.println(String.format("Avg: %d, Min: %d, Max: %d", totalCount / repeatCount, counts[0], counts[counts.length - 1]));
        }
    }
}
