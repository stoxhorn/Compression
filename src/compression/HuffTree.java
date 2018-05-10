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
        
        
        /*
        BotTree tmp  = (BotTree) Trees.extractMin().getData();
        tmp.printTree(tmp.getRoot());
*/
        
    }
    
    
    
    
    
    
    // if inputnode lower than highest tree, add to PQHeap Trees, as a new BotTree
    public void addElements()
    {
        // Retrieve the first input
        Element input = inputList.extractMin();
        Trees.insert(new Element(input.getFreq(),new BotTree(new HuffNode(input))));
        HighFreq = input.getFreq();
        input = inputList.extractMin();
        while(input != null)
        {
            // If input frequency is lower than highest frequency
            if(input.getFreq() < HighFreq+1)
            {
                // add to trees as new tree
                Trees.insert(new Element(input.getFreq(),new BotTree(new HuffNode(input))));
                HighFreq = input.getFreq();
            }
            else if(input.getFreq() > HighFreq)
            {
                System.out.println("high freq: " + input.getFreq());
                System.out.println("unifying with checker at " + input.getFreq());
                unify(input.getFreq());
                System.out.println("adding Frequency: " + input.getFreq() + " to the list");
                Trees.insert(new Element(input.getFreq(), new BotTree(new HuffNode(input)))); 
                
                
                // add to trees as new tree
                HighFreq = input.getFreq();
                
            }
            System.out.println("old freq: " + input.getFreq());
            input = inputList.extractMin();
        }
        System.out.println(Trees.getSize());
        Element tmp = Trees.extractMin();
        System.out.println("Tree frequence 1 = " + tmp.getFreq());
        System.out.println(Trees.getSize());
        Element tmp1 = Trees.extractMin();
        System.out.println("Tree frequence 2 = " + tmp1.getFreq());
        System.out.println(Trees.getSize());
        
        
        Trees.insert(tmp);
        Trees.insert(tmp1);
        Trees.insert(tmp3);
        
        System.out.println("last unify, TreeSize: " + Trees.getSize());
        unify(0);
        
    }
    
    
    /**
     * Recursive method that unifies until the highest frequency is lower than checker
     * 
     * @param checker 
     */
    private void unify(int checker)
    {
        System.out.println("checker: " + checker);
        if(Trees.getSize() == 1)
        {
            System.out.println("soptted");
        }
        else
        {
            Element el1 = Trees.extractMin();
            Element el2 = Trees.extractMin();
            
            BotTree newTree;
            System.out.println((BotTree) el1.getData());
            System.out.println(el1.getFreq());
            System.out.println((BotTree) el2.getData());
            System.out.println(el2.getFreq());
            newTree = new BotTree((BotTree) el1.getData(),(BotTree) el2.getData());
            Trees.insert(new Element(newTree.getFreq(), newTree));
            
            
            
            System.out.println("newTree freq: " + newTree.getFreq());
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
