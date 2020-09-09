/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19mygame;

import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class App {
    Scanner scanner = new Scanner(System.in);
    String new_game;
    String user_num_str = null;
    int user_num_int = -1;
    
    int attempts = 5;    
    int max_number = 100;
    
    public void run(){
        System.out.println("====================START GAME====================");        
        do{
            int game_attempts = attempts;
            int secret_num = (int)(Math.random()*max_number)+1;
            System.out.println("---------------------NEW GAME--------------------");
            do{
                System.out.printf("Enter a number(0-%d; attempts left - %d): ", max_number, game_attempts);
                try{
                    user_num_str = scanner.nextLine(); 
                    user_num_int = Integer.parseInt(user_num_str);
                }catch(Exception e){
                    if("exit".equals(user_num_str) || "e".equals(user_num_str)){
                        System.out.println("=====================END GAME=====================");
                        System.exit(0);
                    }
                    user_num_str = null;
                    user_num_int = -1;
                    System.out.println("Incorrect input!");
                    continue;
                }
                System.out.println("");
                if(user_num_int > secret_num){
                    System.out.println("The number is too big!");
                }
                else if(user_num_int < secret_num){
                    System.out.println("The number is too small!");
                }
                if(Math.abs(user_num_int - secret_num) <= 10){
                    System.out.println("Your are close!");
                }
            }while(user_num_int != secret_num && --game_attempts > 0);
            
            
            System.out.println("-------------------------------------------------");
            if(user_num_int == secret_num){
                System.out.println("Congratulation! You win!");
            }
            else{
                System.out.printf("You lose! The number: %d\nGood luck next time!\n",secret_num);
            }
            System.out.println("-------------------------------------------------\n");
            System.out.print("Try again? y/n ");

            new_game = scanner.nextLine();
            if("y".equals(new_game)){
                System.out.println("");
            }

        }while("y".equals(new_game));        
        System.out.println("=====================END GAME=====================");
    };  
}
