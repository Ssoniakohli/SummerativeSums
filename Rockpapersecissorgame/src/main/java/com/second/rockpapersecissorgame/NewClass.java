package com.second.rockpapersecissorgame;
import java.util.*;
       public class NewClass {

        public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
    
        System.out.println("1 is for rock");
        System.out.println("2 is for paper");
        System.out.println("3 is for scissor");
        
        int computer_choice;
        int computerwon=0;
        int my_choice;
        int me=0;
        int game=1;
        
        while(game<=5)
        {  
            Random rand= new Random();
            computer_choice=rand.nextInt(2);
            my_choice=sc.nextInt();
            
            switch (my_choice)
            {
               case 0:
                 System.out.println(" You choose rock");
                 break;
             case 1:
                 System.out.println("you choose paper");
                 break;
             case 2:
                 System.out.println("You choose scissor");
             }
             switch(computer_choice)
             {
                   case 0:
                 System.out.println(" computer choose rock");
                 break;
             case 1:
                 System.out.println("computer choose paper");
                 break;
             case 2:
                 System.out.println("computer choose scissor");
                
                 
                if(computer_choice==my_choice)
                {
                    System.out.println("match tie");
                }
                else if(computer_choice==0 && my_choice==1)
                {
                    System.out.println("1 won!!! and computer lose");
                    me++;
                }
                else if(computer_choice==0 && my_choice==2)
                {
                        System.out.println("computer won");
                        computerwon++;
                
                }
                else if(computer_choice==1 && my_choice==0)
                {
                        System.out.println("computerwon!!!");
               }
                else if(computer_choice==1 && my_choice==2)
                {
                            System.out.println("i won");
                me++;
                        }
                else if(computer_choice==2 && my_choice==0)
                {
                            System.out.println("i won");
                me++;
                        }
                else if(computer_choice==2 && my_choice==1);
                {
                            System.out.println("computer won");   
                computerwon++;
                }
                if(game==5)
                {
                    break;
                }
                    game++;
                    
                    
        }
        System.out.println("-------------------------------------");
        System.out.println("computer"+" :"+ computerwon);
        System.out.println("me"+" :"+me);
                
                        
          System.out.println("-----------------------------------");              
                    
            if(computerwon>me)
        {    
                System.out.println("computerwon the game");
        }
            else if(computerwon==me)
        {
            System.out.println("match tie"); 
        }   
              else 
              
                 System.out.println("i won the game and computer need more practice");
         //Exit if user didn't want to play again
            break;
        }
             
    }

}  

       
       

 
            
            


