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

    public HuffTree(PQHeap newInput) {
        inputList = newInput;
        
        Trees = new PQHeap(256); 
        this.HighFreq = -1;
        
        addElements();
        
    }
    
    
    
    
    
    
    // if inputnode lower than highest tree, add to PQHeap Trees, as a new BotTree
    public void addElements()
    {
        // Retrieve the first input
        TreeElement input = inputList.extractMin();
        Trees.insert(new TreeElement(input.getFreq(),new BotTree(new HuffNode(input))));
        HighFreq = input.getFreq();
        
        while(input != null)
        {
            // If input frequency is lower than highest frequency
            if(input.getFreq() < HighFreq)
            {
                // add to trees as new tree
                Trees.insert(new TreeElement(input.getFreq(),new BotTree(new HuffNode(input))));
            }
            else if(input.getFreq() > HighFreq)
            {
                unify(input.getFreq());
                // add to trees as new tree
                Trees.insert(new TreeElement(input.getFreq(),new BotTree(new HuffNode(input))));
            }
            input = inputList.extractMin();
        }

    }
    
    
    /**
     * Recursive method that unifies until the highest frequency is lower than checker
     * 
     * @param checker 
     */
    private void unify(int checker)
    {
        if(Trees.getSize() == 0)
        {
        }
        else
        {
            TreeElement el1 = Trees.extractMin();
            TreeElement el2 = Trees.extractMin();

            BotTree newTree;

            newTree = new BotTree(el1.getData(), el2.getData());
            Trees.insert(new TreeElement(newTree.getFreq(), newTree));

            if(newTree.getFreq() > checker)
            {
                // Stop recursion
                HighFreq = newTree.getFreq();
            }
            else
            {
                // Recursive call
                unify(checker);
            }
        }
        
    }
    
    
    
    
    
    
    
}
