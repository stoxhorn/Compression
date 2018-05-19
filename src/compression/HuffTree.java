/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compression;

/**
 *
 * @author Stoxhorn
 */
public class HuffTree {
    

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
            
            // Right child
            HuffNode y = new HuffNode(q.extractMin());
            z.setRchild(y);
            
            // Set frequency of new child
            z.setFreq(x.getFreq() + y.getFreq());
            
            // Insert to heap
            q.insert(new Element(z.getFreq(), z));
        }
        return q.extractMin();
    }


}
    
    
    
    
    
    
    

