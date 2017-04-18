package com.janita.mock.one;

import com.janita.mock.one.bean.User;
import com.janita.mock.one.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Janita on 2017-04-18 20:11
 */
public class UserTest {

    private static UserService mockedUserServicee;
    private static User userOne;
    private static User userTwo;

    @BeforeClass
    public static void setUp() throws Exception {
        mockedUserServicee = mock(UserService.class);

        userOne = new User("id1","Janita",20);
        userTwo = new User("id2","Jay",30);

        when(mockedUserServicee.createUser(userOne)).thenReturn(userOne);
        when(mockedUserServicee.deleteUser("id1")).thenReturn(userOne);
        when(mockedUserServicee.updateUser("id1",userTwo)).thenReturn(userTwo);
        when(mockedUserServicee.findById("id2")).thenReturn(userTwo);
        when(mockedUserServicee.getAllUser()).thenReturn(Arrays.asList(userOne,userTwo));
    }

    @Test
    public void addUser() throws Exception {
        User user = mockedUserServicee.createUser(userOne);

        assertEquals("id1", user.getUserId());
        assertEquals("Janita", user.getName());
        assertEquals((Integer)20, user.getAge());
    }

    @Test
    public void deleteUser(){
        User user = mockedUserServicee.deleteUser("id1");
        assertEquals("id1", user.getUserId());
        assertEquals("Janita", user.getName());
        assertEquals((Integer)20, user.getAge());
    }

    @Test
    public void update(){
        User user = mockedUserServicee.updateUser("id1",userTwo);
        System.out.println("*******"+user);
    }

    @Test
    public void findById(){
        User user = mockedUserServicee.findById("id2");
        System.out.println("*******"+user);
    }

    @Test
    public void getAll(){
        List<User> users = mockedUserServicee.getAllUser();
        System.out.println("*******"+users);
    }
}
