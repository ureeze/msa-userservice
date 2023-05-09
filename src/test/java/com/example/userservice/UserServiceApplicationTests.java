package com.example.userservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
    ApplicationContext context;


    @Test
    void contextLoads() throws JsonProcessingException {
        String json = "{ \"name\" : \"Ryan\", \"age\" : 30 }";
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);

        System.out.println(user);
    }

    @Test
    void test2() throws JsonProcessingException {
        User user = new User("abc", 12);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(user);

        System.out.println(str);
    }

    public static class User {

        private String name;
        private int age;

        public User() {

        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
