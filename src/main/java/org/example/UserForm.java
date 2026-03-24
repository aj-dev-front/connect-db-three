package org.example;

import jakarta.ws.rs.FormParam;

public class UserForm {
    @FormParam("email")
    private String email;

    @FormParam("name")
    private String name;

    String getEmail() {
        return email;
    }

    String getName() {
        return name;
    }
}