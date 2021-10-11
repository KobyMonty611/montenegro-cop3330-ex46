/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Koby Montenegro
 */

package ex46;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class App 
{
   public static void main(String[] args) throws FileNotFoundException
   {
       //Create ReadFile object
       ReadFile read = new ReadFile();

       //Read info from the input file
       read.readTheInfo();

       //Create a map using the info from the input file
       HashMap<String, Integer> map = read.getMap();

       //Create PrintFrequency Object
       PrintFrequency print = new PrintFrequency(map);

       //Print
       print.printScreen();
   }

}