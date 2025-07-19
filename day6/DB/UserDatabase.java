package day6.DB;

import day6.entity.User;

public interface UserDatabase {
    boolean addUser(User user);

    User getUserByName(String username);
}
