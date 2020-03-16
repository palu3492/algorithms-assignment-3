/**
 * CISC 380
 * Algorithms Assignment 3
 *
 * Implements a dynamic programming solution to the Interleaving Strings problem.
 *
 * @author Emma Sinn and Alex Palumbo
 * Due Date: 03/16/20
 */

public class Interleaver{


    public Interleaver(){
        //YOUR CODE HERE


    }//constructor

    /**
     * Finds if the two strings x and y are an interleaving of string z
     *
     * The string Z is an interleaving of X and Y if it can be obtained
     * by interleaving the characters in X and Y in a way that
     * maintains the left-to-right order of the c in X and Y:
     *
     * The Big O run time will be n*m which is the length of both input strings as
     * the recursion is ran so it only checks viable solutions. It could potentially
     * be exponential run time if the two input strings are very similar and therefore
     * the recursion will run for both the current x value equals the current z value
     * and the current y value equals the current z value. However, this is an extreme
     * case that will not likely be hit enough to change the run time.
     *
     * @param x the first string that composes an interleaving
     * @param y the second string that composes an interleaving
     * @param z the string to check for an interleaving
     * @return True, if the string z is an interleaving of x and y. False otherwise.
     *
     */
    public Boolean isInterleaved(String x, String y, String z){

        //YOUR CODE HERE

        return interleaved(x, y, z, x.length(), y.length(), z.length());

        //return false;

    }//isInterleaved

    private Boolean interleaved(String x, String y, String z, int xlength, int ylength, int zlength) {

        if(xlength == 0) {
            for(int i = 0; i < ylength; i++) {
                if(y.charAt(i) != z.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else if(ylength == 0) {
            for(int i = 0; i < xlength; i++) {
                if(x.charAt(i) != z.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else {
            if(x.charAt(xlength - 1) == z.charAt(zlength - 1) && y.charAt(ylength - 1) == z.charAt(zlength - 1)) {
                if(interleaved(x, y, z, xlength - 1, ylength, zlength - 1) == false) {
                    return interleaved(x, y, z, xlength, ylength - 1, zlength - 1);
                } else {
                    return true;
                }
            }
            if(x.charAt(xlength - 1) == z.charAt(zlength - 1)) {
                return interleaved(x, y, z, xlength - 1, ylength, zlength - 1);
            } else if(y.charAt(ylength - 1) == z.charAt(zlength - 1)) {
                return interleaved(x, y, z, xlength, ylength - 1, zlength - 1);
            } else {
                return false;
            }

        }

    }

    /**
     * Returns a string representation of the solution of the interleaved string problem.
     *
     * The return value is a string whose length is equal to z.
     * All characters in z are replaced by character "x" if they come from the string "x",
     * and all characters in z are replaced by the character "y" if they come from the string y.
     *
     * For example, on an input of x = "ab", y = "cd", and z = "abcd", then the output shall be the string "xxyy".
     *
     * @param x the first string that composes an interleaving
     * @param y the second string that composes an interleaving
     * @param z the string to check for an interleaving
     * @return A string representation of the solution
     */
    public String getSolution(String x, String y, String z){

        //YOUR CODE HERE

        return solution(x, y, z, x.length(), y.length(), z.length());

    }

    private String solution(String x, String y, String z, int xlength, int ylength, int zlength) {
        String returnString = "";
        if(xlength == 0) {
            for(int i = 0; i < ylength; i++) {
                if(y.charAt(i) != z.charAt(i)) {
                    return null;
                }
                returnString = returnString + "y";
            }
            return returnString;
        } else if(ylength == 0) {
            for(int i = 0; i < xlength; i++) {
                if(x.charAt(i) != z.charAt(i)) {
                    return null;
                }
                returnString = returnString + "x";
            }
            return returnString;
        } else {
            if(x.charAt(xlength - 1) == z.charAt(zlength - 1) && y.charAt(ylength - 1) == z.charAt(zlength - 1)) {
                returnString = solution(x, y, z, xlength - 1, ylength, zlength -1);
                if(returnString == null) {
                    return solution(x, y, z, xlength, ylength - 1, zlength - 1) + "y";
                } else {
                    return returnString + "x";
                }
            }
            if(x.charAt(xlength - 1) == z.charAt(zlength - 1)) {
                return solution(x, y, z, xlength - 1, ylength, zlength - 1) + "x";
            } else if(y.charAt(ylength - 1) == z.charAt(zlength - 1)) {
                return solution(x, y, z, xlength, ylength - 1, zlength - 1) + "y";
            } else {
                return null;
            }

        }

    }

}//class