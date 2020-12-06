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
public class AIController extends CharacterController {

    public AIController() {
    }

    public AIController(double health, boolean isDeath) {
        super(health, isDeath);
    }

    
    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attack() {
      
    }

    @Override
    public void death() {
        super.death(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void takeDamage(double amount) {
        super.takeDamage(amount); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
