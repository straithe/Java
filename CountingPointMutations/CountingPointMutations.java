/**
 * Author:      Brittany Postnikoff
 * Date:        2015-05-03
 * Project:     Rosalind
 * Current Doc: Counting point mutations
 * Description: Takes in two DNA strings and compares
 *              them to find The Hamming distance.
 *              The two strings are compared character
 *              by character and if a set doesn't match
 *              the mutations counter goes up by one.
 */

import java.util.*;
import java.io.*;

public class CountingPointMutations
{
  public static void main(String[] args)
  {
    BufferedReader input;
    String line1;
    String line2;
    int stringLength;
    int mutations = 0;
        
    try
    {
      input = new BufferedReader(new FileReader("rosalind_hamm.txt"));
      //Reads in the two strings of DNA to compare
      line1 = input.readLine();
      line2 = input.readLine();
      //Finds the length of the DNA string
      stringLength = line1.length();
            
      for(int i = 0; i<stringLength; i++)
      {
        //If a set doesn't match the mutations counter is increased. 
        if(line1.charAt(i) != line2.charAt(i))
        {
          mutations +=1;
        }
      }
    }
    catch(IOException ioe)
    {
      System.out.println("IO Error");
    }
        
    //Displays the number of mutations
    System.out.println(mutations);
  }
}
