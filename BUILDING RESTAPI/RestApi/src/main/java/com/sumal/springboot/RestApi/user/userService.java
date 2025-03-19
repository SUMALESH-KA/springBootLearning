package com.sumal.springboot.RestApi.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
class userService {

    public UserDaoService service;
    public userService(UserDaoService service){
        this.service = service;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        List<User> users = service.getUsers();
        return users;
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable int id){
        User user =  service.getUser(id);
        if(user==null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User savedUser = service.adduser(user);
//        System.out.println("Saved User ID: " + savedUser.getId()); // Debug saved ID
//        System.out.println("Location URI: " + ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable int id) {
        List<User> updatedUsers = service.DeleteUser(id);
        if (updatedUsers == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUsers); // Return the updated list of users
    }

}
