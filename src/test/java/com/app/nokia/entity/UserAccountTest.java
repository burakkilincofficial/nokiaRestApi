package com.app.nokia.entity;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;


@RunWith(SpringJUnit4ClassRunner.class)
class UserAccountTest extends TestCase {
    private static final Long ID = 1L;
    private static final String COUNTRY = "Turkey";
    private static final String NAME = "Burak Kilinc";
    private static final String PHONE = "905343552679";
    private static final String EMAIL = "burakilinc.7@gmail.com";
    private static final String ADDRESS = "Istanbul, Umraniye";
    private static final String DEPARTMENT = "R&D Department";
    private static final String FIELDS_NOT_MATCH = "Fields did not match";
    private static final String FIELDS_WAS_NOT_RETRIEVED = "field was not retrieved properly";
    UserAccount pojo;

    @BeforeEach
    public void setUp() {
        pojo = new UserAccount();
    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(pojo, ID);

        //when
        final Long result = pojo.getId();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, ID);
    }

    @Test
    void getNameTest() throws IllegalAccessException, NoSuchFieldException {
        final Field field = pojo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(pojo, NAME);

        //when
        final String result = pojo.getName();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, NAME);
    }

    @Test
    void getPhone() throws IllegalAccessException, NoSuchFieldException {
        final Field field = pojo.getClass().getDeclaredField("phone");
        field.setAccessible(true);
        field.set(pojo, PHONE);

        //when
        final String result = pojo.getPhone();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, PHONE);
    }

    @Test
    void getEmail() throws IllegalAccessException, NoSuchFieldException {
        final Field field = pojo.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(pojo, EMAIL);

        //when
        final String result = pojo.getEmail();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, EMAIL);
    }

    @Test
    void getAddress() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("address");
        field.setAccessible(true);
        field.set(pojo, ADDRESS);

        //when
        final String result = pojo.getAddress();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, ADDRESS);
    }

    @Test
    void getCountry() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("country");
        field.setAccessible(true);
        field.set(pojo, COUNTRY);

        //when
        final String result = pojo.getCountry();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, COUNTRY);
    }

    @Test
    void getDepartment() throws NoSuchFieldException, IllegalAccessException {
        final Field field = pojo.getClass().getDeclaredField("department");
        field.setAccessible(true);
        field.set(pojo, DEPARTMENT);

        //when
        final String result = pojo.getDepartment();

        //then
        assertEquals(FIELDS_WAS_NOT_RETRIEVED, result, DEPARTMENT);
    }

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setId(ID);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), ID);
    }

    @Test
    void setName() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setName(NAME);

        //then
        final Field field = pojo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), NAME);
    }

    @Test
    void setPhone() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setPhone(PHONE);

        //then
        final Field field = pojo.getClass().getDeclaredField("phone");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), PHONE);
    }

    @Test
    void setEmail() throws IllegalAccessException, NoSuchFieldException {
        //when
        pojo.setEmail(EMAIL);

        //then
        final Field field = pojo.getClass().getDeclaredField("email");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), EMAIL);
    }

    @Test
    void setAddress() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setAddress(ADDRESS);

        //then
        final Field field = pojo.getClass().getDeclaredField("address");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), ADDRESS);
    }

    @Test
    void setCountry() throws IllegalAccessException, NoSuchFieldException {
        //when
        pojo.setCountry(COUNTRY);

        //then
        final Field field = pojo.getClass().getDeclaredField("country");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), COUNTRY);
    }

    @Test
    void setDepartment() throws NoSuchFieldException, IllegalAccessException {
        //when
        pojo.setDepartment(DEPARTMENT);

        //then
        final Field field = pojo.getClass().getDeclaredField("department");
        field.setAccessible(true);
        assertEquals(FIELDS_NOT_MATCH, field.get(pojo), DEPARTMENT);
    }

    @Test
    void testEquals() {
        UserAccount userAccount = UserAccount.builder()
                .id(ID)
                .build();
        UserAccount userAccount1 = UserAccount.builder()
                .id(ID)
                .build();

        assertEquals(userAccount, userAccount1);
    }

    @Test
    void testHashCode() {
        UserAccount userAccount = UserAccount.builder()
                .id(ID)
                .build();
        UserAccount userAccount1 = UserAccount.builder()
                .id(ID)
                .build();

        assertEquals(userAccount.hashCode(), userAccount1.hashCode());
    }
}