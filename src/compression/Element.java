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
