/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nimgame;

/**
 *
 * @author tuongdi
 */

public class SmartComputer implements Player {
    private String name;
   
    //Constructor
    public SmartComputer(){
        
    }
    
    
    /**
     * Return the amount to be removed by the smart Computer. 
     * This is determined byte using n^2-1.
     * @param amount Current amount on Pile
     * @return Amount of marbles to be removed
     */
    @Override
    public int move(int amount){
        //if amount is less than 3 just remove 1
        if(amount > 3){
        
            int targetAmount = 0;//save the current value of the equation
            //loop through 1 to the amount pluging it into the formula n^2-1
            for(int n = 1; n < amount ; n++){
                targetAmount = (int)(Math.pow(2, n)-1); //n->amount/2
                // get the difference between the current amount and the target amount[1,3,7,15,etc]
                 int diff = amount - targetAmount;
                 //if the difference is between 1 or n/2
                if(diff <= (amount/2) && diff > 0 ){
                    return diff;
                } 
            } 
        }   
        return 1;
    }
    
    /**
     * Set name of the Player
     * @param name 
     */
    public void  setName(String name){
        this.name = name;
    }
    
    /**
     * Returns the name of the Player
     * @return name 
     */
    public String getName(){
        return name;
    }
}
    