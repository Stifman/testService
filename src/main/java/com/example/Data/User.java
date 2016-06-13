package com.example.data;

public class User {
    private int id;
    private String name;
    private String secondname;
    private String email;
    private String role;

    public User(){}

    private User(Builder builder) {
        id = builder.id;
        name = builder.name;
        secondname = builder.secondname;
        email = builder.email;
        role = builder.role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public static final class Builder {
        private int id;
        private String name;
        private String secondname;
        private String email;
        private String role;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder secondname(String val) {
            secondname = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder role(String val) {
            role = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
