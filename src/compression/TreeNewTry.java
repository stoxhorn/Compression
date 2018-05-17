
package compression;

/**
 *
 * @author barth
 */
public class TreeNewTry {
        /*
    Start med at udtage de to første elementer fra din heap. lav dem til en node, der har en freq der er den sammlagte af de to noders
    og 2 børn, som besår af de 2 noder. Indsæt derefter denne node i din PQHeap. Så kommer den automatisk til at være det rette sted, og
    derefter kan du kører koden igen, indtil din PQHeap er tom.
    
    */
    private HuffNode parent;
    private PQHeap nodes;
    private int highFreq;


    
    
    /*
    Pseudo-kode for Huffmantree
    HUFFMAN(C)
    n = |C|
    Q = C
    for i = 1 to n-1
        allocate a new node z
        z.left = x = EXTRACT-MIN(Q)
        z.rigth = y = EXTRACT-MIN(Q)
        z.freq = x.freq + y.freq
        INSERT(Q,z)
    return EXTRACT-MIN(Q)
    */
    
    
    public TreeNewTry(PQHeap nodes){
        this.nodes = nodes;
    }
    
    public Element buildTree(PQHeap heap){
        int n = 256;
        // Q = C er vist bare vores PQHeap
        
        for(int i = 1; i < n-1; i++){
            Element z = new Element();
            
            
            Element x = heap.extractMin();
            z.setLChild(x);
            
            
            Element y = heap.extractMin();
            
            
            z.setFreq(x.getFreq() + y.getFreq());
            heap.i;
            
            
            
            
          
        }
        return heap.extractMin();
    }
    
}
