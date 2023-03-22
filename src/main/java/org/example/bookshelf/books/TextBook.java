package org.example.bookshelf.books;

import org.example.bookshelf.books.Book;

public abstract class TextBook extends Book {
    protected String discipline;

    public TextBook(String title, String discipline) {
        super(title);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
        updateTitle();
    }
}
