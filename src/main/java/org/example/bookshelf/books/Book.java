package org.example.bookshelf.books;


public abstract class Book {
    protected String title;

    public Book(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public abstract void updateTitle();

}
