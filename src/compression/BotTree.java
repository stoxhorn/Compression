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
    private BotTree Tree1;
    private BotTree Tree2;
    
    
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
     * @param Tree1
     * @param Tree2
     */
    public BotTree(BotTree Tree1, BotTree Tree2){
        
        HuffNode node1 = Tree1.getRoot();
        
        
        
        HuffNode node2 = Tree2.getRoot();
        
        
        int freq = node1.getFreq() + node2.getFreq();
        
        
        rootNode = new HuffNode(freq);
        
        node2.setParent(rootNode);
        node1.setParent(rootNode);

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
        
        size = 0;
        cursor = 0;


        
        this.Tree1 = Tree1;
        this.Tree2 = Tree2;
    }
    
    public int getFreq()
    {
        int tmp = rootNode.getFreq();
        return tmp;
    }
    
    public HuffNode getRoot()
    {
        HuffNode tmp = rootNode;
        return tmp;
    }
    
    public void printTree(HuffNode node)
    {
        
        if(node.getEl() == null)
        {
            printTree(node.getLchild());
            printTree(node.getRchild());
            
        }
        else
        {
 
            System.out.println("The number: " + node.getEl().getData() + " has this many occurences: " + node.getEl().getFreq());
            
            
        }
        
        
    }
    
}
