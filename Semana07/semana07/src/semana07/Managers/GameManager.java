/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana07.Managers;
import semana07.Controlers.PlayerController;
import semana07.Enums.Levels;
import semana07.patrones.Singleton;

/**
 *
 * @author Stefania Cavazos
 */
public final class GameManager {
    
    private static final GameManager instance;
    
    static {
        instance = new GameManager();
    }
    
    
    public GameManager(){
}
   
    public static GameManager getInstance(){
    return instance;
    }
    ///// ENCAPSULAMIENTO 
    private Levels level;
    private int score;
    private PlayerController player;
    
    public Levels getLevel(){
        return level;
    }
    
    public void setLevel(Levels Level){
       this.level = Level; 
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int Score){
       this.score = Score; 
    }
    
    public PlayerController getPlayer(){
        return player;
    }
    
    public void setPlayer(PlayerController Player){
       this.player = Player; 
    }
    
    public void loadGame(){
        this.level = Levels.Main_Scene;
    }
    
    public void loadTutorial(){
        this.level = Levels.Tutorial_Scene;
    }
    
    public void initGame(){
        this.level = Levels.Water_Level;
        player = new PlayerController(100,false);
        this.score = 0;
    }
}
