package compression;

import java.util.List;

/**
 *
 * @author barth
 */
public class Tree {

    private PQHeap nodes;
    private static PQHeap treeHeap = null;
    private int highFreq;
    private HuffNode parent;
    private PQHeap inputList;
    private static List<Tree> listTree;
    /*
    Start med at udtage de to første elementer fra din heap. lav dem til en node, der har en freq der er den sammlagte af de to noders
    og 2 børn, som besår af de 2 noder. Indsæt derefter denne node i din PQHeap. Så kommer den automatisk til at være det rette sted, og
    derefter kan du kører koden igen, indtil din PQHeap er tom.
    
    */
    
    
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


    /**
     * Constructor for Tree.
     *
     * @param root
     */
    public Tree(HuffNode root) {
        this.parent = parent;
        // Problemet er, at et træ har ikke børn, men det har noder. Så jeg skal tilføje en node til et træ, som kun består af en 
        // freq, og den skal så have et højre og venstre barn

    }

    public void buildTree() {
        // Hold the fist element in the list of elements.
        Element current = nodes.extractMin();
        HuffNode current1 = new HuffNode(current.freq,current.data);
        Element currentNext = nodes.extractMin(); //Tag det næste element i listen, sørg for den kan håndtere at trække et uliget tal, tjek med size.
        HuffNode currentNext2 = new HuffNode(currentNext.freq,current.data);
        // sammenlign noden med alle træer i listen, måske kunne man bruge heap igen til at den altid holder på den mindste som den forreste?
        // Det skal jeg faktisk, jeg skal have det mindste træ altid. Her kan der godt være et mindre træ der gemmer sig længere nede af listen.
        // Jeg skal bruge en metode i PQHeap som kigger på den første element i heapen, uden at slette det. 
        for (int i = 0; i < listTree.size(); i++) {
            if (treeHeap.lookMin() <= current.freq && treeHeap.lookMin() < currentNext.freq) {
                
                // sæt træ sammen med node, sæt altid node til højre, ligesom du altid sætter den højeste node til højre. 
                // Jeg skal bruge en motode i PQHeap, som retunere et træ, som jeg kan tilføjge en node til.
                insertNodeToTree(listTree.get(i),new HuffNode(current));

            }
            
            if(treeHeap.lookMin() > current1.getFreq() && treeHeap.lookMin() > currentNext2.getFreq() ){
               

                listTree.add(new Tree(new HuffNode(current.freq + currentNext.freq))); // lav et nyt træ, med en parent der påstår af dens børn samlede freq
                // Giv parent et højre og venstre barn, i det træ der lige er blvet tilføjet til listen. 
                listTree.get(0).parent.setLchild(current1);
                listTree.get(0).parent.setRchild(currentNext2);
                
            }
            
        }
        
       //TOO DO
       //Sæt de to sidste træer sammen, vil der altid kun være 2 træer tilbage? 

    }

    
    /**
     * Handles the insertion of huffNodes into a huffTree
     * @param tree
     * @param node 
     */
    public void insertNodeToTree(Tree tree, HuffNode node) {
        if (tree.parent.getLchild() != null && tree.parent.getRchild() == null) {
           Tree newTree = new Tree(new HuffNode(tree.highFreq + node.getFreq()));// lav ny tree med en node der har en freq der er lig træets + nodens
           newTree.parent.setLchild(tree.parent);// sæt det venstre barn til at være tæet
           newTree.parent.setRchild(node);// det højre barn er noden.
        }
        // skal den også kunne sætte nodes som ventre barn? eller kan jeg bare nøjes med at altid sætte nodes til højre?
        // måske, hvis noden er større, sæt den til højre, hvis den er mindre, sæt den til venstre i det nye træ.
        
//        // denne if statement tror jeg ikke at jeg skal bruge
//        if (tree.parent.getLchild() == null && tree.parent.getRchild() == null) {
//            tree.parent.setLchild(node);
//        }

      
        // Måden jeg får den til at håndtere at sætte 2 træer sammen på, er ved at efterlade
        // en reference til det nye sub trees root, til det nye træ venstre eller højre barn.
    }
    
    /**
     * Combines two trees into one tree.
     * @param tree1
     * @param tre2 
     */
    public void combineTree(Tree tree1, Tree tree2){
        if(tree1.highFreq < tree2.highFreq){
            Tree newTree = new Tree(new HuffNode(tree1.highFreq + tree2.highFreq));// Create new tree with the combined frequency as root
            newTree.parent.setLchild(tree1.parent); // Sets the parent of the smallest tree as the left child of the newTree's parent
            newTree.parent.setRchild(tree2.parent); // Sets the parent of the biggiest tree as the rigth child of the newTree's parent
        }
        else{
            Tree newTree = new Tree(new HuffNode(tree1.highFreq + tree2.highFreq));// Create new tree with the combined frequency as root
            newTree.parent.setLchild(tree2.parent); // Sets the parent of the smallest tree as the left child of the newTree's parent
            newTree.parent.setRchild(tree1.parent); // Sets the parent of the biggiest tree as the rigth child of the newTree's parent
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Getter for root of the tree.
     * @param tree
     * @return 
     */
    public HuffNode getroot(Tree tree) {
        HuffNode root = tree.parent;
        return root;
    }
}
