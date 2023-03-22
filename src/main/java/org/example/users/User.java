package org.example.users;
import org.example.bookshelf.Bookable;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

public abstract class User {
    private final String firstName; // Имя
    private final String lastName; // Фамилия
    private final String department; // Кафедра

    private final ArrayList<Bookable> books; // Книги

    public User(String firstName, String lastName, String department, ArrayList<Bookable> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public  String getDepartment() {
        return department;
    }

    public ArrayList<Bookable> getBooks() {
        return books;
    }

    public void addBook(Bookable book) {
        books.add(book);
    }

    public boolean hasBook(Bookable book) {
        return books.contains(book);
    }
    public abstract String getFIO();

    public MutableTreeNode getNode() {
        DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(getFIO());
        for (Bookable book: books) {
            userNode.add(new DefaultMutableTreeNode(book.getTitle()));
        }
        return userNode;
    }
}
