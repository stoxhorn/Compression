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
        System.out.println("new botTree with frequence: "  + rootNode.getFreq());
    }
        
    /**
     * Constructor that creates an empty tree
     * @param Tree1
     * @param Tree2
     */
    public BotTree(BotTree Tree1, BotTree Tree2){
        System.out.println(Tree1.getFreq());
        HuffNode node1 = Tree1.getRoot();
        System.out.println(node1.getFreq());
        
        System.out.println(Tree2.getFreq());
        HuffNode node2 = Tree2.getRoot();
        System.out.println(node2.getFreq());
        
        int freq = node1.getFreq() + node2.getFreq();
        System.out.println("given Freeq: " + freq);
        
        rootNode = new HuffNode(freq);
        System.out.println("actual freq: " + rootNode.getFreq());
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
