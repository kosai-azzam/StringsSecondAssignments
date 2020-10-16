
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public int findStopCodon (String dna, int startIndex, String stopCodon) {
     
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while ( currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
             
                return currIndex;
            }
            else {
                
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon () {
     
    String dna = "xxxyyyzzz";
    System.out.println("DNA is " + dna);
    int dex = findStopCodon(dna, 0, "TAA");
    if (dex !=9)
    System.out.println("error " + dex);
    }
    
    public String findGene (String dna) {
     
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
         
            return "";
    }
        
        int indexTAA = findStopCodon(dna, startIndex, "TAA");
        int indexTAG = findStopCodon(dna, startIndex, "TAG");
        int indexTGA = findStopCodon(dna, startIndex, "TGA");
        
        int temp = Math.min(indexTAA, indexTAG);
        int minIndex = Math.min(temp, indexTGA);
        if (minIndex != -1) {
            
        return dna.substring(startIndex, minIndex + 3);
    }
    else {
        
        return "";
    }
    }
    
    public void testFindGene () {
        String dna = "XXXYYYZZZTGAYYYZZZ";
        System.out.println("DNA is " + dna);
        String gene = findGene(dna);
        System.out.println("Gene is " + gene);
        dna = "ATGYYYZZZTGAYYYZZZ";
        System.out.println("DNA is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        dna = "ATGYYYZZZTGAYYYTAA";
        System.out.println("DNA is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        dna = "ATGZZZTGAYYYZZZ";
        System.out.println("DNA is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
    }
}
