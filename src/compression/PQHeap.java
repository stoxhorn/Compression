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
import java.util.ArrayList;

public class PQHeap implements PQ {
    //Field
    private final int MaxElms;
    private final ArrayList<Element> PrioArray;
    private int ListSize;
    
    // Constructor
    public PQHeap(int MaxElms)
    {
        this.MaxElms = MaxElms;
        this.ListSize = -1;
        this.PrioArray = new ArrayList<>(MaxElms);
    }

    private int Parent(int i){
        return i/2;
    }


    private Element heapMinimum(){ // Denne kunne også bare gøres public?
        return this.PrioArray.get(0);
    }

    
    @Override
    public void insert(Element key){
        
        ListSize++;
        int i = ListSize;
        this.PrioArray.add(key);      
        while( i > 0 && this.PrioArray.get(Parent(i)).freq  >  this.PrioArray.get(i).freq){            
            Element tmp = this.PrioArray.get(i);
            this.PrioArray.set(i, this.PrioArray.get(Parent(i)));
            this.PrioArray.set(Parent(i), tmp);
            // Den skal blive ved med at tjekke, fordi den nye forældre kan også være "svagere".
            i = Parent(i);
        }

    }
        public void insert(Element key, Element data){
        
        ListSize++;
        int i = ListSize;
        this.PrioArray.add(key);      
        while( i > 0 && this.PrioArray.get(Parent(i)).freq  >  this.PrioArray.get(i).freq){            
            Element tmp = this.PrioArray.get(i);
            this.PrioArray.set(i, this.PrioArray.get(Parent(i)));
            this.PrioArray.set(Parent(i), tmp);
            // Den skal blive ved med at tjekke, fordi den nye forældre kan også være "svagere".
            i = Parent(i);
        }

    }





    private int left(int i){
      return 2*i + 1;
    }

    private int right(int i){
      return 2*i + 2;
    }



    @Override
    public Element extractMin(){
        if(this.ListSize < 0){
            return null;
        }
        
        Element min = this.PrioArray.get(0);
        this.PrioArray.set(0, this.PrioArray.get(this.ListSize));
        this.ListSize--;
        minHeapify(0);
        
        return min;
    }
    public int lookMin(){
        if(this.ListSize < 0){
            return Integer.MAX_VALUE; // I want the tree to be ignored if there are no trees in the heap. 
        }
        int min = this.PrioArray.get(0).freq;
        return min;
    }

    private void exchange(int a, int b){
        Element aa = this.PrioArray.get(a);
        Element bb = this.PrioArray.get(b);
        this.PrioArray.set(a, bb);
        this.PrioArray.set(b, aa);
    }

    private void minHeapify(int i){
        int l = left(i);
        int r = right(i);


        int smallest;
        if (l <= this.ListSize && this.PrioArray.get(l).freq < this.PrioArray.get(i).freq){    
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= this.ListSize && this.PrioArray.get(r).freq < this.PrioArray.get(smallest).freq){
            smallest = r;
        }
        if (smallest != i){
            exchange(i, smallest);
            minHeapify(smallest);  			
        }

    }

    public int getSize()
    {
        int tmp = this.ListSize+1;
        return tmp;
    }
  

}



















