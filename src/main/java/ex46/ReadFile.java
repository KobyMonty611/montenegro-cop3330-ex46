package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

class ReadFile
{
    //Attributes
    private HashMap<String, Integer> map;
    private File inputFile;
    private Scanner scan;

    //Constructor
    public ReadFile() throws FileNotFoundException
    {
        inputFile = new File("src/main/java/ex46/exercise46_input.txt");
        map = new HashMap<String, Integer>();
        scan = new Scanner(inputFile);
    }

    public void readTheInfo()
    {
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

                    //Add 1 to count if a word(key) has appeared
                    if(map.containsKey(key))
                    {
                        int count = map.get(key);
                        count++;

                        map.put(key, count);
                    }
                    else
                    {
                        map.put(key, 1);
                    }
                }
            }
        }
        finally
        {
            scan.close();
        }
    }

    //Returns the info to App
    public HashMap<String, Integer> getMap()
    {
        return map;
    }
}
