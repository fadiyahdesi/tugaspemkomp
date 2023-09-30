/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practice.oop;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class DuckSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih Duck yang ingin ditampilkan:");
        System.out.println("1. Mallard Duck");
        System.out.println("2. Redhead Duck");
        System.out.println("3. Rubber Duck");
        System.out.println("4. Decoy Duck");
        System.out.println("5. Model Duck");
        int choice = scanner.nextInt();
        Duck duck = null;
        switch (choice) {
            case 1:
                duck = new MallardDuck();
                break;
            case 2:
                duck = new RedHeadDuck();
                break;
            case 3:
                duck = new RubberDuck();
                break;
            case 4:
                duck = new DecoyDuck();
                break;
            case 5:
                duck = new ModelDuck();
                break;
            default:
                System.out.println("Pilihan tidak valid");
                System.exit(0);
        }
        duck.display();
        duck.performQuack();
        duck.performFly();
    }
}

        
        
   
