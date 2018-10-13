package org.java.bin.reflection.bean;



/**
 * Created by wangbin on 17/1/21.
 */

public class User {
    private long id;
    private int age;
    private String uname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
