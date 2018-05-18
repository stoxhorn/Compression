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
            
            HuffNode z = new HuffNode();
            HuffNode x = new HuffNode(q.extractMin());
            z.setLchild(x);
            HuffNode y = new HuffNode(q.extractMin());
            z.setRchild(y);
            
            z.setFreq(x.getFreq() + y.getFreq());
            //System.out.println(x.getFreq() + y.getFreq());
            //System.out.println(z.getFreq());
            q.insert(new Element(z.getFreq(), z));
            q.printHeap();
            
        }
        //System.out.println(q.getSize());
        return q.extractMin();
    }
    
    
    /*
    Pseudo-kode for Huffmantree
    HUFFMAN(C)
    n = |C|
    Q = C
    for i = 1 to n-1
        allocate a new node z
        z.left = x = EXTRACT-MIN(Q)
        z.rigth = y = EXTRACT-MIN(Q)
        z.freq = x.freq + y.freq
        INSERT(Q,z)
    return EXTRACT-MIN(Q)
    */
        
    
    
    




































    }
    
    
    
    
    
    
    

