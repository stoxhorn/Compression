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
