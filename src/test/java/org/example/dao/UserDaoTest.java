package org.example.dao;

import org.example.AppTest;
import org.example.config.ConfigurationDbTest;
import org.example.configuration.DataBaseConfig;
import org.example.dao.Impl.UserDaoImpl;
import org.example.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        AppTest.class,
        ConfigurationDbTest.class})
@ActiveProfiles("test")
public class UserDaoTest {
    public static List<User> userList;
    @Autowired
    private UserDao userDao;
    @BeforeAll
    public static void setUp(){
        userList= Stream.of(
                new User("Aleksei", "Smith", 34, 2),
                new User("Vanea", "Lesan", 24, 1),
                new User("Daniel", "Docks",54,3),
                new User("Maks", "Park", 39,4),
                new User("Philips", "Morpth", 26,5),
                new User ("antonio", "fernandes", 24,3),
                new User("Karim", "Benzema", 33,1),
                new User("Lioneli", "Messi", 38, 3),
                new User(" Pablo", "Alonso", 42,1),
                new User("Didier", "Drogba", 54,2)
        ).toList();
    }
    @Test
    void saveData(){
        User user1 = userList.get(0);
        User user =userDao.save(user1);
        user1.setUserId(user.getUserId());

        assertEquals(user1,user);
        assertEquals(user1.getFirstName(),user.getFirstName());
        assertEquals(user1.getUserId(), user.getUserId());
    }
    @Test
    void getById(){
        User user1 =userDao.save(userList.get(0));
        User user =userDao.getById(user1.getUserId());

        assertEquals(user1,user);
        assertEquals(user1.getFirstName(),user.getFirstName());
        assertEquals(user1.getUserId(), user.getUserId());

    }
    @Test
    void getAll(){

        List<User>userList=userDao.getAll();

        assertNotNull(userList);
        assertEquals(userList.size(),10);
       assertEquals(userList.get(0),userList.get(0));
       assertEquals(userList.get(1).getFirstName(),userList.get(1).getFirstName());

    }

    @Test

    }
}
