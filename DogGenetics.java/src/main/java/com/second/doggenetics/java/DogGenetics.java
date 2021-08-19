/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.second.doggenetics.java;

/**
 *
 * @author HP
 */
import java.util.Scanner;
import java.util.Random;

public class DogGenetics {
    
   public static void main(String[] args) {
       Scanner inputReader = new Scanner(System.in);
       Random rGen = new Random();
       
       String dogName;
       int startPercent = 100;
       int breedPercent = 0;
       
       System.out.println("What is your doggies name?");
       dogName = inputReader.nextLine();
       
       String[] breeds = {"Sir Fluffy McFlufferkins Esquire", "St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
       System.out.println(" your dog" + "is a mix of: " );

       for (int i = 0; i < 5 ; i++) {
            String breed = "";
            breed = breeds[i];
            if (i !=4) {
                breedPercent = rGen.nextInt(startPercent);
                startPercent-= breedPercent;
            } else {
                breedPercent = startPercent;
                
            }
            System.out.println(breed + ":" + breedPercent + "%");
            
       }
       System.out.println("WOW, that is QUITE the dog!!");
   }

}
   

    

    

