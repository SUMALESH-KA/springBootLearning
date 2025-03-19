package com.sumal.springboot.RestApi.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

@Component
public class UserDaoService {
     static List<User> users = new ArrayList<>();
     static int userCount = 1;
     static{
         users.add(new User(userCount++, "sumal", LocalDate.now().plusYears(1)));
         users.add(new User(userCount++, "madhu", LocalDate.now().plusYears(2)));
         users.add(new User(userCount++, "murugan", LocalDate.now().plusYears(3)));

     }
        public static List<User> getUsers() {
            return users;
        }
        public static User getUser(int id){
            for(User user:users){
                if(user.getId() == id)
                    return user;
            }
            return null;
        }
        public static User adduser(User user){
            user.setId(userCount++);
            users.add(user);
            return user;
        }

        @org.jetbrains.annotations.Nullable
        public static List<User> DeleteUser(int id){
            for(User user:users){
                if(user.getId() == id){
                    users.remove(user);
                    return users;
                }
            }
            return null;
        }
}
