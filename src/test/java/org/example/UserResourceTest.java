package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserResourceTest {
    @Mock
    private Database database;

    private UserResource userResource;

    @BeforeEach
    void setUp() {
        userResource = new UserResource(database);
    }

    @Test
    @DisplayName("should return all Users from DB")
    void getAllUsers() throws SQLException {
        User[] expected = new User[]{new User("test", "test")};
        when(database.getAllUsers()).thenReturn(expected);
        assertArrayEquals(expected, userResource.getAllUsers());
    }

    @Test
    @DisplayName("should handle exception")
    void getUserNotFound() throws SQLException {
        when(database.getAllUsers()).thenThrow(SQLException.class);
        assertArrayEquals(new User[0], userResource.getAllUsers());
    }
}