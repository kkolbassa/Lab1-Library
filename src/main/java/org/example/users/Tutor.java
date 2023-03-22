package org.example.users;
import org.example.bookshelf.Bookable;

import java.util.ArrayList;

public class Tutor extends User {
    private String fatherName; // Отчество
    public Tutor(String firstName, String lastName, String fatherName, String department, ArrayList<Bookable> books) {
        super(firstName, lastName,department, books);
        this.fatherName = fatherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    @Override
    public String getFIO() {
        return getLastName() + " " + getFirstName()+ " " + fatherName + " (каф. №" + getDepartment() +")";
    }
}
