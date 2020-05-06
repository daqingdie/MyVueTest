package com.lq.demo.JSON;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class JsonTest_1 {
    @Test
    public void test_O2J() {
        MyUser myUser = new MyUser(111, "jack","boy","26");
        String s = JSON.toJSONString(myUser);
        System.out.println(s);
        List<MyUser> myUserList = new LinkedList<>();
        myUserList.add(myUser);
        MyUser myUser2 = new MyUser(111, "jack","boy","28");
        myUserList.add(myUser2);
        s = JSON.toJSONString(myUserList);
        System.out.println(s);
    }

    @Test
    public void test_J2O() {
        MyUser myUser = JSON.parseObject("{\"age\":\"26\",\"id\":111,\"name\":\"jack\",\"sex\":\"boy\"}", MyUser.class);
        System.out.println(myUser.getAge());

        List<MyUser> myUsers = JSON.parseArray("[{\"age\":\"26\",\"id\":111,\"name\":\"jack\",\"sex\":\"boy\"},{\"age\":\"28\",\"id\":111,\"name\":\"jack\",\"sex\":\"boy\"},{\"$ref\":\"$[0]\"}]", MyUser.class);
        for (MyUser user : myUsers) {
            System.out.println(user.getAge());
        }
    }

    private static class MyUser {
        public MyUser() {
        }
        public MyUser(int id, String name, String sex, String age) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        int id;
        String name;
        String sex;
        String age;
    }
}
