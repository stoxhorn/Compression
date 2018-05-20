/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compression;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stoxhorn
 */
public class Decode {
    public Decode(String str, String oldStr)
    {
        int[] freqs = getFrq(oldStr);
        
        PQHeap heap = createHeap(freqs);
        
        HuffTree huff = new HuffTree();
        
        Element tmp = huff.HuffUnify(heap);
        
        HuffNode root = (HuffNode) tmp.getData();
        
        String[] bitCode = huff.findCode(root);
        
        // Need int to keep track of missing characters
        int charsLeft = 0;
        
        for(int x : freqs)
        {
            charsLeft+= x;
        }
        System.out.println(charsLeft);
        
        
        decodeInput(str, bitCode, charsLeft, root);
        
    }
    
    
    public void decodeInput(String inputFile, String[] bitCode, int charsLeft, HuffNode root)
    {
        try {
            // String for testing, remember to take index 0 from arguments when finished
            
            
            // Create frequencies
            FileInputStream fin = new FileInputStream(inputFile);
            BitInputStream inpStream = new BitInputStream(fin);

            try(FileOutputStream output = new FileOutputStream("C:\\Users\\Stoxhorn\\Desktop\\Vigtige filer\\Uni\\Projekter\\CurrentProjects\\Compression\\TestFinal.txt")) {
                
                    while(charsLeft > 0)
                    {
                        
                        int nextBit = inpStream.readBit();
                        HuffNode tmp = root;
                        
                        // Loop to get the next char
                        while(true)
                        {
                            if(nextBit == 0)
                            {
                                tmp = tmp.getLchild();
                            }
                            else if(nextBit == 1)
                            {
                                tmp = tmp.getRchild();
                            }
                            if(tmp.getData() != null)
                            {
                                break;
                            }
                            else if(nextBit == -1)
                            {
                                break;
                            }
                            nextBit = inpStream.readBit();
                        }
                        int outPut = (int) tmp.getData();
                        output.write(outPut);
                        
                        
                        charsLeft --;

                        
                    }
                inpStream.close();
                output.close();
                
                    
            }
            catch(NullPointerException e)
            {
                System.out.println(e);
            }
            
			
			
        } catch (IOException e) {
            System.out.println(e);

        }
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
}
