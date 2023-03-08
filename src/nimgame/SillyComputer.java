/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nimgame;

import java.util.Random;

/**
 *
 * @author tuongdi
 */

public class SillyComputer implements Player {
    
    private String name;
   
    
    public SillyComputer(){
       
    }
    
    /**
     * Return the amount that computer wants to remove based on Random Class
     * @param total Current amount on Pile
     * @return Amount to remove
     */
    @Override
    public int move(int total){
        Random genNum = new Random();
        // from 1 to n/2
        int amount;
        amount = genNum.nextInt(total/2)+1;
        return amount;
    }
    
    /**
     * Set name of Player
     * @param name 
     */
    public void  setName(String name){
        this.name = name;
    }
    
    /**
     * Gets name of the Player
     * @return name as a String
     */
    public String getName(){
        return name;
    }
}
