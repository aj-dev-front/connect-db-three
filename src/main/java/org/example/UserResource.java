package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;

@Path("/users")
public class UserResource {
    private final Database database;

    UserResource() {
        database = new Database();
    }

    UserResource(Database database) {
        this.database = database;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User userToCreate) {
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
