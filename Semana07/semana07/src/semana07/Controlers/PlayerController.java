/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana07.Controlers;

/**
 *
 * @author Stefania Cavazos
 */
public class PlayerController extends CharacterController{

    public PlayerController() {
    }

    public PlayerController(double health, boolean isDeath) {
        super(health, isDeath);
    }

    @Override
    public void takeDamage(double amount) {
        super.takeDamage(amount); //To change body of generated methods, choose Tools | Templates.
    System.out.println("Player Health:" + getHealth());
    }
    
    

    @Override // directiva
    public void move() {
        System.out.println("Player Move");
    }

    @Override
    public void attack() {
        System.out.println("Player Attack");
    }

    @Override
    public void death() {
        super.death();
    System.out.println("Player Death");
    }
    
    
}
