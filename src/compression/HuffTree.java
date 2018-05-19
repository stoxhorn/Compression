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
        BotTree tmp = (BotTree) Trees.extractMin().getData();
        
        System.out.println(tmp.getRoot().getRchild());

        
    }
    
    
    
    
    
    
    // if inputnode lower than highest tree, add to PQHeap Trees, as a new BotTree
    public void addElements()
    {
        // Retrieve the first input
        Element input = inputList.extractMin();
        
        // Create new tree
        BotTree newTree = new BotTree();
        
        newTree.insert(new HuffNode(input.getFreq(), (Integer) input.getData()));
        
        // Insert new tree
        Trees.insert(new Element(input.getFreq(),new BotTree()));
        
        // update frequency
        HighFreq = input.getFreq();
        
        // get new input
        input = inputList.extractMin();
        while(input != null)
        {
            // If input frequency is lower than highest frequency
            if(input.getFreq() < HighFreq+1)
            {
                
                //System.out.println();
                //System.out.println("inserting a tree");
                
                // create new tree
                BotTree newTree1 = new BotTree();
                
                newTree1.insert(new HuffNode(input.getFreq(), (Integer) input.getData()));
                
                // insert new tree
                Trees.insert(new Element(input.getFreq(),newTree));
            }
            else if(input.getFreq() > HighFreq)
            {
                //System.out.println();   
                //System.out.println("unifying trees");
                unify(input.getFreq());
                
                // create new tree
                BotTree newTree1 = new BotTree();
                
                newTree1.insert(new HuffNode(input.getFreq(), (Integer) input.getData()));
                
                // insert new tree
                Trees.insert(new Element(input.getFreq(),newTree)); 
                
                
                // add to trees as new tree
                HighFreq = input.getFreq();
                
            }
            
            input = inputList.extractMin();
        }
        
        unify(0);
        
    }
    
    
    /**
     * Recursive method that unifies until the highest frequency is lower than checker
     * 
     * @param checker 
     */
    private void unify(int checker)
    {
        
        if(Trees.getSize() == 1)
        {
            
        }
        else
        {
            // get next tree
            BotTree el1 = (BotTree) Trees.extractMin().getData();
            BotTree el2 = (BotTree) Trees.extractMin().getData();
            //System.out.println("Unifying two trees");
            
            BotTree newTree;
            
            // add root to tree

            el1.insert(el2.getRoot());
            
            // insert the tree
            Trees.insert(new Element(el1.getFreq(), el1));
            
            
            
            
            if(el1.getFreq() > checker)
            {
                // Stop recursion
                HighFreq = el1.getFreq();
            }
            else
            {
                // Recursive call
                unify(checker);
            }
        }
        
        
    }
    
    
    
    
    
    
    
}
