package compression;

import java.io.*;
import java.util.*;

public class Main {

    private static void printFreq(int[] list)
    {
        ArrayList<String> arList = new ArrayList();
        int i = 0;
        String tmp;
        for(int str : list)
        {
            tmp = String.valueOf(i);
            if(str == 0)
            {
            }
            else
            {
                tmp += ": ";
                tmp += String.valueOf(str);
                arList.add(tmp);
            }
            i++;
        }
        System.out.println(Arrays.toString(arList.toArray()));
    }
    
    public static void main(String[] args) {
        try {
            // String for testing, remember to take index 0 from arguments when finished
            String testStr = "C:\\Users\\Stoxhorn\\Desktop\\CurrentProjects\\Compression\\Test.txt";
            
            FileInputStream fin = new FileInputStream(testStr);
			int x = 0;
			int[] list = new int[256];
            while((x = fin.read()) != -1){ 
			list[x]++;
                System.out.println(x);
				// Tjek resultat med https://www.asciitable.com/

            }
        printFreq(list);
			
			

        } catch (IOException e) {
            System.out.println(e);

        }
    }
}
