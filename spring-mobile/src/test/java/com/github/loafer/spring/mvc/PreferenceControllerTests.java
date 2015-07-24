package com.github.loafer.spring.mvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.github.loafer.spring.mvc.mobile.preference.PreferenceController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author zhaojh.
 */
public class PreferenceControllerTests {
    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = standaloneSetup(new PreferenceController())
                .addInterceptors(new SitePreferenceHandlerInterceptor())
                .setCustomArgumentResolvers(new SitePreferenceHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    public void perferenceNormal() throws Exception {
        mockMvc.perform(get("/preference?site_preference=normal"))
                .andExpect(content().string("Site preference is normal"));
    }

    @Test
    public void preferenceMobile() throws Exception {
        mockMvc.perform(get("/preference?site_preference=mobile"))
                .andExpect(content().string("Site preference is mobile"));
    }

    @Test
    public void preferenceTablet() throws Exception {
        mockMvc.perform(get("/preference?site_preference=tablet"))
                .andExpect(content().string("Site preference is tablet"));
    }

}
