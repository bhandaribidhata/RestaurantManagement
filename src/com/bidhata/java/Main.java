package com.bidhata.java;

import com.bidhata.java.entry.Menu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] items = {"Momo", "fried rice", "chowmein"};
        int[] price={100,150,200};
        Scanner input = new Scanner(System.in);
        int ch, total = 0;
        Menu menu = new Menu(items, input,price);
        menu.menuList();
        System.out.println();

        menu.initialQuantity();
        System.out.println();

       menu.display();
        System.out.println();
        do {
            System.out.println("do you want to serve new customer?[y/n]");
            String choic = input.next();
            if (choic.equalsIgnoreCase("y")) {
                do {

                    System.out.println("enter your choice");
                    ch = input.nextInt();
                    menu.order(ch);
                    total += menu.totalPrice();
                    System.out.println();
                    System.out.println("Do you want to take other orders[y/n]??");
                    String choice = input.next();

                    if (choice.equalsIgnoreCase("y")) {
                        menu.display();

                    } else {
                        break;
                    }
                } while (ch <= items.length);
                System.out.println("Total price is " + total);

            } else {
                System.exit(0);
            }

        } while (true);

    }
}
