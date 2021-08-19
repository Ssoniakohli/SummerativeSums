package com.second.summerativesums.java;

public class NewClass {

public static void print (int[] array) { //method to print array
        System.out.println("{ ");
        System.out.print(", ");
       for (int i=0; i<array.length-1; i++) {
           System.out.println(array[i] +",");
       }
        System.out.println("array[array.length-1]+]");
    }
        //method to add elements of array will return sum of elements
       static int addArray(int array[]) {
       int sum=0;
       for(int i=0; i<array.length; i++) {
           sum =sum + array[i];
       }
      return sum;
  }   
     public static void main(String[] args) {
         
     int arr[] = {1, 90, -33, -55, 67, -16, 28, -55, 15};
     int arr2[] = {999, -60, -77, 14, 160, 301};
     int arr3[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};
     
    

     System.out.println("1, 90, -33, -55, 67, -16, 28, -55, 15");
     System.out.println("999, -60, -77, 14, 160, 301");
     System.out.println("10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99");
     
     
  //print all array sum
      System.out.println("#1 Array sum: "+addArray(arr));
      System.out.println("#2 Array sum: "+addArray(arr2));
      System.out.println("#3 Array sum: "+addArray(arr3));
     }
}
