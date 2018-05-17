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
    public Element data;
    public Element rchild = null;
    public Element lchild = null;
    public Element parent = null;

    /**
     * Construktor for element, takes a integer and a object as parameters.
     *
     * @param i
     * @param o
     */
    Element(int i, Element o) {

        this.freq = i;
        this.data = o;
    }

    Element() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRChild(Element rchild) {
        this.rchild = rchild;
    }

    public void setLChild(Element lchild) {
        this.lchild = lchild;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }
    
    public void setFreq(int freq){
        this.freq = freq;
    }

    public int getFreq() {
        int tmp = freq;
        return tmp;
    }

    public Object getData() {
        Object tmp = data;
        return tmp;
    }

}
