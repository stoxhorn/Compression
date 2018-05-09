/**
 * @author Rasmus Bartholin og Mads Mikael Keinicke
 * Rasmus: rbart17
 * Mads: makei17
 */
public class Node{

// Field

// The key of the Node
    private final int key;

// Nodes representing potential related Nodes    
    private Node rchild = null;
    private Node lchild = null;
    private Node parent = null;
  
    /**
     * Constructor, takes an int, that is used as key for Node
     * 
     * @param key int
     */
    public Node(int key){
        this.key = key;
    }

    /**
     * Getter for the Node's key
     * 
     * @return int key of the Node
     */
    public int getKey(){
        return this.key;
    }
  
    
    /**
     * Getter for the Node's right child
     * 
     * @return Node right child of the Node
     */
    public Node getRchild(){
        return this.rchild;
    }
  
    /**
     * Getter for the Node's left child
     * 
     * @return Node left child of the Node
     */
    public Node getLchild(){
        return this.lchild;
    }
	
    /**
     * Getter for the Node's parent
     * 
     * @return Node parent of the Node
     */
    public Node getParent(){
        return this.parent;
    }  
    
    /**
     * Setter for the Node's right child
     * 
     * @param newNode Node, new right child of the Node
     */
    public void setRchild(Node newNode){
        this.rchild = newNode;
    }
    
    /**
     * Setter for the Node's left child
     * 
     * @param newNode Node, new left child of the Node
     */
    public void setLchild(Node newNode){
        this.lchild = newNode;
    }

    /**
     * Setter for the Node's parent
     * 
     * @param newNode Node, new parent of the Node
     */
    public void setParent(Node newNode){
        this.parent = newNode;
    }
}



