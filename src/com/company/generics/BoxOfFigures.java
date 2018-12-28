package com.company.generics;

public class BoxOfFigures<T extends Figure> {
    private T element;

    public BoxOfFigures(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public String getElementName(){

        return element.getName();
    }
}
