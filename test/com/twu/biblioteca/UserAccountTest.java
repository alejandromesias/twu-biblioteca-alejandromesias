package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserAccountTest {

    private UserAccount oneUserAccount;

    @Before
    public void setUp(){
        oneUserAccount = new UserAccount(1231234,
                "TestPassword!",
                "testName",
                "testName@email.com",
                "0986424406");
    }

    @Test
    public void shouldHaveCreatedANewUser() {
        assertEquals(1231234, oneUserAccount.getBibliotecaId());
        assertEquals("TestPassword!", oneUserAccount.getPassword());
        assertEquals("testName", oneUserAccount.getUserName());
        assertEquals("testName@email.com", oneUserAccount.getUserEmail());
        assertEquals("0986424406", oneUserAccount.getUserPhone());
    }
}