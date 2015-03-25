/*
 * Small state machine that prints 1 only after seeing the pattern 110, 
 *   otherwise a 0 is printed. 
 * 2015 - 03 - 25
 * Brittany Postnikoff
 */

import java.util.*;

public class StateMachine
{
  public static void main(String[] args)
  {
    //Variable declarations.
    String input;
    int inputBit;
    int state = 0;
    Scanner scanner = new Scanner(System.in);

    //Takes in one bit at a time from the user to adjust the
    //  current state.
    do
    {
      input = scanner.nextLine(); //Reads input from user.
      inputBit = Integer.parseInt(input); //Converts string to integer.

      if(inputBit == 1 || inputBit == 0)
      {
        state = nextState(inputBit, state);
        printInformation(inputBit, state);
      }
    }while(inputBit!= 2);
  }

  /*
   * nextState(int inputBit, int state)
   * 
   * Purpose: Adjusts the state based on the current state, and the input
   *            bit received.
   * @param   int inputBit    The bit received from the user.
   *          int state       A numerical representation of the current state.
   * @return  int state       Returns the adjusted state.   
   */
  public static int nextState(int inputBit, int state)
  {
    switch(state)
    {
      case 0:
        if(inputBit == 1)
        {
          state = 1;
        }

        //State remains the same if a 0 is received.

        break;

      case 1:
        if(inputBit == 1)
        {
          state = 2;
        }
        else if(inputBit == 0)
        {
          state = 0;
        }

        break;

      case 2:
        if(inputBit == 0)
        {
          state = 3;
        }

        //State remains the same if a 1 is received.

        break;

      case 3:
        if(inputBit == 0)
        {
          state = 0;
        }
        else if(inputBit == 1)
        {
          state = 1;
        }

        break;
    }

    return state;
  }

  /*
   * printInformation(int inputBit, int state)
   *
   * PURPOSE:  Prints out input as described by the program purpose.
   *
   * @param    int inputBit    The input bit received from the user.
   * @param    int state       The current state of the state machine.
   */
  public static void printInformation(int inputBit, int state)
  {
    //Output tree that uses the state to print out either a 1 or 0 as needed.
    System.out.print("State: " + state + " bit: " + inputBit + " Output:");

    if (state == 3)
    {
      System.out.print(" 1\n");        } 
    else
    {
      System.out.print(" 0\n");
    } 
  }
}
