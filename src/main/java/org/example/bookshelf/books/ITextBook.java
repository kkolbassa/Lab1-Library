package org.example.bookshelf.books;

import org.example.bookshelf.Bookable;

public interface ITextBook extends Bookable {
    String getDiscipline();
    void setDiscipline(String discipline);
    void updateTitle();
}