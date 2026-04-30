import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void sayHello() {
        // Given
        String expected = "Hello World";
        // When
        String result = Main.sayHello();
        // Then
        assertEquals(expected, result);
    }
}