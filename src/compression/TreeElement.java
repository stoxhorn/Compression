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
public class TreeElement {

    public int freq;
    public BotTree tree;

    public TreeElement(int i, BotTree o){
	this.freq = i;
	this.tree = o;
    }
    
    public int getFreq()
    {
        int tmp = freq;
        return tmp;
    }
    
    public BotTree getTree()
    {
        BotTree tmp = tree;
        return tmp;
    }
    
}
