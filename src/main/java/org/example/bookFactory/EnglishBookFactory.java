package org.example.bookFactory;

import org.example.excelProvider.ExcelReader;
import org.example.bookshelf.books.EnglishFiction;
import org.example.bookshelf.books.EnglishTextBook;
import org.example.bookshelf.books.IFiction;
import org.example.bookshelf.books.ITextBook;

import java.util.ArrayList;
import java.util.Random;

public class EnglishBookFactory implements BookFactory {
    private static EnglishBookFactory instance;
    private final Random random = new Random();

    //Fiction
    private final ArrayList<String> types;
    private final ArrayList<String> firstNames;
    private final ArrayList<String> secondNames;
    private final ArrayList<String> authors;

    //textbook
    private final ArrayList<String> disciplines;
    private final ArrayList<String> levels;
    private final ArrayList<String> authors_textbook;
    private final ArrayList<String> universitys;

    private EnglishBookFactory() {
        //Fiction
        types = ExcelReader.read("./data/Жанры художественной литературы.xlsx", 1);
        authors = ExcelReader.read("./data/Авторы художественной литературы.xlsx", 1);
        firstNames = ExcelReader.read("./data/Английская художественная литература.xlsx", 0);
        secondNames = ExcelReader.read("./data/Английская художественная литература.xlsx", 1);

        //textbook
        disciplines = ExcelReader.read("./data/Английские учебные дисциплины.xlsx", 0);
        levels = ExcelReader.read("./data/Уровни литературы.xlsx", 0);
        authors_textbook = ExcelReader.read("./data/Английские преподаватели.xlsx", 0);
        universitys = ExcelReader.read("./data/Список университетов.xlsx", 0);
    }

    public static EnglishBookFactory getInstance() {
        if (instance == null) {
            instance = new EnglishBookFactory();
        }
        return instance;
    }

    @Override
    public ITextBook createTextBook() {
        var discipline = disciplines.get(random.nextInt(disciplines.size()));
        var author = authors_textbook.get(random.nextInt(authors_textbook.size()));
        var level = levels.get(random.nextInt(levels.size()));
        var university = universitys.get(random.nextInt(universitys.size()));

        var title = discipline + " " +level + " " + university +", " + author;
        return new EnglishTextBook(title,discipline, level, author,university);
    }

    @Override
    public IFiction createFiction() {

        var type = types.get(random.nextInt(types.size()));
        var author = authors.get(random.nextInt(authors.size()));
        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var secondName = secondNames.get(random.nextInt(secondNames.size()));
        var name = firstName + " " + secondName;

        var title = type + " \"" + name + "\", " + author;

        return new EnglishFiction(title, type, name, author);
    }
}
