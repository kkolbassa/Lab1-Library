package org.example.bookFactory;

import org.example.bookshelf.books.IFiction;
import org.example.bookshelf.books.ITextBook;

public interface BookFactory {
    ITextBook createTextBook();
    IFiction createFiction();
}
