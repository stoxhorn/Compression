import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {


            FileInputStream fin = new FileInputStream(args[0]);
			int x = 0;
			int[] list = new int[256];
            while((x = fin.read()) != -1){ 
			list[x]++;
                System.out.println(x);
				// Tjek resultat med https://www.asciitable.com/

            }
			System.out.println(Arrays.toString(list));
			
			

        } catch (Exception e) {
			System.out.println("asd");
            System.out.println(e);

        }
    }
}
