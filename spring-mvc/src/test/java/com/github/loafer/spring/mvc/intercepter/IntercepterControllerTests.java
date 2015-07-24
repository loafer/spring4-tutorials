package com.github.loafer.spring.mvc.intercepter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author zhaojh.
 */
public class IntercepterControllerTests {
    private MockMvc mockMvc;

    @Before
    public void setup(){
        OfficeHoursInterceptor hoursInterceptor = new OfficeHoursInterceptor();
        hoursInterceptor.setOpeningTime(9);
        hoursInterceptor.setClosingTime(17);

        mockMvc = MockMvcBuilders.standaloneSetup(new InterceptorController())
                .addInterceptors(hoursInterceptor).build();
    }

    @Test
    public void openingTime() throws Exception {
        mockMvc.perform(get("/interceptors/welcome"))
                .andDo(print())
                .andExpect(content().string("opening time"));
    }
}
