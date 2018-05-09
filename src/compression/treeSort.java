import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rasmus Bartholin og Mads Mikael Keinicke
 * Rasmus: rbart17
 * Mads: makei17
 */
public class treeSort {
   
    // An array containing the keys of given nodes
    // Is used to save result of HuffTree.OrderedTraversal()
    int[] inputNum;
    
    // Initializing the HuffTree used
    HuffTree inputTree = new HuffTree();
    
    /**
     * Constructor, that calls the input() method
     */
    public treeSort(){
        input(); 
    }
    
    /**
     * Method that takes a series of keys, and stores it in a HuffTree
 If given input is not an integer, it will be skipped
 Will insert multiple of the same keys, into the Tree
     */
    private void input(){
        
        // String representing the input, as a String[]
        String[] input;
        
        // The scanner taking the input
        Scanner sc = new Scanner(System.in);
        
        // while loop, to get input
        while(sc.hasNext()){
            
            // Get input from scanner, and insert into the String[] input, using split()
            String tmp = sc.nextLine();
            input = tmp.split(" ");

            // Loop to convert each string to an int
            // And insert into the HuffTree, inputTree
            int d = 0;
            while(input.length > d){
                
                // Try and catch, in case input contains a string that cannot be interpreted as an int
                
                // Stores the given integers as keys, in inputTree
                try
                {
                    // Convert String to Int
                    int key = Integer.parseInt(input[d]);
                    
                    // When comments removed, will not insert duplicate Keys
                    
                    //if(!inputTree.search(key))
                    //{
                    
                        // Create a new node with a key of the given input, and insert into tree
                        Node tmpNode = new Node(key);
                        inputTree.insert(tmpNode);   
                        
                        
                    //}
                    // Increment index iterator, as index has been checked
                    d++;
                    
                }
                // A Catch for all exceptions, 
                catch(Exception e)
                {
                    // Increment index iterator, as index has been checked
                    d++;
                    
                    // When comments removed, will print out a given error, when the try fails.
                    // Is not enabled, as output does not require error output
                    //System.out.println(e);
                }
            }            
        }
        
    }
    // Method calls orderTraversal() on our inputTree, and set the result on our int[] inputNum.
    /**
     * Calls orderedTraversal on this objects's HuffTree, and saves it to inputNum
     */
    public void orderInput()
    {
        inputNum = inputTree.orderedTraversal();
    }
    
   // Method takes the content,  content of inputNum from 0 to inputNum.length -1, and makes a new line for each output.
    /**
     * Returns A string with all keys stored in inputNum, on their own line
     * 
     * @return  A String of keys in inputNum
     */
    public String toTxtString(){
        
        // String to be returned
        String outString = "";
           
        // A loop that updates the string with the next index of inputNum
        // Each index has it's own line, with formating fitting .txt files
        int i =0;
        while(inputNum.length > i){            
            outString += inputNum[i] + "\r\n";
            i++;
        }
        
        return outString;
    }
   
   /**
    * Main method, that is caleld when using the class treeSort
    */
    public static void main(String[] args){
        treeSort tre = new treeSort();
        tre.orderInput();
        System.out.println(tre.toTxtString());

    }
}
