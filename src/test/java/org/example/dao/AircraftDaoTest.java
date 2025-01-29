package org.example.dao;

import org.example.AppTest;
import org.example.config.ConfigurationDbTest;
import org.example.entity.Aircraft;
import org.example.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        AppTest.class,
        ConfigurationDbTest.class})
@ActiveProfiles("test")
public class AircraftDaoTest {
    public static List<Aircraft> aircraftList;
    @Autowired
    private AircraftDao aircraftDao;

    @BeforeAll
    public static void setUp() {
        aircraftList = Stream.of(
                new Aircraft(1L, 180L, 123456L, "Boeing 737"),
                new Aircraft(2L, 250L, 654321L, "Airbus A320"),
                new Aircraft(3L, 300L, 789012L, "Boeing 777"),
                new Aircraft(4L, 200L, 890123L, "Airbus A330"),
                new Aircraft(5L, 350L, 567890L, "Boeing 787"),
                new Aircraft(6L, 220L, 456789L, "Embraer E190"),
                new Aircraft(7L, 280L, 345678L, "Airbus A350"),
                new Aircraft(8L, 170L, 234567L, "Bombardier CRJ900"),
                new Aircraft(9L, 160L, 123789L, "ATR 72"),
                new Aircraft(10L, 190L, 987654L, "Boeing 757")
        ).toList();
    }

    @Test
    void saveData() {
        Aircraft aircraft1 = aircraftList.get(0);
        Aircraft aircraft = aircraftDao.save(aircraft1);
        aircraft1.setAircraftId(aircraft.getAircraftId());

        assertEquals(aircraft1, aircraft);
        aircraftDao.delete(aircraft1);
    }

    @Test
    void  getById(){
        Aircraft aircraft1=aircraftDao.save(aircraftList.get(0));
        Aircraft aircraft=aircraftDao.getById(aircraft1.getAircraftId());

        assertEquals(aircraft1,aircraft);
    }

    @Test
    void getAll(){
        List<Aircraft>aircraftList=aircraftDao.getAll();

        assertNotNull(aircraftList);
        assertEquals(10, aircraftList.size());
    }

}
