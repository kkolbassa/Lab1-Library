package org.example.bookshelf.books;

import org.example.bookshelf.books.Book;

public abstract class Fiction extends Book {
    private String type;
    private String name;
    private String author;

    public Fiction(String title, String type, String name, String author) {
        super(title);
        this.type = type;
        this.name = name;
        this.author = author;
    }

    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }

    public void setType(String type) {
        this.type = type;
        updateTitle();
    }

    public void setName(String name) {
        this.name = name;
        updateTitle();
    }

    public void setAuthor(String author) {
        this.author = author;
        updateTitle();
    }
    public void updateTitle(){
        this.title = type + " \"" + name + "\", " + author;
    }
}

