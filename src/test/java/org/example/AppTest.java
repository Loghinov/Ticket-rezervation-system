package org.example;


import org.example.config.ConfigurationDbTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = {
        AppTest.class,
        ConfigurationDbTest.class})
@ActiveProfiles("test")
public class AppTest{
    @Test
    void contextLoads(){
        
    }
}
