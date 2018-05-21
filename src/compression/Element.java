/**
 *
 * @author Rasmus Bartholin og Mads Mikael Keinicke
 * Rasmus: rbart17
 * Mads: makei17
 */
public class Element {

    public int freq;
    public Object data;
    
    
    /**Construktor for element, takes a integer and a object as parameters.
     * 
     * @param i
     * @param o 
     */
    
    Element(int i, Object o){
        
        
	this.freq = i;
	this.data = o;
    }


    
    public int getFreq()
    {
        int tmp = freq;
        return tmp;
    }
    
    public Object getData()
    {
        Object tmp = data;
        return tmp;
    }
    
}
