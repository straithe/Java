/**
 * Author:      Brittany Postnikoff
 * Date:        2015 - 05 - 03
 * Project:     Rosalind
 * Current Doc: Transcribing DNA into RNA
 * Description: This program takes a DNA string
 *              and transforms it into an RNA string
 *              by replacing thymine with uracil in 
 *              the string.
 */

import java.util.*;
import java.io.*;

public class DNA_to_RNA
{
  public static void main(String[] args)
  {
    BufferedReader input;
    String line;
    String finalString = "";
        
    try
    {
      input = new BufferedReader(new FileReader("rosalind_rna.txt"));
      line = input.readLine();
            
      while(line != null)
      {
        for(int i=0; i<line.length();i++)
        {
          if(line.charAt(i) == 'T' || line.charAt(i) == 't')
          {
            finalString += "U";
          }
          else
          {
            finalString += line.charAt(i);
          }
        }    
        
        line = input.readLine();
      }
            
      System.out.println(finalString);
      input.close();

    }
    catch (IOException ioe)
    {
      System.out.println("IO Exception error");
    }
  }
}
