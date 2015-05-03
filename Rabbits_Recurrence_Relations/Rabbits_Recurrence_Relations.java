/**
 * Author:      Brittany Postnikoff
 * Date:        2015-05-03
 * Project:     Rosalind
 * Current Doc: Rabbits and Recurrence Relations
 * Description: This program takes in a number of months
 *              and how many pairs of rabbits rabbit pairs
 *              produce per month.
 */

import java.util.*;
import java.io.*;

public class Rabbits_Recurrence_Relations
{
  public static void main(String[] args)
  {
    //The months and monthly pairs are provided by a 
    //  file or user
    int months = 33;
    long monthlyPairs = 5;
    
    //Holding variables
    long totalRabbits = 0;
    long babies = 0;
    long mature = 0;
    
    //Cycles through the reproduction file for each of the
    //  months
    for(int i=0; i < months+2; i++)
    {
      //If the month is 1 or 0, the number of rabbit
      //  pairs is reflected as that same amount
      if(i == 1 || i == 0)
      {
        totalRabbits = i;
      }
      else
      {
        //Number of rabbits is equal to the mature rabbits
        //  and the ones that have matured this month
        totalRabbits += mature;
        //The new nuber of rabbits to mature in the next month
        //  is updated from last months babies
        mature = babies;
        //The number of babies becomes the total number of mature 
        //  pairs multiplied by the number of babies they have
        babies = totalRabbits * monthlyPairs;                
      }
    }
     
    System.out.println(totalRabbits);
  }
}
