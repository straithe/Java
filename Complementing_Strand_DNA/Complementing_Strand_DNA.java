/**
 * Author:      Brittany Postnikoff
 * Date:        2015-05-03
 * Project:     Rosalind
 * Current Doc: Complementing a strand of DNA
 * Description: This program takes in a string of
 *              DNA and returns the reverse complement
 */

import java.util.*;
import java.io.*;

public class Complementing_Strand_DNA
{
  public static void main(String[] args)
  {
    BufferedReader input;
    String line;
    
    try
    {
      input = new BufferedReader(new FileReader("rosalind_revc.txt"));
      line = input.readLine();
      String finalString = "";
      
      while(line != null)
      {
        for(int i=line.length()-1; i>=0; i--)
        {
          if(line.charAt(i) == 'G')
          {
            finalString += 'C';
          }
          else if(line.charAt(i) == 'C')
          {
            finalString += 'G';
          }
          else if(line.charAt(i) == 'A')
          {
            finalString += 'T';
          }
          else if(line.charAt(i) == 'T')
          {
            finalString += 'A';
          }
        }
        
        line = input.readLine();
      }
      
      System.out.println(finalString);
      
      input.close();
    }
    catch (IOException ioe)
    {
      System.out.println("IO Exception");
    }
  }
}
