package org.example.dto;

import org.example.entity.Role;

public class UserDto {
    private long userId;
    private String firstName;
    private String lastName;
    private int age;
    private Role roleId;

    public UserDto() {
    }

    public UserDto(long userId, String firstName, String lastName, int age, Role roleId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRoles() {
        return roleId;
    }

    public void setRoles(Role role) {
        this.roleId = role;
    }
}
