package org.example.bookshelf.books;

import org.example.bookshelf.Bookable;

public interface IFiction extends Bookable {
    String getType();
    String getName();
    String getAuthor();

    void setType(String type);
    void setName(String name);
    void setAuthor(String author);
}
