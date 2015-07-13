package com.github.loafer.spring.mvc.convert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"/example-servlet.xml"})
public class ConvertControllerWithXmlTests {
    private MockMvc mockMvc;
    @Resource
    private WebApplicationContext context;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void primitive() throws Exception {
        mockMvc.perform(get("/convert/primitive").param("value", "2"))
                .andExpect(content().string("Converted primitive 2"));
    }

    @Test
    public void date() throws Exception {
        mockMvc.perform(get("/convert/date/2015-07-09"))
                .andExpect(content().string("Converted date Thu Jul 09 00:00:00 CST 2015"));
    }

    @Test
    public void collection() throws Exception {
        mockMvc.perform(get("/convert/collection?values=1&values=2&values=3"))
                .andExpect(content().string("Converted collection [1, 2, 3]"));
    }

    @Test
    public void collection2() throws Exception {
        mockMvc.perform(get("/convert/collection2?values=2015-07-01&values=2015-07-02&values=2015-07-03"))
                .andExpect(content().string("Converted collection [Wed Jul 01 00:00:00 CST 2015, Thu Jul 02 00:00:00 CST 2015, Fri Jul 03 00:00:00 CST 2015]"));
    }
}
