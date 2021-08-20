package com.second.rockpapersessior;

import java.util.Random;
import java.util.Scanner;


        public class NewClass {
    public static void main(String[] args) {
       Scanner inputReader = new Scanner(System.in);
        int rounds = 10;
        int Rock = 1; 
        int Paper = 2;
        int Scissors = 3;
        int choice;
        int tiecount=0;
        int usercount=0;
        int compcount=0;
        int a=0;
        int b=0;
        int c=0;
        String y="yes";
        String n="no";
        String askuser;
        Scanner sc= new Scanner(System.in);
        System.out.println("How many rounds do you want to play");
        
        {
            if(rounds>10)
            {
                System.out.println("you input a wrong value, out of range");
            }
            else
                
            for(int i = 1; i<rounds; i++)
            {
                
                
                Random ran= new Random (3);
                //user input
            System.out.println("please make your choice:");
            choice=Integer.parseInt(sc.nextLine());
            
            
            //computer input
            
                
             int compchoice =ran.nextInt(3)+1;
            System.out.println("computerchoice:" + compchoice);
            //comparison between user input and computer input
            if (choice==compchoice)
                
            {
                System.out.println("Tie");
                tiecount++;
                a=tiecount;
                
            }
            
            else if(choice>compchoice)
            {
                System.out.println("User wins");
                
                 usercount++;
               b=usercount;
                        
             }
                else
             {
                        
            System.out.println("computer wins");
            compcount++;
            c=compcount;
            
          }
                
          // printing total number of ties, userwins. computer wins
                System.out.println("Total number of ties:"+ a);
                System.out.println("Total number of userwins:+ b");
                System.out.println("Total number of computerwins:+ c");
            }
            //to find overall winner
           if (b>c)
                System.out.println("Overall user is the wins");
           else if (c>b)
                System.out.println("Overall computer is the winner");
           else
                System.out.println("there is a tie between them");
           
             //ask user if she wants to play again
                     System.out.println("Do you want to play again");
               askuser=sc.nextLine();
               if (askuser.equals(n))
                System.out.println("Thanks for playing" );
        
                 System.out.println("how many rounds do you want to play");
        }
                 inputReader.nextLine();
        }

    }           
            
           
                      
    
             
        
             
             
             
             
        
             
       
        
        
    

            
        
    
    
            
                
            

    
     



        
        
        
        
    

