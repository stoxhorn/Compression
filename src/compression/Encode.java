/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import Compression.BitOutputStream;

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
        // Create list of frequencies, ordered by unicode number
        list = getFrq(str);
        
        // Create a heap of the frequencies, and their unicode nubmer
        PQHeap heap = createHeap(list);
        
        // Create the HuffTree Object
        HuffTree huff = new HuffTree();
        
        // retrieve the Element containing the created Huffman Tree 
        Element tmp = huff.HuffUnify(heap);
        
        // cast the Tree root from Object to HuffNode
        HuffNode root = (HuffNode) tmp.getData();
        
        // Acquire the Array of bitcodes for each unicode character
        String[] bitCode = huff.findCode(root);
        
        // Print the bitcodes out
        /*int d = 0;
        for(String x : bitCode)
        {
            System.out.println(d + ": " + x);
            d++;
        }*/
                
        // Print out the frequencies above 0:
        printFreq(list);
        
        writeOutput(str, bitCode);
        
    }
    
    private PQHeap createHeap(int[] list)
    {
        PQHeap heap = new PQHeap(256);
        
        
        // Inserts unicode frequency into heap
        int i = 0;
        for(int x : list)
        {
            heap.insert(new Element(x, i));
            i++;
        }
        return heap;
    }
    
    /**Method that gives the frequency of the different strings in a file. 
     * 
     * @param Str
     * @return 
     */
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
    
    public void writeOutput(String filePath, String[] bitCode)
    {
        try {
            // String for testing, remember to take index 0 from arguments when finished
            
            
            // Create frequencies
            FileInputStream fin = new FileInputStream(filePath);
            

            try(FileOutputStream output = new FileOutputStream("C:\\Users\\Stoxhorn\\Desktop\\Vigtige filer\\Uni\\Projekter\\CurrentProjects\\Compression\\Test1.txt")) {
                BitOutputStream bitStream = new BitOutputStream(output);
                
                    while(fin.available() != 0)
                    {
                        int nextByte = fin.read();
                        String outPut = bitCode[nextByte];
                        
                        bitStream.writeInt(Integer.parseInt(outPut));
                    }

                
                
                
            }catch(NullPointerException e)
            {
                System.out.println(e);
            }
            
			
			
        } catch (IOException e) {
            System.out.println(e);

        }
    }
    
    // Remember to copy constructor into main to run with cmd
    public static void main(String[] args) {
        
        
    }

}

