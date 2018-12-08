package com.michaelcgood.designpatterns;

public class NullObjectPatterns {


    public static void main(String[] args) {

        Log log = new Nulllog();
        BankAccount bankAccount  = new BankAccount(log);
        bankAccount.deposit(100);
    }


}

class BankAccount{

    private Log log;
    private int balance;
    public BankAccount(Log log){

        this.log = log;
    }

    public void deposit(int amount){
        balance +=amount;

        log.info("Deposited "+ amount);
    }

}

interface Log{

    void info(String msg);
    void warn(String msg);


}

class ConsoleLog implements Log{

    @Override
    public void info(String msg) {

        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {

        System.out.println("WARNING: "+ msg);
    }
}

final class Nulllog implements Log{

    @Override
    public void warn(String msg) {

    }

    @Override
    public void info(String msg) {

    }
}