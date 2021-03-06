/*
 *Francesco Capodanno unter GPLv3 . This software is of public-domain
 */
package javaexperiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * @author francesco@capodanno.click
 */
public class JavaExperiments {

    static boolean is_a_number, is_terminate;
    static List<List<Integer>> intMatrix; // final matrix created
    static int n_rows =0; // total number of final matrix
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       List<Integer> list = new ArrayList<>();
       Scanner user_input = new Scanner(System.in);
       
       intMatrix = new ArrayList<>();
              
       is_a_number = false; is_terminate = false;
       int n = 0; // number
       
       System.out.println("Hailstone Numbers");
       
       while (is_a_number || !is_terminate)
       {
        if (!list.isEmpty()) list.clear(); // clear the list if is the second time
         
        System.out.print("\n---------\nPlease insert a number (or type 'exit' to exit): "); 
        String number = user_input.next();
        if (!number.equals("exit"))
        {
         n = isValidReturnNumber(number);
         if (n==0 && is_a_number) break; // protection 0 division
        } else
        {
          is_terminate = true; // facoltative
          break; 
        }
         
       if (is_a_number == true) // if is a number calcolate the result
        {
            while (n != 1)
            {
                list.add(n);
                if (n % 2== 0){
                    n = n / 2 ;
                    
                } else {
                    n = 3 * n +1;
                }
                
            }
            list.add(n);
            
            System.out.println (" List: " + list);
          
           
            Integer max = 0;
        
            for (Integer x : list)
            {
                max = Math.max(x, max);
            }
    
            System.out.println("Maxiumum Integer in the list:" + max);
            System.out.println("Lenght of the list:" + list.size());
            
            addToFinalMatrix(list); // add the clone of this list 
               
        }
       
       }
       
       if (intMatrix.size() >= 1 ){ 
           System.out.println("Final Matrix of all data:");
           System.out.println(intMatrix);
           }
}

    private static Integer isValidReturnNumber(String number) {
    Integer result = 0; 
        try
      {
        result = Integer.parseInt(number);
        is_a_number = true;
      } catch (NumberFormatException e)
      {
        is_a_number = false;
        System.out.println("Error found:\n ");
        System.out.println(Arrays.toString(e.getStackTrace()));System.out.println("\n");
        System.out.println("You must insert a number > 0 ( or 'exit' to terminate!)");
      }
        
        return result;
    }

    private static void addToFinalMatrix(List<Integer> list) {
        
        List<Integer> templist = new ArrayList<>();
        for (Integer v : list) templist.add(v); // clone
       
          intMatrix.add(templist);
       }
}