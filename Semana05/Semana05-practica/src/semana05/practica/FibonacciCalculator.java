/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana05.practica;

/**
 *
 * @author Stefania Cavazos
 */
public class FibonacciCalculator {
   
    
    public static void calculateFibonacci(int value){ 
        String res = "1,";
        int a=0;
        int b=1;
        int sum=0;
        for (int i = 2; i <= value; i++){
            sum = a+ b;
            a = b;
            b = sum;
            res += sum + ",";
           
    } 
        System.out.println(res);
  }
}
