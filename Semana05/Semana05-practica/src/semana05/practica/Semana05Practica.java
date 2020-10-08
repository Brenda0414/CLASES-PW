/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana05.practica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Stefania Cavazos
 */
public class Semana05Practica {

    //public: unicamente la clase donde fue declarada
    private int size;
    //default: sobre la misma clase y heredacion sobre el mismo package
    Double height;
    //protected: sobre misma clase y heredacion sobre mismo y otros package y subclases hijas
    protected String name;
    //public: sobre misma clase y otras clases de otros package y globalmente
    public String test;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Semana05Practica test = new Semana05Practica();
        test.name= "Jose";
        System.out.println("Name:" + test.name);
    //sout ctrl+barra espaciadora + enter
        List<Integer> ids = new ArrayList();
    ids.add(5);
    ids.add(3);
    ids.add(8);
    ids.add(5);
    ids.add(13);
    ids.remove(3);
    //for each
    for(Integer id : ids){
        System.out.println(id);
    }
        HashMap<Integer,String> dictionary = new HashMap<>();
    dictionary.put(24, "Luis");
    dictionary.put(12, "Brenda");
    dictionary.put(16, "Jacobo");
        System.out.println("D12:" + dictionary.get(12));
    
 for (Map.Entry<Integer, String> entry : dictionary.entrySet()){
  Object key = entry.getKey();
  Object val = entry.getValue();
     System.out.println("K:" + key + ",V:" + val);
}
 if(dictionary.containsValue("Brenda")){
     //si existe Valor
 }
 if(dictionary.containsKey(16)){
     //si existe llave 
 }
        System.out.println("2 es impar?" +Calculator.isOdd(2));
        System.out.println("3 es impar?" +Calculator.isOdd(3));
 FibonacciCalculator.calculateFibonacci(10);
 }   
}
