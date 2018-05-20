/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compression;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Stoxhorn
 */
public class HuffTree {
    
    ArrayList<String> codes = new ArrayList<>();
    
    public HuffTree() {
        
    }
    
    public Element HuffUnify(PQHeap heap)
    {
        int n = heap.getSize();
        PQHeap q = heap;
        for(int i = 1; i < n; i++)
        {
            // New Parentnode
            HuffNode z = new HuffNode();
            
            // Left child
            HuffNode x = new HuffNode(q.extractMin());
            z.setLchild(x);
            x.setParent(z);
            
            // Right child
            HuffNode y = new HuffNode(q.extractMin());
            z.setRchild(y);
            y.setParent(z);
            
            // Set frequency of new child
            z.setFreq(x.getFreq() + y.getFreq());
            
            //System.out.println(z);
            //System.out.println(z.getLchild() + " --- " + z.getRchild());
            //System.out.println(z.getLchild().getLchild() + " --- "  + z.getLchild().getRchild() + " --- " + z.getRchild().getLchild()  + " --- " +  z.getRchild().getRchild());
            

            // Insert to heap
            q.insert(new Element(z.getFreq(), z));
        }
        // return the final node as the rootnode of the lsit
        return q.extractMin();
    }

    
    
    
    
    
    
    public int[] findCode(HuffNode rootNode)
    {
        HuffNode root = rootNode;
        
        int[] list = new int[256];
        
        
        if(root != null)
        {
            list = findCode(root.getLchild(), list, 10);
            list = findCode(root.getRchild(), list, 11);
        }
        return list;
    }
    
    private int[] findCode(HuffNode node, int[] oldList, int bitCode)
    {
        int newBit = bitCode;
        int[] newList = oldList;
        
        // Base case missing here
        // Test if leaf
        if(true && node.getLchild() == null && node.getRchild() == null)
        {
            int index = (Integer) node.getData();
            // add bitcode to lsit
            String tmp = String.valueOf(newBit);
            int l = tmp.length();
            
            newBit = (int) (newBit - (Math.pow(10, l-1)));
            newList[index] = newBit;
            
            // return the new list
            return newList;
        }
        // general case both childs exist
        else {
            newBit = newBit*10;
            // if node exists
            if(node != null)
            {
                // go left with new bitcode and update list
                newList = findCode(node.getLchild(), newList, newBit);
                
                // go right with new bitcode and update list
                newList = findCode(node.getRchild(), newList, newBit+1);
            }
            return newList;
        }
    }
    
    
}
    
    
    
    
    
    
    

