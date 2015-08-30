/*
 * AUTHOR:    Brittany Postnikoff
 * DATE:      2015-05-03
 * DOCUMENT:  Morse Code Converter 
 * PURPOSE:   Converts Morse code to a string, and a string to 
 *              Morse code.
 */

import java.util.*;

public class MorseCodeConverter
{
  public static void main(String[] args)
  {
    String userInput;
    String convertedOutput;
    Scanner input = new Scanner(System.in);

    System.out.println("\nMorse Code Converter");
    System.out.println("====================");
    System.out.print("Please, enter a sentence: ");
    userInput = input.nextLine();
    
    convertedOutput = stringToMorse(userInput);

    System.out.println(convertedOutput + "\n");
  }

  //Converts morse code to a string
  public static String morseToString(String morse)
  {
    String sentence = "";
    String[] parts = morse.split("/");

    return sentence;
  }
  
  //Converts a string to morse code. 
  public static String stringToMorse(String sentence)
  {
    String morse = "";
    sentence = sentence.toLowerCase();

    for(int i = 0; i < sentence.length(); i++)
    {
      switch(sentence.charAt(i))
      {
        case 'a': morse += ".- ";
          break;
        case 'b': morse += "-... ";
          break;
        case 'c': morse += "-.-. ";
          break;
        case 'd': morse += "-.. ";
          break;
        case 'e': morse += ". ";
          break;
        case 'f': morse += "..-. ";
          break;
        case 'g': morse += "--. ";
          break;
        case 'h': morse += ".... ";
          break;
        case 'i': morse += ".. ";
          break;
        case 'j': morse += ".--- ";
          break;
        case 'k': morse += "-.- ";
          break;
        case 'l': morse += ".-.. ";
          break;
        case 'm': morse += "-- ";
          break;
        case 'n': morse += "-. ";
          break;
        case 'o': morse += "--- ";
          break;
        case 'p': morse += ".--. ";
          break;
        case 'q': morse += "--.- ";
          break; 
        case 'r': morse += ".-. ";
          break;
        case 's': morse += "... ";
          break;
        case 't': morse += "- ";
          break;
        case 'u': morse += "..- ";
          break;
        case 'v': morse += "...- ";
          break;
        case 'w': morse += ".-- ";
          break;
        case 'x': morse += "-..- ";
          break;
        case 'y': morse += "-.-- ";
          break;
        case 'z': morse += "--.. ";
          break;
        default: morse += "/ ";
          break;
      }
    }        

    return morse;
  }
}
