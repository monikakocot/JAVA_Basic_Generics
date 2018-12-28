package com.company.generics;

// Control of another generic type
public class FanceBox<T> extends StandardBox<T>{

    public FanceBox(T object){
        super(object); //object from StandardBox class
    }

    public void saySomethingFance(){
        System.out.println("Our" + object + "is cool");
    }
}
