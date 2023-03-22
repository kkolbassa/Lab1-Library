package org.example.dataManipulation;

import org.example.bookFactory.EnglishBookFactory;
import org.example.bookFactory.RussianBookFactory;
import org.example.bookshelf.Bookable;
import org.example.dataManipulation.Bookshelf;
import org.example.dataManipulation.UserRegistry;
import org.example.userFactory.StudentFactory;
import org.example.userFactory.TutorFactory;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Random;

public class DataManipulation {
    private final Random random = new Random();
    private Bookshelf bookshelf;
    private UserRegistry userRegistry;

    public DataManipulation() {
    }
    public void generateUsers(int count){
        var userRegistry = new UserRegistry();

        for (int i = 0; i < count; i++) {
            var factoryUser = random.nextInt(2) == 0 ? StudentFactory.getInstance() : TutorFactory.getInstance();
            var user = factoryUser.createUser();
            if(userRegistry.hasUser(user)) i--;
            else userRegistry.addUser(user);
        }

        this.userRegistry = userRegistry;
    }
    public void generateBookshelf(){
        var bookshelf = new Bookshelf();
        do{
            for (int i = 0; i < 50; i++) {
                var factoryBook = random.nextInt(2) == 0 ? EnglishBookFactory.getInstance() : RussianBookFactory.getInstance();
                Bookable book = random.nextInt(2) == 0 ?factoryBook.createFiction() : factoryBook.createTextBook();
                if (bookshelf.hasBook(book))i--;
                else bookshelf.addBook(book);
            }
        }while (bookshelf.sizeFiction()<50||bookshelf.sizeEnglishFiction()<15||bookshelf.sizeRussianFiction()<20||bookshelf.sizeTextBook()<50||bookshelf.sizeRussianTextBook()<20||bookshelf.sizeEnglishTextBook()<15);

        this.bookshelf = bookshelf;
    }

    public void generateBook2Users(){
        for (int i = 0; i < userRegistry.size(); i++) {
            var user = userRegistry.getUser(i);
            for (int j = 0; j <= (random.nextInt(8)+3); j++) {
                Bookable book = random.nextInt(2) == 0? bookshelf.getBook(random.nextInt(bookshelf.size())) : bookshelf.getRandomBookDepartment(user.getDepartment());
                if (user.hasBook(book)) {
                    --j;
                } else {
                    user.addBook(book);
                }
            }
        }
    }
    public DefaultMutableTreeNode addInfo2GUI(){
        return userRegistry.addInfo2GUI();
    }
}
