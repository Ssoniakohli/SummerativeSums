package com.second.rockpapersessior;
import java.util.Random;        
import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {
       Scanner inputReader = new Scanner(System.in);
        int numberofrounds = 0;
        int wins = 0; 
        int losses = 0;
        for(int i = 0; i<10; i++)
        while( numberofrounds<10 && numberofrounds>=1) {
     //verify if number of rounds are valid
        System.out.println("Ask the numberofrounds she wants to play");
        inputReader.nextLine();
        numberofrounds++;
         
         //(!number of rounds<10&& !number of rounds>)
         System.out.println("If user entered invalid number of rounds,print(exit)");
         inputReader.nextLine();
         
        //Get the user input
             System.out.println("Enter your move. Type in rock, paper or scissors: ");
             String mymove = inputReader.nextLine();
             //Randomly generate cmove(1, 2, 3)
             Random number= new Random ();
             int rand = number.nextInt(3)+1;
             String cmove = "";
             switch (rand) {
        case 1:
        cmove = "Rock";
        break;
        case 2:
        cmove = "Paper";
        break;
        default:
        cmove = "Scissors";
    }
             System.out.println("cmove: + cmove");
             System.out.println("mymove: + mymove");
             
             if( mymove.equals(cmove)) {
                 System.out.println("you tied!");
             }else if ((mymove.equals("rock") &&cmove.equals("Scissors")) || (mymove.equals
        ("Scissors") && cmove.equals("Paper"))||
                     (mymove.equals("Paper") && cmove.equals("Rock"))) {
                     System.out.println("ypu won!");
                     wins++;
             }else {
                 System.out.println("you lost!");
                 
             }
             //check if I won more games than I lose or computer won more games than I won
             
             if (wins>losses) {
                 System.out.println("I won more games than I lose! :)");
             }else if (wins<losses) {
                 System.out.println("I lost more games than I won! :");
             }else 
                 System.out.println("I won and list an equal number of games!:|");
                 System.out.println("Ask the user if she wants to play again? (y/n");
                 String playagain = inputReader.nextLine();
                 if (playagain.equals("y")) {
                     System.out.println("start over");
                     inputReader.nextLine();
                 }
                 if (playagain.equals("n"));
                 System.out.println("Thanks for playing!:  "+"exit" );
               
            }
        }
 }                
    
             
        
             
             
             
             
        
             
       
        
        
    

            
        
    
    
            
                
            

    
     



        
        
        
        
    

