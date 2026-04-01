package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ici on test la calculette")
class CalculatorTest {
    Calculator calculator = new Calculator();

    @BeforeEach
    void setup() {
        IO.println("execution de test");
    }

    @Nested
    @DisplayName("soustraction corrects")
    class SubtractionTests {
        @Test
        void soustractions() {
            assertAll(
                    "La on test tous les cas",
                    () -> assertEquals(0, calculator.substract(2, 2), "2-2==0"),
                    () -> assertEquals(10, calculator.substract(12, 2), "12-2==10")
            );
        }
    }

    @Nested
    @DisplayName("addition de dingue")
    class AdditionTests {
        @BeforeAll
        static void beforeAll() {
            IO.println("Testing Calculator");
        }

        @Test
        @DisplayName("2 + 2 == 4")
        void twoPlusTwoShouldBeFour() {
            assertEquals(4, calculator.add(2, 2));
        }

        @Test
        @DisplayName("3 + 7 == 10")
        void threePLusSevenShouldBeTen() {
            assertEquals(10, calculator.add(3, 7));
        }
    }
}
