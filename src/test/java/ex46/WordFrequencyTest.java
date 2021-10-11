package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyTest
{
    @Test
    void readTheInfo() throws FileNotFoundException
    {
        //Allows the file to be accessed
        File test46 = new File("src/main/java/ex46/exercise46_input.txt");

        //Initialize map
        HashMap<String, Integer> expectedMap;
        HashMap<String, Integer> actualMap;
        actualMap = new HashMap<String,Integer>();
        expectedMap = new HashMap<String,Integer>();

        expectedMap.put("snake", 1);
        expectedMap.put("mushroom", 2);
        expectedMap.put("badger", 7);
        Scanner scan = new Scanner(test46);

        try
        {
            while(scan.hasNext())
            {
                //Read input lines and then splits it whenever there is a space
                String inputInfo = scan.nextLine();
                String inputArray[] = inputInfo.split(" ");

                //Use this to check if a word(key) has appeared
                for(int i=0;i<inputArray.length;i++)
                {
                    String key = inputArray[i];

                    //add 1 to count if a word(key) has appeared
                    if(actualMap.containsKey(key))
                    {
                        int count = actualMap.get(key);
                        count++;

                        actualMap.put(key, count);
                    }

                    //Use this
                    else
                    {
                        actualMap.put(key, 1);
                    }
                }
            }
        }
        finally
        {
            scan.close();
        }

        //THIS IS WHERE THE COMPARISON HAPPENS
        assertEquals(expectedMap, actualMap);
    }

    @Test
    void PrintFrequency() throws IOException
    {
        //Allows the file to be accessed
        File test46 = new File("src/main/java/ex46/exercise46_input.txt");

        //Initialize map
        HashMap<String, Integer> expectedMap;
        HashMap<String, Integer> actualMap;
        actualMap = new HashMap<String,Integer>();
        expectedMap = new HashMap<String,Integer>();

        expectedMap.put("snake", 1);
        expectedMap.put("mushroom", 2);
        expectedMap.put("badger", 7);
        Scanner scan = new Scanner(test46);

        //Scan in all the info again
        try
        {
            while(scan.hasNext())
            {
                //Read input lines and then splits it whenever there is a space
                String inputInfo = scan.nextLine();
                String inputArray[] = inputInfo.split(" ");

                //Use this to check if a word(key) has appeared
                for(int i=0;i<inputArray.length;i++)
                {
                    String key = inputArray[i];

                    //add 1 to count if a word(key) has appeared
                    if(actualMap.containsKey(key))
                    {
                        int count = actualMap.get(key);
                        count++;

                        actualMap.put(key, count);
                    }

                    //Use this
                    else
                    {
                        actualMap.put(key, 1);
                    }
                }
            }
        }
        finally
        {
            scan.close();
        }



        //Use arrays to store keys and values for the map
        String keys[] = new String[actualMap.size()];
        Integer values[] = new Integer[actualMap.size()];
        int k=0;

        //Store map values
        for (Map.Entry<String, Integer> entry : actualMap.entrySet())
        {
            keys[k] = entry.getKey();
            values[k++] = entry.getValue();
        }

        //This set of arrays is to store copied values
        int copyValues[] = new int[actualMap.size()];
        String copyKeys[] = new String[actualMap.size()];

        //Copy original array values to the temporary ones
        for(int i=0;i<values.length;i++)
        {
            copyValues[i] = values[i];
        }

        //Reverse the value array
        Arrays.sort(values, Collections.reverseOrder());

        //Sort the keys array by values and store it in the copyArrays
        for(int i=0; i<actualMap.size();i++)
        {
            int value = values[i];

            for(int j=0; j<copyValues.length;j++)
            {
                if(value == copyValues[j])
                {
                    copyKeys[i] = keys[j];
                    break;
                }
            }
        }

        String exOut = "badger:   *******\n" +
                "mushroom: **\n" +
                "snake:    *";

        //This is where the actual printing happens
        for(int i=0;i<actualMap.size();i++)
        {
            //Print the animal name
            String actOut="";
            int value = actualMap.get(copyKeys[i]);
            String animalName = (copyKeys[i]+":");
            actOut += String.format("%n%-10s", animalName);

            //Print the frequency
            for(int j=0; j<value; j++)
            {
                actOut += ("*");
            }

            //COMPARISON HAPPENS HERE
            if(i==actualMap.size())
            {
                assertEquals(exOut, actOut);
            }
        }
    }
}
