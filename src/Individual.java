import java.io.UnsupportedEncodingException;

/**
 * Created by peteroid on 8/1/16.
 */
public class Individual {

    static int defaultGeneLength = 160;
    private byte[] genes = new byte[defaultGeneLength];
    // Cache
    private int fitness = 0;

    // Create a random individual
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }

    public byte getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
        fitness = FitnessCalc.getFitness(this);
    }
    return fitness;
}

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }

    public String getPhenoType() {
        String type = "";

        for (int i = 0; i < size(); i += 8) {
            int val = 128;
            char c = 0;
            for (int j = i; j < i + 8; j++) {
                c += (this.genes[j] * val);
                val >>= 1;
            }
            type += c;
//            System.out.print(' ');
        }
        return type;
//        try {
//            return new String(this.genes, "ASCII");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return "";
//        }
    }

}