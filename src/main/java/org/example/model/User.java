package org.example.model;

import java.util.Objects;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String mobile;

    public User(String id, String name, String email, String mobile){
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getId(){return id;}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile(){
        return mobile;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && this.id.equals(((User) obj).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
