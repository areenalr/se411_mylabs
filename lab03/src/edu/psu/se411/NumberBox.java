package edu.psu.se411;

public class NumberBox<T extends Number> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public double sum(Number anotherNumber) {
        return item.doubleValue() + anotherNumber.doubleValue();
    }
}