package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;

@Path("/users")
public class UserManager {
    private final Database database = new Database();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(@BeanParam UserForm userToCreate) {
        try {
            database.createUser(userToCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User[] getAllUsers() {
        User[] res = new User[0];
        try {
            res = database.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
