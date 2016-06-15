package com.example.services.dto;

public class UserDto {
    private Long id;

    private String name;

    private String secondname;

    private String email;

    private String role;

    public Long getId() {
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

    private UserDto(Builder builder) {
        id = builder.id;
        name = builder.name;
        secondname = builder.secondname;
        email = builder.email;
        role = builder.role;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String secondname;
        private String email;
        private String role;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withSecondname(String val) {
            secondname = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withRole(String val) {
            role = val;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondname='" + secondname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
