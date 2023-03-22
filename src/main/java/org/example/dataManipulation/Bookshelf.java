package org.example.dataManipulation;

import org.example.bookshelf.*;
import org.example.bookshelf.books.*;

import java.util.ArrayList;
import java.util.Random;

public class Bookshelf {
    private final ArrayList<Bookable> books;
    private final Random random = new Random();

    public Bookshelf() {
        books = new ArrayList<>();
    }

    public void addBook(Bookable book) {
        books.add(book);
    }

    public boolean hasBook(Bookable book) {
        return books.contains(book);
    }

    public Bookable getBook(int i) {
        return books.get(i);
    }
    public Bookable getRandomBookDepartment(String department) {
        ArrayList<Bookable> booksDepartment = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) instanceof RussianTextBook){
                if(((RussianTextBook) books.get(i)).getDepartment().equals(department)) booksDepartment.add(books.get(i));
            }
        }
        if(booksDepartment.size()==0) return books.get(random.nextInt(books.size()));
        else return booksDepartment.get(random.nextInt(booksDepartment.size()));
    }

    public int size(){
        return books.size();
    }
    public int sizeFiction(){
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) instanceof Fiction) count++;
        }
        return count;
    }
    public int sizeEnglishFiction(){
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) instanceof EnglishFiction) count++;
        }
        return count;
    }
    public int sizeRussianFiction(){
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) instanceof RussianFiction) count++;
        }
        return count;
    }
    public int sizeTextBook(){
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) instanceof TextBook) count++;
        }
        return count;
    }
    public int sizeEnglishTextBook(){
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) instanceof EnglishTextBook) count++;
        }
        return count;
    }
    public int sizeRussianTextBook(){
        int count = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) instanceof RussianTextBook) count++;
        }
        return count;
    }
}
