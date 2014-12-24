package com.github.loafer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.github.loafer.user.User;
import com.github.loafer.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"/user-servlet.xml"})
public class UserTest {
    @Resource
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testValidatingMethodConstrainsOnService() throws Exception {
        mockMvc.perform(
                post("/users")
                .param("name", "1111")
                .param("password","123456")
                .accept(MediaType.parseMediaType("application/json;charset=utf-8"))
        )
        .andExpect(jsonPath("$.success").value(Boolean.FALSE))
        .andDo(print());
    }

    @Test
    public void testValidatingMethodConstrainsOnController() throws Exception {
        mockMvc.perform(
                post("/users/123456/password")
                .param("newPassword", "123456")
                .param("confirmation", "654321")
                .accept(MediaType.parseMediaType("application/json;charset=utf-8"))
        )
        .andExpect(jsonPath("$.success").value(Boolean.FALSE))
        .andDo(print());
    }

}
