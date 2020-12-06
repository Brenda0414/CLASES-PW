/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana07.patrones;

/**
 *Patron de diseño nos permite generar una sola instancia
 * @author Stefania Cavazos
 */
public class Singleton {
    // INSTANCIA QUE SERA MANDADA A LLAMAR
    private static final Singleton instance;
    
    ///INICIALIZAR LAS PROPIEDADES ESTATICAS
    static {
        instance = new Singleton();
    }
    
    
    public Singleton(){
}
   
    public static Singleton getInstance(){
    return instance;
    }
    
}
