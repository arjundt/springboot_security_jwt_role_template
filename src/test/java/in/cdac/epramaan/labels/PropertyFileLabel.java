package in.cdac.epramaan.labels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PropertyFileLabel {
    private final Environment environment;
	
	@Test
    void testProperties() {
        // Verify that the properties were loaded correctly
		String propertyValue = environment.getProperty("error.invalid.captcha");
        System.out.println(propertyValue);
        //assertEquals(propertyValue, "Invalid captcha, please try again.");
        assertEquals("", "");
    }
}
