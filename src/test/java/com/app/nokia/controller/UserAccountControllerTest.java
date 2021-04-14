package com.app.nokia.controller;

import com.app.nokia.entity.UserAccount;
import com.app.nokia.model.dto.CreateUserAccountDto;
import com.app.nokia.services.UserAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserAccountController.class)
@EnableWebMvc
public class UserAccountControllerTest {
    private static final String BASE_URL = "/v1";
    private static final String USER_ACCOUNT = "/user-account";
    private static final String SLASH = "/";


    private static final Long ID = 1L;
    private static final Long ID2 = 2L;
    private static final String NAME = "Burak Kilinc";
    private static final String NAME2 = "Berk Kilinc";
    private static final String COUNTRY = "Turkey";
    private static final String PHONE = "905343552679";
    private static final String EMAIL = "burakilinc.7@gmail.com";
    private static final String ADDRESS = "Istanbul, Umraniye";
    private static final String DEPARTMENT = "R&D Department";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;
    @InjectMocks
    private UserAccountController userAccountController;
    @MockBean
    private UserAccountService userAccountService;
    @Autowired
    private WebApplicationContext wac;

    public UserAccountControllerTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userAccountController).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void createUserAccount() throws Exception {
        UserAccount userAccount = UserAccount.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .department(DEPARTMENT)
                .country(COUNTRY)
                .address(ADDRESS)
                .phone(PHONE)
                .build();
        CreateUserAccountDto createUserAccountDto = CreateUserAccountDto.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .department(DEPARTMENT)
                .country(COUNTRY)
                .address(ADDRESS)
                .phone(PHONE)
                .build();
        when(userAccountService.createUserAccount(createUserAccountDto)).thenReturn(userAccount);
        mockMvc.perform(post(BASE_URL + USER_ACCOUNT)
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(createUserAccountDto)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void getUserAccount() throws Exception {
        UserAccount userAccount = UserAccount.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .department(DEPARTMENT)
                .country(COUNTRY)
                .address(ADDRESS)
                .phone(PHONE)
                .build();
        when(userAccountService.findById(any())).thenReturn(userAccount);
        mockMvc.perform(get(BASE_URL + USER_ACCOUNT + SLASH + ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void testGetAllUserAccount() throws Exception {
        UserAccount userAccount = UserAccount.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .department(DEPARTMENT)
                .country(COUNTRY)
                .address(ADDRESS)
                .phone(PHONE)
                .build();
        UserAccount userAccount2 = UserAccount.builder()
                .id(ID2)
                .name(NAME2)
                .email(EMAIL)
                .department(DEPARTMENT)
                .country(COUNTRY)
                .address(ADDRESS)
                .phone(PHONE)
                .build();

        List<UserAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(userAccount);
        bankAccountList.add(userAccount2);

        when(userAccountService.getAll()).thenReturn(bankAccountList);
        mockMvc.perform(get(BASE_URL + USER_ACCOUNT)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
