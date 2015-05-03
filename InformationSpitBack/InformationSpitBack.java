/**
 * AUTHOR:    Brittany Postnikoff
 * DATE:      2015-05-03
 * DOCUMENT:  InformationSpitBack
 * PURPOSE:   Takes in information from a user, and spits it back 
 *              in a sentence.
 */

import java.util.Scanner;

public class InformationSpitBack 
{
  public static void main(String[] args)
  {
    String name;
    String userName;
    String age = "";
    Scanner input = new Scanner(System.in);

    System.out.println("\nInformation spit back program");
    System.out.println("=============================");

    System.out.print("Please, enter your name: ");
    name = input.nextLine();

    while(age.length() == 0 || !isNum(age))
    {
      System.out.print("Please, enter your age: ");
      age = input.nextLine();
    }

    System.out.print("Please, enter your username: ");
    userName = input.nextLine();

    System.out.println("\nYour name is " + name + ", you are " + age + " years old, and your username is " + userName + ".\n");

  }

  public static boolean isNum(String stringAge)
  {
    boolean isNumber = true;
    int age;
    
    try
    {
      age = Integer.parseInt(stringAge);
    }
    catch(NumberFormatException nfe)
    {
       System.out.println("That is not a number.");
       isNumber = false;
    }

    return isNumber;
  }
}
