package com.second.healthyhearts.java;

import java.util.Scanner;

public class NewClass 
{
    public static void main(String args[])
           
    {
        int maxHr = ( 220 - 50 );
        Scanner sc=new Scanner(System.in);
        System.out.println("What is your age?");//declare age
        String stringage = sc.nextLine();
        int intage= Integer.parseInt(stringage);
        double dubage = Double.parseDouble(stringage);
        
         int MaxHr = 220 - intage;
         float tempMaxHr = (MaxHr);
         float tempEndingHrr = tempMaxHr*0.85f;
         float tempStartingHrr = tempMaxHr*0.50f;
         int endingHrr = Math.round(tempEndingHrr);
         int startingHrr = Math.round(tempStartingHrr);
         
         System.out.println("your maximum heart rate should be" + maxHr + "beats per minute");
         System.out.println("Your target Heart rate zone is " + startingHrr + " - " + endingHrr );
        }
    }
        


       
           
            
    
            

