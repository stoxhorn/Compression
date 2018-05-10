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

import java.util.Scanner;

public class Heapsort { 
    public static void main(String[] args) {

	PQ pq = new PQHeap(1000);

	int n = 0;
	Scanner sc = new Scanner(System.in);
	while (sc.hasNextInt()) {
	    pq.insert(new TreeElement(sc.nextInt(),null));
	    n++;
       }
	while (n > 0){
	    System.out.println(pq.extractMin().freq);
	    n--;
	}
   }
}
