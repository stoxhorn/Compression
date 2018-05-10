package compression;
/**
 * @author Rasmus Bartholin og Mads Mikael Keinicke
 * Rasmus: rbart17
 * Mads: makei17
 */
public class DictBinTree {
    
// Fields
// The root node of the tree
    private HuffNode rootNode;
    
// The current number of Nodes inserted to the tree
    private int size;
    
// A variable that is used by two methods to know the iteration
    private int cursor;
    
    /**
     * Constructor that creates an empty tree
     */
    public DictBinTree(){
        rootNode = null;
        size = 0;
        cursor = 0;
    }
    
    // Need to change
    
    /**
     * Inserts a given node into the tree
     * 
     * @param newNode 
     */
    public void insert(HuffNode newNode){
        
    // Increments size var for object
        size++;
        
    // A temporary HuffNode variable, to compare Nodes
        HuffNode tmp = null;
        
    // A HuffNode used to iterate through the tree
        HuffNode itr = getRoot();
        
    // A loop, that finds the right spot for the new node
        while(itr != null){
            
        // Stores the current node as tmp
            tmp = itr;
            
        // iterates to the correct child, according to the comparison of the two keys
            if(newNode.getFreq() < itr.getFreq()){
            // When newNode is lowest
                itr = itr.getLchild();
            }else{
            // When newNode is highest
                itr = itr.getRchild();
            }
        }
        
    // Sets the parent to be the HuffNode above the iterator, itr.
        newNode.setParent(tmp);
        
    // Sets newNode as root, if tree is empty
    // Else it sets it as the child, decided by the comparison of the two keys
        if(tmp == null){
            setRoot(newNode);
        }
        else if(newNode.getFreq() < tmp.getFreq()){
            tmp.setLchild(newNode);
        }
        else{
            tmp.setRchild(newNode);
        }
    }
    
    /**
     * Iterates through the tree, and returns an int[] of the keys in order, low to high
     * 
     * Is the method that is called to order the entire tree, and not just from a given root,
     * calls a similar, but overloaded method, as a helpermethod
     * 
     * @return int[] an int[] containing ordered keys
     */
    public int[] orderedTraversal(){
        
    // Gets the root node to start at, and creates an int[] of the same saize as the tree
        HuffNode x = getRoot();
 	int[] list = new int[size];
        
    // Sets the cursor variable to 0, incase it is not
    // 1. if tree is not empty, call the private helpermethod, on the left child
    // 2. then insert key of the root into the list
    // 3. increment cursor
    // 4. call same method on the right child
    // 5. reset cursor
        cursor = 0;
  	if (x!=null){
            list = orderedTraversal(x.getLchild(), list);
            list[cursor] = x.getFreq();
            cursor++;
            list = orderedTraversal(x.getRchild(), list);
  	}
        cursor = 0;
    
        // Return the newly ordered list
        return list;
    }
    /**
     * A private helper method for the public method of the same name
     * 
     * 1. Calls itself recursively, updating a given list with that of the call with the left child
 2. Adds the key of the current HuffNode
 3. increments the cursor
 4. Calls itself recursively again, but on the right child
     * 
     * @param x     HuffNode    A HuffNode that is used as the current node to Order from
     * @param list  int[]   An int[] that contains the current order of keys
     * @return      int[]   An int[] that contains the newly added keys
     */
    private int[] orderedTraversal(HuffNode x, int[] list){
        
    // If tree is not empty, update list with recursive call, with the left child
    // Add current key to list, increment cursor and update with the right child
        if (x!=null){
            list = orderedTraversal(x.getLchild(), list);
            list[cursor] = x.getFreq();
            cursor++;
            list = orderedTraversal(x.getRchild(), list);
        }
    return list;
    }  	
    
    /**
     * Iterates through the entiire tree, and returns true, if the key exists
     * 
     * Uses an overloaded helper method, as the search needs to be started from the root
     * 
     * @param   k       int that represents the key searched for
     * @return  boolean A boolean that represents whether a key exists in tree or not
     */
    public boolean search(int k){
        
    // Gets the root of the tree
        HuffNode itr = getRoot();
        
    // If the tree is empty, or the HuffNode has the key searched for,
    // return the opposite of the root being null
        if(itr == null || k == itr.getFreq()){
            return !(itr == null);
        }
    
    // Calls helper method on left child, if the key searched for is lower than the current one
    // Otherwise, it calls the helper method on the right child
        if(k < itr.getFreq()){
            return search(itr.getLchild(), k);
        }
        else{
            return search(itr.getRchild(), k);
        }
    }
    
    
    /**
     * private overloaded helpermethod for search()
     * 
     * Calls itself recursively, until the given key is found, 
     * or it has iterated through the entire tree
     * Returns false if not in tree, and true otherwise
     * 
     * @param itr   The HuffNode, whose key that is to be checked
     * @param k     the key to check for
     * @return boolean  A boolean telling if key exists or not
     */
    private boolean search(HuffNode itr, int k){
        
    // If the current HuffNode contains the key, return true
    // if the HuffNode is empty, return false
        if(itr == null || k == itr.getFreq()){
            return !(itr == null);
        }

    // Check left child, if key is lower that current HuffNode's key
        if(k < itr.getFreq()){
            return search(itr.getLchild(), k);
        }
    
    // Check right child, if key is lower that current HuffNode's key
        else{
            return search(itr.getRchild(), k);
        }
    }
    
    /**
     * getter for the rootNode
     * 
     * @return HuffNode
     */
    public HuffNode getRoot(){
        return this.rootNode;
    }
    
    /**
     * setter for the rootNode
     * 
     * @param newNode HuffNode, the HuffNode to be set
     */
    public void setRoot(HuffNode newNode){
        this.rootNode = newNode;
    }
}
