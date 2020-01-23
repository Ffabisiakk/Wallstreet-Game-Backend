package pl.hollow.wallstreet.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserFacade userFacade;

    @Test
    public void shouldFetchEmptyUserList() throws Exception {
//        Given
        List<User> userList = new ArrayList<>();
        when(userFacade.getUsers()).thenReturn(userList);

//        When & Then
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchUserList() throws Exception {
//        Given
        List<User> userList = new ArrayList<>();
        User user = new User("test_mail", BigDecimal.valueOf(1L), BigDecimal.valueOf(1L));
        user.setNickname("test_nickname");
        userList.add(user);
        when(userFacade.getUsers()).thenReturn(userList);

//        When & Then
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nickname", is("test_nickname")))
                .andExpect(jsonPath("$[0].email", is("test_mail")))
                .andExpect(jsonPath("$[0].cash", is("1")))
                .andExpect(jsonPath("$[0].bitcoin", is("1")));
    }

    @Test
    public void shouldFetchUser() throws Exception {
//        Given
        User user = new User("test_mail", BigDecimal.valueOf(1L), BigDecimal.valueOf(1L));
        user.setNickname("test_nickname");
        when(userFacade.getUser(anyString())).thenReturn(user);

//        When & Then
        mockMvc.perform(get("/users/anyString").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.nickname", is("test_nickname")))
                .andExpect(jsonPath("$.email", is("test_mail")))
                .andExpect(jsonPath("$.cash", is("1")))
                .andExpect(jsonPath("$.bitcoin", is("1")));
    }

}