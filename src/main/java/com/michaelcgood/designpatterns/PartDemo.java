package com.michaelcgood.designpatterns;

public class PartDemo {



    int y;
    public static void main(String[] args) {
        String name = new String("Given");
        String string = "Given";

        System.out.println(name == string);

        System.out.println(name.equals(string));
    }
}
