package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class AuthenticationResourceTest {
    @InjectMocks
    AuthenticationResource authenticationResource;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("/authentication should authenticate user")
    void authenticateUser() {
    }
}