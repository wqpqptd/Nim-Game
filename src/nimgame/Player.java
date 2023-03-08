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

public interface Player{
    
    /*
    * Move an amount of marbles out of the current 
    * amount.
    */
    int  move(int amountMarbles);
    
    //Setters and Getters
    String getName();
    void setName(String name);
    
    
}