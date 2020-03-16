/**
 * CISC 380
 * Algorithms Assignment X
 * 
 * Driver file for the Interleaver class
 * Tests the isInterleaved method.
 * 
 * 
 *  This driver file contains example test cases to get you started.
 *  You should include more test cases to ensure that your implemenetation works correctly.
 *  You do NOT need to submit this file.
 *
 * @author Emma Sinn and Alex Palumbo
 * Due Date: 03/16/20
 */

public class InterleaverDriver{


    public static void main(String[] args){
        try{
            Interleaver interleaver = new Interleaver();
                                                      
            System.out.println( interleaver.isInterleaved("abc","dcab","abdccab") );
            System.out.println( interleaver.isInterleaved("abc","dcab","acdcbab") );

        }catch( Exception e){
            e.printStackTrace();
        }
       

    }//main


}