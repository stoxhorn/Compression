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
    private int MaxElms;
    private ArrayList<Element> PrioArray;
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


    private Element heapMinimum(){
        return this.PrioArray.get(0);
    }

    
    @Override
    public void insert(Element key){
        ListSize++;
        int i = ListSize;
        this.PrioArray.add(key);      
        while( i > 0 && this.PrioArray.get(Parent(i)).key  >  this.PrioArray.get(i).key){            
            Element tmp = this.PrioArray.get(i);
            this.PrioArray.set(i, this.PrioArray.get(Parent(i)));
            this.PrioArray.set(Parent(i), tmp);
            // Den skal blive ved med at tjekke, fordi den nye forældre kan også være "svagere".
            i = Parent(i);
        }

    }





private int left(int i){
  return 2*i;
}

private int right(int i){
  return 2*i + 1;
}
  


@Override
public Element extractMin(){
    if(this.ListSize < 0){
        System.err.println("Heap Underflow");
    }
    Element min = this.PrioArray.get(0);
    this.PrioArray.set(0, this.PrioArray.get(this.ListSize));
    this.ListSize--;
    minHeapify(0);
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
    if (l <= this.ListSize && this.PrioArray.get(l).key < this.PrioArray.get(i).key){    
        smallest = l;
    } else {
        smallest = i;
    }
    if (r <= this.ListSize && this.PrioArray.get(r).key < this.PrioArray.get(smallest).key){
        smallest = r;
    }
    if (smallest != i){
        exchange(i, smallest);
        minHeapify(smallest);  			
    }
  
}
  

}



















