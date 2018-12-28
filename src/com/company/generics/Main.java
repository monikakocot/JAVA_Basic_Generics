package com.company.generics;

import javafx.util.Pair;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

// Solution witohut using generics:
        FruitBox fruitBox = new FruitBox(new Orange());
        Orange fruit1 = (Orange)fruitBox.getFruit();

// When we know the generics - at the time of creating the object, it parameterizes this object:
// generic type - after creating the BOxOnSteroids class, we create an instance of the generic class:
        BoxOnSteroids<Apple> appleBox = new BoxOnSteroids<>(new Apple());
        BoxOnSteroids<Orange> orangeBox = new BoxOnSteroids<>(new Orange());

        Orange fruit = orangeBox.getFruit(); // you do not have to project on oranges

//Generic types nested:
        Pair<BoxOnSteroids<Orange>,BoxOnSteroids<Apple>> pairOfBoxes =
                new Pair<>(new BoxOnSteroids<>(new Orange()),
                        new BoxOnSteroids<>(new Apple()));

                BoxOnSteroids boxWithoutType = new BoxOnSteroids(new Apple());
                BoxOnSteroids boxWithApple = boxWithoutType;
                BoxOnSteroids boxWithOrange = boxWithoutType;

                //Apple apple = boxWithApple.getFruit(); //does not work
                //Orange orange = boxWithOrange.getFruit(); //does not work

//Extends - bottom limit (here in BoxOfFigures class):
        BoxOfFigures<Circle> circleBox = new BoxOfFigures<>(new Circle());
        //BoxOfFigures<Apple> boxOfApple;  - error can not be <Apple>
        //Rectangle rectangle = new Square();

// Top limit:
        FanceBox<String> box= new FanceBox<>("something");
        box.saySomethingFance();
    }


// Wildcards:
    private static void method1(FanceBox<?> box){
        Object object = box.object;
    }

    private static void plainWildcard (){
        method1(new FanceBox<>(new Object()));
        method1(new FanceBox<>(new Square()));
        method1(new FanceBox<>(new Apple()));
    }

// Extends - Figure is limit:
    private  static void method2(FanceBox<? extends Figure> box){
        Figure figure = box.object;
        System.out.println("our sth is awesome");
    }
// Figure is limit:
    private static void method3(FanceBox<Figure> box) {
        Figure figure = box.object;
        System.out.println("our sth 3 is awesome");
    }
// Rectangle class is limit:
    private void method4(FanceBox<? super Rectangle> box){
        //box.object= new Square(); does not work
        box.object= new Rectangle();
    }

    private static void lowerBoundWildcard(){
    }
}

