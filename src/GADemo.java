/**
 * Created by peteroid on 8/1/16.
 */
public class GADemo {

    public static void main (String[] args) {
        FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");
        Population myPop = new Population(5,true);

        int generationCount = 0;
        while(myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
            generationCount++;
            System.out.println("Generation: "+generationCount+" Fittest: "+myPop.getFittest().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: "+generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
    }
}
