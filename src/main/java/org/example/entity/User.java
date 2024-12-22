package org.example.entity;

public class User {
    private long userId;
    private String firstName;
    private String lastName;
    private int age;
    private long roleId;

    public User() {};
    public User(long userId, String firstName, String lastName, int age, long roleId) {
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

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    @Override
    public String toString() {
        return "User id: "+ userId +" First name: "+firstName+" Last name: "+lastName+" Age: "+age+" Role id: "+roleId;
    }
}
