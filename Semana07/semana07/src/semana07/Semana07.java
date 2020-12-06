/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana07;
import semana07.Controlers.PlayerController;
import semana07.Controlers.EnemyController;
import semana07.Managers.GameManager;
import semana07.NPC.NpcBuilder;
import semana07.NPC.Npc;
/**
 *
 * @author Stefania Cavazos
 */
public class Semana07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Player " + GameManager.getInstance().getPlayer());
        GameManager.getInstance().loadGame();
        System.out.println("Level: " + GameManager.getInstance().getLevel());
        GameManager.getInstance().loadTutorial();
        System.out.println("Level: " + GameManager.getInstance().getLevel());
        GameManager.getInstance().initGame();
        System.out.println("Player " + GameManager.getInstance().getPlayer());
        System.out.println("Level: " + GameManager.getInstance().getLevel());
    
        EnemyController enemy01 = new EnemyController(10,10,false);
        EnemyController enemy02 = new EnemyController(20,15,false);
         
         PlayerController player = GameManager.getInstance().getPlayer();
         player.heal(10);
         System.out.println("Player Health:" + player.getHealth());
         System.out.println("GM Health:" +  GameManager.getInstance().getPlayer().getHealth());
         
         for(int i=0; i < 10; i++){
             player.move();
         }
         
          for(int i=0; i < 2; i++){
             player.attack();
         }
          
          enemy01.attack();
          for(int i=0; i < 2; i++){
             player.attack(); 
             enemy01.takeDamage(5);
         }
          System.out.println("Player:" + player.getHealth());
            System.out.println("Score:" + GameManager.getInstance().getScore());
            
             for(int i=0; i < 10; i++){
             player.move();
         }
             
              enemy02.attack();
              enemy02.attack();
              
          for(int i=0; i < 2; i++){
             player.attack(); 
             enemy02.takeDamage(5);
         }
           enemy02.attack();
            player.attack();
          enemy02.takeDamage(5);
         
         NpcBuilder builder01 = new NpcBuilder();
         Npc npc01 = builder01.withName("BRENDA")
                 .withMoney(500)
                 .withAge(22)
                 .build();
         
            NpcBuilder builder02 = new NpcBuilder();
         Npc npc02 = builder02.withName("KARLA")
                 .withMoney(100)
                 .build();
           Npc npc03 = builder02.build();
         System.out.println(npc01);
         System.out.println(npc02);
          System.out.println(npc03);
    }
    
}
