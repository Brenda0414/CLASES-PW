/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana07.NPC;

/**
 *Patron que nos permite generar objetos por partes
 * @author Stefania Cavazos
 */
public class NpcBuilder implements INpc{
    private String name;
    private int age;
    private int money;

    public NpcBuilder() {
    }
 
    public NpcBuilder withName(String name){
       this.name = name;
       return this;
    }
    
    public NpcBuilder withAge(int age){
       this.age = age;
       return this;
    }
    
    public NpcBuilder withMoney(int money){
       this.money = money;
       return this;
    }

    @Override
    public Npc build() {
       Npc npc= new Npc();
       npc.setAge(age);
       npc.setMoney(money);
       npc.setName(name);
       return npc;
    }
    

}
