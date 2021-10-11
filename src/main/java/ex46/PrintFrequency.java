package ex46;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

class PrintFrequency
{
    //Attribute
    private HashMap<String, Integer> map;

    //Constructor
    public PrintFrequency(HashMap<String, Integer> map)
    {
        this.map = map;
    }

    //This function prints
    public void printScreen()
    {
        //Use arrays to store keys and values for the map
        String keys[] = new String[map.size()];
        Integer values[] = new Integer[map.size()];
        int k=0;

        //Store map values
        for (Entry<String, Integer> entry : map.entrySet())
        {
            keys[k] = entry.getKey();
            values[k++] = entry.getValue();
        }

        //This set of arrays is to store copied values
        int copyValues[] = new int[map.size()];
        String copyKeys[] = new String[map.size()];

        //Copy original array values to the temporary ones
        for(int i=0;i<values.length;i++)
        {
            copyValues[i] = values[i];
        }

        //Reverse the value array
        Arrays.sort(values, Collections.reverseOrder());

        //Sort the keys array by values and store it in the copyArrays
        for(int i=0; i<map.size();i++)
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

        System.out.println();

        //This is where the actual printing happens
        for(int i=0;i<map.size();i++)
        {
            //Print the animal name
            int value = map.get(copyKeys[i]);
            String animalName = (copyKeys[i]+":");
            System.out.print(String.format("%n %-10s", animalName));

            //Print the frequency
            for(int j=0; j<value; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}