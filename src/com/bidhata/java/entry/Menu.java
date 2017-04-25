package com.bidhata.java.entry;

import java.util.Scanner;

public class Menu {

    private String[] items;
    private int[] qty;
    private int[] price, order;
    private Scanner input;
    int totalprice = 0;

    public Menu(String[] items, Scanner input, int[] price) {
        this.items = items;
        qty = new int[items.length];
        this.price = price;
        order = new int[items.length];
        this.input = input;
    }

    //display menu
    public void menuList() {
        System.out.println("Menu for Today");
        System.out.println();
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
    }

    //display initial stock of items
    public void initialQuantity() {
        System.out.println("Enter the available plates of:");

        for (int i = 0; i < items.length; i++) {

            System.out.print(items[i]);
            qty[i] = input.nextInt();

        }
    }

   
    //show list
    public void display() {
        System.out.printf("%-15s %15s %15s %15s","S.N.","items","price","quantity");
        System.out.println();
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%-15s %15s %15s %15s",(i + 1),items[i],price[i],qty[i]);
            System.out.println();
        }
    }

    //take order
    public int[] order(int ch) {
        for (int i = 0; i < items.length; i++) {
            order[i] = 0;
            if (ch == (i + 1)) {

                System.out.println("order for" + items[i] + ":");
                order[i] = input.nextInt();
                if (qty[i] < order[i]) {
                    System.out.println("sorry " + items[i] + " left is " + qty[i] + " plates only");
                    order[i] = 0;
                    break;
                } else if (qty[i] == 0) {
                    System.out.println("sorry " + items[i] + "is finished for today");
                }
                qty[i] = qty[i] - order[i];
                totalprice = order[i] * price[i];
            }

        }
        return qty;

    }

    //bill calculation
    public int totalPrice() {

        return totalprice;
    }

}
