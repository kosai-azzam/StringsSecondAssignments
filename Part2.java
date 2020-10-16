
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public int howMany (String stringa, String stringb) {
     
        int firstOcc = stringb.indexOf(stringa);
        int count = 0;
        
        while (firstOcc != -1) {
            
           
            firstOcc = stringb.indexOf(stringa, firstOcc + stringa.length());
            count = count + 1;
            }
            
        return count;
    } 
        
    
    
    public void testHowMany () {
     
        String Main = "ATAAAA";
        String Sub = "AA";
        System.out.println("Mais is " + Main);
        System.out.println("Sub is " + Sub);
        int numOcc = howMany(Sub, Main);
        System.out.println("number of occurences is " + numOcc);
        
        Main = "AQMMMM";
        Sub = "AA";
        System.out.println("Mais is " + Main);
        System.out.println("Sub is " + Sub);
        numOcc = howMany(Sub, Main);
        System.out.println("number of occurences is " + numOcc);
        
        Main = "ATAYYYATAHHHATAKKKATA";
        Sub = "ATA";
        System.out.println("Mais is " + Main);
        System.out.println("Sub is " + Sub);
        numOcc = howMany(Sub, Main);
        System.out.println("number of occurences is " + numOcc);
    }
}