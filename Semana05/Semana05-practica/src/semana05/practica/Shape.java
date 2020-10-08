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
public abstract class Shape {
    public int height;
    public int width;
    public abstract int getArea();
    public int getPerimeter(){
       return 0; 
    }
}
