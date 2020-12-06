/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana07.Controlers;

import semana07.Managers.GameManager;

/**
 *
 * @author Stefania Cavazos
 */
public class EnemyController extends AIController{
    
    
    private int score;
    
    public EnemyController() {
       
    }

    public EnemyController(int score) {
        this.score = score;
    }
    
    public EnemyController(int score,double health,boolean isDeath) {
        super(health,isDeath);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void takeDamage(double amount) {
        super.takeDamage(amount); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Enemy Health:" + getHealth());
    }

    
    
    @Override
    public void attack() {
        super.attack(); //To change body of generated methods, choose Tools | Templates.
      
        GameManager.getInstance().getPlayer().takeDamage(5);
    }
    
  
    @Override
    public void death() {
        super.death(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("ENEMY IS DEATH");
   GameManager.getInstance().setScore(score);
    
    }

   
    
    
}
