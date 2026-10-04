package edu.psu.se411;

import java.util.Arrays;
import java.util.List;

public class PrintableList<T> {

    private List<T> myitems;

    public PrintableList(T[] items) {
        myitems = Arrays.asList(items);
    }

    public List<T> getList() {
        return myitems;
    }

    public void printList() {
        for (T e : myitems) {
            System.out.println(e);
        }
    }
}
