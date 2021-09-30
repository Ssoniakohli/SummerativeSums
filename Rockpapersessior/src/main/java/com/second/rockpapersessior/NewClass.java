package com.second.rockpapersessior;



import java.util.Scanner;
    public class NewClass {
    public static void main(String[] args) {
        //Initialize the Scanner
        Scanner in = new Scanner(System.in);
        //declare the variables
        int wins = 0;  
        int losses = 0; 
        int ties = 0; 
        int numofRounds = 0; 
        int user_Score =0 ;
        int Comp_Score = 0;
        
        do{
            System.out.println("How many rounds would you like to play?"); //prompt user to enter the input
            int numRounds = in.nextInt();
            in.nextLine();
            if(numRounds>10 || numRounds<1){
                System.out.println("Please enter the value within range: Minimum 1 and Maximum 10.");
                    break;
                }
                    for(int i=0; i<numRounds; i++){  
                        System.out.println("What is your move? please enter rock, paper, or scissors. "
                                    + " Enter quit.");
                        String myMove = in.nextLine();
                        
                        if(myMove.equals("quit")) {
                            break;
                            }
                       
                            if(!myMove.equals("rock") && !myMove.equals("paper") && !myMove.equals("scissors")) {
                            System.out.println("Your move isn't valid!");
                            } else {
                            
                            int rand = (int)(Math.random()*3);
                        
                            String opponentMove;
                            if(rand == 0) {
                              opponentMove = "rock";
                            } else if(rand == 1) {
                              opponentMove = "paper";
                            } else {
                              opponentMove = "scissors";
                            }
                            System.out.println("Opponent move: " + opponentMove);
                            System.out.println("You chose: " + myMove);
                          
                            if(myMove.equals(opponentMove)) {
                              System.out.println("It's a tie!");
                              ties++;
                              numofRounds++;
                            } else if((myMove.equals("rock") && opponentMove.equals("scissors")) || (myMove.equals("scissors") && opponentMove.equals("paper")) || (myMove.equals("paper") && opponentMove.equals("rock"))) {
                              System.out.println("You won!");
                              wins++;
                              user_Score += 1;
                              numofRounds++;
                            } else {
                              System.out.println("You lost!");
                              losses++;
                              Comp_Score += 1;
                              numofRounds++;
                            }
                        }
                         
                            System.out.println("Wins: " +wins +" Losses: " + losses +  " Ties: " + ties +
                                     " Rounds Played: " + numofRounds + " Rounds Asked: " + numRounds);
                            System.out.println("User Score: " + user_Score);
                            System.out.println("Computer Score: " + Comp_Score);
                            System.out.println();
                            if((numofRounds==numRounds)){
                                break;
                            }
                    }
                     if(user_Score > Comp_Score){
                            System.out.println("CONGRATULATIONS! USER WINS THE GAME.");
                            System.out.println();
                        } else if(user_Score < Comp_Score){
                            System.out.println("CONGRATULATIONS! COMPUTER WINS THE GAME.");
                            System.out.println();
                        } else {
                            System.out.println("NO WINS THE GAME.");
                            System.out.println();
                        }
                    NewClass game = new NewClass();
                    Character playAgain = game.playAgain();
                            if(numofRounds==numRounds){
                                numofRounds = Reset(0,numRounds);
                                if(!playAgain.equals('y')){
                                    System.out.println();
                                    break;
                                }
                            }
        }while(true);
                  //Print a final message for the users
                System.out.println("Thanks for playing Rock, Paper, Scissors!");
    }
        public Character playAgain() {
        Scanner scan = new Scanner(System.in);
        Character playAgain;
        do {
            System.out.println("Play again (y/n)?");
            playAgain = scan.next().charAt(0);
        } while(!playAgain.equals('y') && !playAgain.equals('n'));
        return playAgain;
    }
        public static int Reset(int numofRounds, int numRounds){
            if(numofRounds==numRounds){
                numofRounds = 0;
            } return numofRounds;
        }
}
    
        
    
             
        
             
             
             
             
        
             
       
        
        
    

            
        
    
    
            
                
            

    
     



        
        
        
        
    

