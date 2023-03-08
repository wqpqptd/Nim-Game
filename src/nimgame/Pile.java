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
  
public class Pile {
    
    private int amount;
    
    /**
     * When Pile is created A random number between 10 and 100 is generated using Random
     * Class
     */
    public Pile(){
        Random genNum = new Random();
        amount = genNum.nextInt(91) + 10;
    }
    /**
     * Removes an specified amount from the Pile
     * @param amount Amount to take away
     */    
    public void take(int amount){ //lay so coke con lai
        this.amount -=amount;
    }
    
    /**
     * Current amount in the Pile
     * @return amount in Pile
     */
    public int getAmount(){
        return amount;
    }
    

}

