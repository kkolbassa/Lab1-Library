package org.example.bookFactory;

import org.example.excelProvider.ExcelReader;
import org.example.bookshelf.books.IFiction;
import org.example.bookshelf.books.ITextBook;
import org.example.bookshelf.books.RussianFiction;
import org.example.bookshelf.books.RussianTextBook;

import java.util.ArrayList;
import java.util.Random;

public class RussianBookFactory implements BookFactory {
    private static RussianBookFactory instance;
    private final Random random = new Random();

    //fiction
    private final ArrayList<String> types;
    private final ArrayList<String> firstNames;
    private final ArrayList<String> prepositions;
    private final ArrayList<String> secondNames;
    private final ArrayList<String> authors;

    //textbook
    private final ArrayList<String> types_textbook;
    private final ArrayList<String> disciplines;
    private final ArrayList<String> departments;

    private RussianBookFactory() {
        //Fiction
        types = ExcelReader.read("./data/Жанры художественной литературы.xlsx", 0);
        authors = ExcelReader.read("./data/Авторы художественной литературы.xlsx", 0);
        firstNames = ExcelReader.read("./data/Русская художественная литература.xlsx", 0);
        prepositions = ExcelReader.read("./data/Русская художественная литература.xlsx", 1);
        secondNames = ExcelReader.read("./data/Русская художественная литература.xlsx", 2);

        //Textbook
        types_textbook = ExcelReader.read("./data/Виды учебных пособий на русском.xlsx", 0);
        disciplines = ExcelReader.read("./data/Русские учебные дисциплины.xlsx", 0);
        departments = ExcelReader.read("./data/Русские учебные дисциплины.xlsx", 1);
    }

    public static RussianBookFactory getInstance() {
        if (instance == null) {
            instance = new RussianBookFactory();
        }
        return instance;
    }
    @Override
    public ITextBook createTextBook() {
        var type = types_textbook.get(random.nextInt(types_textbook.size()));
        var discipline = disciplines.get(random.nextInt(disciplines.size()));
        var department = departments.get(disciplines.indexOf(discipline));
        var title = type + " \"" + discipline + "\" (каф. №" + department + ")";
        return new RussianTextBook(title, discipline,type,department);
    }

    @Override
    public IFiction createFiction() {
        var type = types.get(random.nextInt(types.size()));
        var author = authors.get(random.nextInt(authors.size()));
        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var preposition = prepositions.get(random.nextInt(prepositions.size()));
        var secondName = secondNames.get(random.nextInt(secondNames.size()));
        var name = firstName + " " + preposition + " " +secondName;

        var title = type + " \"" + name + "\", " + author;

        return new RussianFiction(title, type, name, author);
    }
}
