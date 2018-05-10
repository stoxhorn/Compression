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
    
    // PQHeap containing Trees, with the first tree being the one with the lowest frequency rootnode
    private PQHeap Trees;
    
    private int HighFreq;
    
    private PQHeap inputList;

    public HuffTree() {
        Trees = new PQHeap(256); 
        this.HighFreq = -1;
    }
    
    
    // if inputnode lower than highest tree, add to PQHeap Trees, as a new BotTree
    public void addElement()
    {
        Element input = inputList.extractMin();
        while(input != null)
        {
            if(input.getFreq() < HighFreq)
            {
                Trees.insert(new Element(new BotTree(new HuffNode(input)), input.getFreq()));
            }
            
            input = inputList.extractMin();
        }

    }
    
    
    // if inputnode higher than highest tree, unify two smallest tree
    // if input node higher than highest tree, but only one tree, add input
    
    
    
    
    
}
