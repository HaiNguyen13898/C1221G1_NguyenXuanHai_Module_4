package com.codegym.repository;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    static private List<User> users = new ArrayList<>();
    static {
        users.add(new User("john", "123456", "John","john@codegym.vn", 10 ));
        users.add(new User("bill", "123456", "Bill","bill@codegym.vn", 16 ));
        users.add(new User("mike", "123456", "Mike","mike@codegym.vn", 20 ));
    }


    public static User checkLogin(Login login){
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
