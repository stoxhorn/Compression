/**
 *
 * @author Rasmus Bartholin og Mads Mikael Keinicke
 * Rasmus: rbart17
 * Mads: makei17
 */
public class HuffNode{

// Field

// The freq of the HuffNode
    private int freq;
    private final Object data;
    
    
// Nodes representing potential related Nodes    
    public HuffNode rchild = null;
    public HuffNode lchild = null;
    public HuffNode parent = null;
  
    /**
     * Constructor, takes an int, that is used as freq for Node
     * 
     * @param newFreq
     */
    HuffNode(){
        freq = -1;
        data = null;
    }
   
    /**
     * Constructor, takes an int, that is used as freq for Node
     * 
     * @param newFreq
     */
    HuffNode(int newFreq, Object newData){
        freq = newFreq;
        data = newData;
    }
    
    /**
     * Constructor for converting an element to a HuffNode
     * 
     * @param newFreq
     */
    HuffNode(Element el){
        freq = el.getFreq();
        
        if(el.getData().getClass() == HuffNode.class)
        {
            HuffNode tmp = (HuffNode) el.getData();
            data = null;
            rchild = tmp.getRchild();
            lchild = tmp.getLchild();
            parent = tmp.getParent();
        }
        else
        {
            data = el.getData();
        }
        
    }
    
    
    /**
     * Getter for the HuffNode's freq
     * 
     * @param newFreq
     */
    public void setFreq(int newFreq){
        freq = newFreq;
    }
    
    /**
     * Getter for the HuffNode's freq
     * 
     * @return int freq of the HuffNode
     */
    public int getFreq(){
        int tmp = freq;
        return tmp;
    }
  
    /**
     * Getter for the HuffNode's freq
     * 
     * @return int freq of the HuffNode
     */
    public Object getData(){
        Object tmp = data;
        return tmp;
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
     * @param newNode HuffNode, new right child of the HuffNodeSystem.out.println();
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
    
}



