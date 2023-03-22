package org.example.bookshelf.books;

public class EnglishTextBook extends TextBook implements ITextBook {
    private String level;
    private String author;
    private String university;

    public EnglishTextBook(String title, String discipline, String level, String author, String university) {
        super(title, discipline);
        this.level = level;
        this.author = author;
        this.university = university;
    }
    public String getLevel() {
        return level;
    }

    public String getAuthor() {
        return author;
    }

    public String getUniversity() {
        return university;
    }

    public void setLevel(String level) {
        this.level = level;
        updateTitle();
    }
    public void setAuthor(String author) {
        this.author = author;
        updateTitle();
    }
    public void setUniversity(String university) {
        this.university = university;
        updateTitle();
    }
    public void updateTitle(){
        this.title = discipline + " " +level + " " + university +", " + author;
    }

}
