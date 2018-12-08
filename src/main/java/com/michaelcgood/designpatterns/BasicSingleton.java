package com.michaelcgood.designpatterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BasicSingleton {
    private static final BasicSingleton basicSingleton = new BasicSingleton();
    private int value;
    private BasicSingleton(){}

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BasicSingleton getBasicSingleton(){

        return basicSingleton;
    }
}

class Demo{

    static  void saveToile( BasicSingleton singleton, String fileName){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(singleton);

        }catch (Exception e){}
    }

    static BasicSingleton readFromFile(String filename) throws Exception{

           FileInputStream  fileInputStream = new FileInputStream(filename);
          ObjectInputStream   objectInputStream = new ObjectInputStream(fileInputStream);



        return (BasicSingleton) objectInputStream.readObject();
    }

    public static void main(String[] args) throws Exception {

        int a = 20;

        a = a-- + a--;
        System.out.println(a);

//        BasicSingleton basicSingleton = BasicSingleton.getBasicSingleton();
//        basicSingleton.setValue(123);
//
//        String filename = "singleton.bin";
//        saveToile(basicSingleton,filename);
//        System.out.println(basicSingleton.getValue());
//
//        BasicSingleton singleton2 = readFromFile(filename);

       // System.out.println(basicSingleton == singleton2);

        // System.out.println(basicSingleton.getValue());
        ///////// System.out.println(singleton2.getValue());
    }

}
