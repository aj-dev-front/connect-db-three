package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DatabaseTest {
    @Mock
    DriverManager driverManagerMock;
    @Mock
    private Connection connectionMock;
    @Mock
    private Class driverClassMock;

    @InjectMocks
    private Database database;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDriverLoaded() throws ClassNotFoundException {
        when(Class.forName(anyString())).thenThrow(ClassNotFoundException.class);
        assertThrows(ClassCastException.class, Database::new);
    }
}