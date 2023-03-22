package org.example.userFactory;
import org.example.excelProvider.ExcelReader;
import org.example.users.Tutor;
import org.example.users.User;

import java.util.ArrayList;
import java.util.Random;

public class TutorFactory implements UserFactory {
    private static TutorFactory instance;
    private final ArrayList<String> maleFirstNames;
    private final ArrayList<String> femaleFirstNames;
    private final ArrayList<String> maleLastNames;
    private final ArrayList<String> femaleLastNames;
    private final ArrayList<String> maleFatherNames;
    private final ArrayList<String> femaleFatherNames;
    private final ArrayList<String> maleDepartments;
    private final ArrayList<String> femaleDepartments;
    private final Random random = new Random();
    private TutorFactory() {

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

        var lastNames = ExcelReader.read("./data/Преподаватели.xlsx", 0);
        var lastNamesGender = ExcelReader.read("./data/Преподаватели.xlsx", 1);
        var departments = ExcelReader.read("./data/Преподаватели.xlsx", 2);

        maleLastNames = new ArrayList<String>();
        femaleLastNames = new ArrayList<String>();
        maleDepartments = new ArrayList<String>();
        femaleDepartments = new ArrayList<String>();


        for (int i = 0; i < lastNamesGender.size(); i++) {
            if (lastNamesGender.get(i).equals("м")) {
                maleLastNames.add(lastNames.get(i));
                maleDepartments.add(departments.get(i));
            } else {
                femaleLastNames.add(lastNames.get(i));
                femaleDepartments.add(departments.get(i));
            }
        }


        var fatherNames = ExcelReader.read("./data/Отчества.xlsx", 0);
        var fatherNamesGender = ExcelReader.read("./data/Отчества.xlsx", 1);

        maleFatherNames = new ArrayList<>();
        femaleFatherNames = new ArrayList<>();

        for (int i = 0; i < fatherNamesGender.size(); i++) {
            if (fatherNamesGender.get(i).equals("м")) {
                maleFatherNames.add(fatherNames.get(i));
            } else {
                femaleFatherNames.add(fatherNames.get(i));
            }
        }
    }
    public static TutorFactory getInstance() {
        if (instance == null) {
            instance = new TutorFactory();
        }
        return instance;
    }

    @Override
    public User createUser() {
        int gender = random.nextInt(2);
        var firstNames = gender == 0 ? maleFirstNames : femaleFirstNames;
        var lastNames = gender == 0 ? maleLastNames : femaleLastNames;
        var departments = gender == 0 ? maleDepartments : femaleDepartments;
        var fatherNames = gender == 0 ? maleFatherNames : femaleFatherNames;

        var firstName = firstNames.get(random.nextInt(firstNames.size()));
        var lastName = lastNames.get(random.nextInt(lastNames.size()));
        var fatherName = fatherNames.get(random.nextInt(fatherNames.size()));
        var department = departments.get(lastNames.indexOf(lastName));




        return new Tutor(firstName, lastName, fatherName,department, new ArrayList<>());
    }
}
