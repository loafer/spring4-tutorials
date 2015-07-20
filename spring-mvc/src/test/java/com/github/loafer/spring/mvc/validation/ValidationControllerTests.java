package com.github.loafer.spring.mvc.validation;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"/validation-context.xml"})
public class ValidationControllerTests {
    private MockMvc mockMvc;
    @Resource
    private WebApplicationContext context;

    @Before
    public void setup(){
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void validateError() throws Exception {
        mockMvc.perform(get("/validation?number=8&date=2015-07-16"))
                .andExpect(content().string("Object has validation errors"));
    }

    @Test
    public void validateSuccess() throws Exception {
        mockMvc.perform(get("/validation?number=3&date=2015-07-21"))
                .andExpect(content().string("No errors"));
    }
}
