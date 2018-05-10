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
public class BotTree {
    // Fields
    // The root node of the tree
        private HuffNode rootNode;

    // The current number of Nodes inserted to the tree
        private int size;

    // A variable that is used by two methods to know the iteration
        private int cursor;
    
    
    /**
     * Constructor that creates an empty tree
     * @param node1
     */
    public BotTree(HuffNode node1){
        rootNode = node1;
        size = 0;
        cursor = 0;
    }
        
    /**
     * Constructor that creates an empty tree
     * @param node1
     * @param node2
     */
    public BotTree(HuffNode node1, HuffNode node2){
        int freq = node1.getFreq() + node2.getFreq();
        
        if(node1.getFreq() < node2.getFreq())
        {
            rootNode.setLchild(node1);
            rootNode.setRchild(node2);
        }
        else
        {
            rootNode.setLchild(node2);
            rootNode.setRchild(node1);
        }
        rootNode = new HuffNode(freq);
        size = 0;
        cursor = 0;
    }
    
    public int getFreq()
    {
        int tmp = rootNode.getFreq();
        return tmp;
    }
    
}
