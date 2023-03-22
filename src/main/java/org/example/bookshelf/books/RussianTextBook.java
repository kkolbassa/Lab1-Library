package org.example.bookshelf.books;

public class RussianTextBook extends TextBook implements ITextBook {
    private String type;
    private String department;

    public RussianTextBook(String title, String discipline, String type, String department) {
        super(title, discipline);
        this.type = type;
        this.department = department;
    }
    public String getType() {
        return type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void setType(String type) {
        this.type = type;
        updateTitle();
    }

    public void updateTitle() {
        this.title = type + " \"" + discipline + "\" (каф. №" +department +")" ;
    }
}
