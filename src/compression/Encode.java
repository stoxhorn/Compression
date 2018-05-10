/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Stoxhorn
 */
public class Encode {
    
    int[] list;
    
    String str;
    
    /**
     *
     * @param str
     */
    public Encode(String str)
    {
        list = getFrq(str);
        
        //printFreq(list);
        
        PQHeap heap = new PQHeap(256);
        
        int i = 0;
        for(int x : list)
        {
            heap.insert(new Element(x, new Object()));
            i++;
        }
        
        HuffTree huff = new HuffTree(heap);
        
        // for loop extracting min from PQHeap every loop, adding to HuffTree
        // Additions need a new Node obejct
        
    }
    
    private static int[] getFrq(String Str)
    {
        try {
            // String for testing, remember to take index 0 from arguments when finished
            
            
            // Create frequencies
            FileInputStream fin = new FileInputStream(Str);
            int x = 0;
            int[] list = new int[256];
            while((x = fin.read()) != -1){ 
                
                list[x]++;
                //System.out.println(x);
                // Tjek resultat med https://www.asciitable.com/

            }
        
			
			
            return list;
        } catch (IOException e) {
            System.out.println(e);

        }
        return null;
    }
    
    
    
    
    /**
     * Prints out the frquency of each number that has been encountered
     * 
     * @param list 
     */
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
    
    // Remember to copy constructor into main to run with cmd
    public static void main(String[] args) {
        
        
    }

}

