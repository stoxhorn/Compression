
package compression;

/**
 * @author Rasmus Bartholin og Mads Mikael Keinicke
 * Rasmus: rbart17
 * Mads: makei17
 */
public class HuffNode{

// Field

// The freq of the HuffNode
    private final int freq;
    private final int data;
    
    
// Nodes representing potential related Nodes    
    private HuffNode rchild = null;
    private HuffNode lchild = null;
    private HuffNode parent = null;
  
    /**
     * Constructor, takes an int, that is used as freq for Node
     * 
     * @param freq
     */
    public HuffNode(int freq){
        this.freq = freq;
        this.data = -1;
    }
    
    /**
     * Constructor, takes an int, that is used as freq for Node
     * 
     * @param freq
     * @param data
     */
    public HuffNode(int freq, int data){
        
        
        this.freq = freq;
        this.data = data;
     //   System.out.println("new HuffNode with frequence of: " + freq);
    }

    /**
     * Getter for the HuffNode's freq
     * 
     * @return int freq of the HuffNode
     */
    public int getFreq(){
        return this.freq;
    }
  
    
    /**
     * Getter for the HuffNode's right child
     * 
     * @return HuffNode right child of the HuffNode
     */
    public HuffNode getRchild(){
        return this.rchild;
    }
  
    /**
     * Getter for the HuffNode's left child
     * 
     * @return HuffNode left child of the HuffNode
     */
    public HuffNode getLchild(){
        return this.lchild;
    }
	
    /**
     * Getter for the HuffNode's parent
     * 
     * @return HuffNode parent of the HuffNode
     */
    public HuffNode getParent(){
        return this.parent;
    }  
    
    /**
     * Setter for the HuffNode's right child
     * 
     * @param newNode HuffNode, new right child of the HuffNode
     */
    public void setRchild(HuffNode newNode){
        this.rchild = newNode;
    }
    
    /**
     * Setter for the HuffNode's left child
     * 
     * @param newNode HuffNode, new left child of the HuffNode
     */
    public void setLchild(HuffNode newNode){
        this.lchild = newNode;
    }

    /**
     * Setter for the HuffNode's parent
     * 
     * @param newNode HuffNode, new parent of the HuffNode
     */
    public void setParent(HuffNode newNode){
        this.parent = newNode;
    }
    
    public int getEl()
    {
        int tmp = data;
        return tmp;
    }
    
}



