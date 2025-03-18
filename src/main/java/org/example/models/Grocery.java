package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while(option != 0){
            System.out.println("0-Çıkış");
            System.out.println("1-Eleman Ekleme");
            System.out.println("2-Eleman Çıkarma");
            System.out.println("Seçim: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 0:
                    System.out.println("Uygulama kapatılıyor.");
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Geçersiz seçenek!");
            }
        }
        scanner.close();
    }

    public static void addItems(String input){
        String[] items = input.split(",");

        for(String item: items){
            item = item.trim();
            if(!checkItemIsInList(item)){
                groceryList.add(item);
                System.out.println(item + " listeye eklendi.");
            }else{
                System.out.println(item + " listede zaten var.");
            }
        }
        printSorted();
    }

    public static void removeItems(String input){
        String[] items = input.split(",");

        for (String item: items){
            item = item.trim();
            if(!checkItemIsInList(item)){
                System.out.println(item + " listede zaten yok.");
            }else{
                groceryList.remove(item);
                System.out.println(item + " listeden çıkarıldı.");
            }
        }
        printSorted();
    }

    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println("Sıralı Liste: " + groceryList);
    }

    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }

    public static void main(String[] args) {
        Grocery.startGrocery();
    }
}
