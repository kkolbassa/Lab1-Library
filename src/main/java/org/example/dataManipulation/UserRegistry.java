package org.example.dataManipulation;

import org.example.users.Student;
import org.example.users.User;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class UserRegistry {
    private final ArrayList<User> users;

    public UserRegistry() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean hasUser(User user) {
        return users.contains(user);
    }

    public User getUser(int i) {
        return users.get(i);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public int size(){
        return users.size();
    }

    public DefaultMutableTreeNode addInfo2GUI(){
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Пользователи");
        DefaultMutableTreeNode students = new DefaultMutableTreeNode("Студенты");
        DefaultMutableTreeNode tutors = new DefaultMutableTreeNode("Преподаватели");
        for (User user: users) {
            if(user instanceof Student) students.add(user.getNode());
            else tutors.add(user.getNode());
        }
        main.add(students);
        main.add(tutors);
        return main;
    }

}
