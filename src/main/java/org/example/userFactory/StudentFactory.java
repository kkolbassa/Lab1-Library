package org.example.userFactory;
import org.example.excelProvider.ExcelReader;
import org.example.users.Student;
import org.example.users.User;

import java.util.ArrayList;
import java.util.Random;

public class StudentFactory implements UserFactory {
    private static StudentFactory instance;
    private final ArrayList<String> maleFirstNames;
    private final ArrayList<String> femaleFirstNames;
    private final ArrayList<String> maleLastNames;
    private final ArrayList<String> femaleLastNames;
    private final ArrayList<String> departments;
    private final Random random = new Random();
    private StudentFactory() {

        var firstNames = ExcelReader.read("./data/Имена.xlsx", 0);
        var firstNamesGender = ExcelReader.read("./data/Имена.xlsx", 1);
        maleFirstNames = new ArrayList<String>();
        femaleFirstNames = new ArrayList<String>();

        for (int i = 0; i < firstNamesGender.size(); i++) {
            if (firstNamesGender.get(i).equals("м")) {
                maleFirstNames.add(firstNames.get(i));
            } else {
                femaleFirstNames.add(firstNames.get(i));
            }
        }

        var lastNames = ExcelReader.read("./data/Фамилии.xlsx", 0);
        var lastNamesGender = ExcelReader.read("./data/Фамилии.xlsx", 1);

        maleLastNames = new ArrayList<String>();
        femaleLastNames = new ArrayList<String>();

        for (int i = 0; i < lastNamesGender.size(); i++) {
            if (lastNamesGender.get(i).equals("м")) {
                maleLastNames.add(lastNames.get(i));
            } else {
                femaleLastNames.add(lastNames.get(i));
            }
        }


        departments = ExcelReader.read("./data/Кафедры.xlsx", 0);

    }
    public static StudentFactory getInstance() {
        if (instance == null) {
            instance = new StudentFactory();
        }
        return instance;
    }

    @Override
    public User createUser() {
        int gender = random.nextInt(2);
        var firstNames = gender == 0 ? maleFirstNames : femaleFirstNames;
        var lastNames = gender == 0 ? maleLastNames : femaleLastNames;
        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var lastName = lastNames.get(random.nextInt(lastNames.size()));
        var department = departments.get(random.nextInt(departments.size()));


        return new Student(firstName, lastName, department, new ArrayList<>());
    }
}
