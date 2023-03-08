/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nimgame;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author tuongdi
 */

public class Human implements Player {

    private String name;

    // setting the name
    public Human(String name){
        this.name = name;
    }
    
    /**
     * Returns the amount of marbles removed from the pile by Human using JOPtionPanel,
     * if -1 is returned means the Player will cancel the game.
     * 
     * @param total Current amount on pile
     * @return The amount to take away.
     */
    public int move(int total){
        
        String displayText = name+" turn"+"\nCurrent # marbles: " + total +"\nInsert amount you which to take:" ;
        boolean notInteger = true;
        
        while(notInteger){
        
        String amount = JOptionPane.showInputDialog(displayText);
        if(amount != null){
            
            Scanner scan = new Scanner(amount);
            if(scan.hasNextInt()){
                int numMarbles = scan.nextInt();
                if(numMarbles > 0 && numMarbles <= total/2){
                    notInteger = false;
                    return numMarbles;
                }
            }
        }else{
        return -1;
        }
       }
        return -1;
    }
    
    /**
     * Set different name
     * @param name New name
     */
    public void  setName(String name){
        this.name = name;
    }
    
    /**
     * Returns the Player name.
     * @return String Name
     */
    public String getName(){
        return name;
    }
    
    
    
}
