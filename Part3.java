
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public void countGene (String dna) {
    
        int startIndex = 0;
        int counter = 0;
        while ( true) {
         
            String currGene = findGene(dna, startIndex);
            
            if (currGene.isEmpty()) {
             
              break; 
            
             
        }
            
            
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
            counter = counter + 1;
            
        }
        System.out.println(counter);
    }
    
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
    
    public String findGene (String dna, int where) {
     
        int startIndex = dna.indexOf("ATG", where);
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
        String gene = findGene(dna, 0);
        System.out.println("Gene is " + gene);
        dna = "ATGYYYZZZTGAYYYZZZ";
        System.out.println("DNA is " + dna);
        gene = findGene(dna, 0);
        System.out.println("Gene is " + gene);
        dna = "ATGYYYZZZTGAYYYTAA";
        System.out.println("DNA is " + dna);
        gene = findGene(dna, 0);
        System.out.println("Gene is " + gene);
        dna = "ATGZZZTGAYYYZZZ";
        System.out.println("DNA is " + dna);
        gene = findGene(dna, 0);
        System.out.println("Gene is " + gene);
        
    }
    
    public void testOn (String dna) {
     
        System.out.println("testing countGene on " + dna);
        countGene(dna);
    }
    
    public void test () {
     
        testOn ("ATGYYYTAAUUUIIIATGTGAOOOPPPSSSATGBHSTAG");
        testOn ("");
        testOn ("PPPOOOSSSTAATAGTGA");
    }
}
