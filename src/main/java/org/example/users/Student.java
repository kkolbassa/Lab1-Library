package org.example.users;
import org.example.bookshelf.Bookable;

import java.util.ArrayList;

public class Student extends User {
    public Student(String firstName, String lastName,String department, ArrayList<Bookable> books) {
        super(firstName, lastName,department, books);
    }

    @Override
    public String getFIO() {
        return getLastName() + " " + getFirstName() + " (каф. №" + getDepartment() +")";
    }
}
