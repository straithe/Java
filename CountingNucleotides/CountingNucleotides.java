/**
 * Author:      Brittany Postnikoff
 * Date:        April 3, 2015
 * Project:     Rosalind
 * Current Doc: Counting Nucleotides
 * Description: This program takes a DNA string and
 *              separates it based on the four
 *              nucleobases: adenine, cytosine, 
 *              guanine, and thymine.
 */

//Imports the necessary libraries
import java.util.*;
import java.io.*;

public class CountingNucleotides
{
  public static void main(String[] args)
  {
    //Allows for reading in of the file
    BufferedReader input;
    String line;
        
    //Counters to total the number of times each of the 
    //  nucleobases appear
    int adenine = 0;
    int cytosine = 0;
    int guanine = 0;
    int thymine = 0;

    //Try catch block to contain the file reading operations
    try
    {
      //Read in the file and the first line
      input = new BufferedReader(new FileReader("rosalind_dna.txt"));
      line = input.readLine();

      while(line != null)
      {
        //Retrieves the length of the string
        int stringLength = line.length();   

        //Cycles through each of the letters in the DNA string
        //  and counts each of the nucleobases
        for(int i = 0; i < stringLength; i++)
        {
          if(line.charAt(i) == 'A' || line.charAt(i) == 'a')
          {
            adenine += 1;
          }
          else if(line.charAt(i) == 'G' || line.charAt(i) == 'g')
          {
            guanine += 1;
          }
          else if(line.charAt(i) == 'T' || line.charAt(i) == 't')
          {
            thymine += 1;
          }
          else if(line.charAt(i) == 'C' || line.charAt(i) == 'c')
          {
            cytosine += 1;
          }
        }
                
        //Reads in next line
        line = input.readLine();
      }

      //Closes the file reader
      input.close();
    }
    catch (IOException ioe)
    {
      System.out.println("There was an IO error");
    }
        
    //Outputs the final counts
    System.out.println("Adenine: " + adenine + " Cytosine: " + cytosine +
                         " Guanine: " + guanine + " Thymine: " + thymine);
  }
}
