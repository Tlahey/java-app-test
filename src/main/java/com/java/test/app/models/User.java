package com.java.test.app.models;

public class User {

    private static final String template = "[%d] Hello, %s %s !";

    private final String firstName;
    private final String lastName;
    private final Long id;

    public User(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format(template, this.id, lastName, firstName);
    }

}
