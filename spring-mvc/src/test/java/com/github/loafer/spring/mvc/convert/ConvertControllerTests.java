package com.github.loafer.spring.mvc.convert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author zhaojh.
 */
public class ConvertControllerTests {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
        conversionService.addFormatter(new DateFormatter("yyyy-MM-dd"));

        mockMvc = standaloneSetup(new ConvertController())
                .setConversionService(conversionService)
                .alwaysExpect(status().isOk())
                .build();
    }

    @Test
    public void primitive() throws Exception {
        mockMvc.perform(get("/convert/primitive").param("value", "2"))
                .andExpect(content().string("Converted primitive 2"));
    }

    @Test
    public void date() throws Exception {
        mockMvc.perform(get("/convert/date/2015-07-09"))
                .andDo(print())
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

    @Test
    public void beanPrimitive() throws Exception {
        mockMvc.perform(get("/convert/bean?primitive=3"))
                .andExpect(content().string("Converted JavaBean primitive=3"));
    }

    @Test
    public void beanDate() throws Exception {
        mockMvc.perform(get("/convert/bean?date=2015-07-09"))
                .andExpect(content().string("Converted JavaBean date=Thu Jul 09 00:00:00 CST 2015"));
    }

    @Test
    public void beanCollection() throws Exception {
        mockMvc.perform(get("/convert/bean?list=1&list=2&list=3"))
                .andExpect(content().string("Converted JavaBean list=[1, 2, 3]"));
    }

    @Test
    public void beanMap() throws Exception {
        mockMvc.perform(get("/convert/bean?map[a]=1&map[b]=2"))
                .andExpect(content().string("Converted JavaBean map={a=1, b=2}"));
    }

    @Test
    public void beanMap2() throws Exception {
        mockMvc.perform(post("/convert/bean").param("map[a]", "1").param("map[b]", "2"))
                .andExpect(content().string("Converted JavaBean map={a=1, b=2}"));
    }

    @Test
    public void beanNested() throws Exception {
        mockMvc.perform(get("/convert/bean?nested.foo=bar&nested.list[0].foo=baz&nested.map[key].list[0].foo=bip"))
                .andExpect(content().string("Converted JavaBean nestedBean=NestedBean foo=bar list=[NestedBean foo=baz] map={key=NestedBean list=[NestedBean foo=bip]}"))
                .andDo(print());
    }

    @Test
    public void beanNested2() throws Exception {
        mockMvc.perform(
                post("/convert/bean").param("nested.foo", "bar")
                        .param("nested.list[0].foo", "baz")
                        .param("nested.map[key].list[0].foo", "bip")
        ).andExpect(content().string("Converted JavaBean nestedBean=NestedBean foo=bar list=[NestedBean foo=baz] map={key=NestedBean list=[NestedBean foo=bip]}"));
    }

    @Test
    public void bind() throws Exception {
        mockMvc.perform(post("/convert/bind").param("bean1.primitive", "4").param("bean2.primitive", "2"))
                .andDo(print())
                .andExpect(content().string("Converted [JavaBean primitive=4] and [JavaBean primitive=2]"));
    }

    @Test
    public void bindBeanPrimitive() throws Exception {
        mockMvc.perform(get("/convert/bind?bean1.primitive=1&bean2.primitive=2"))
                .andDo(print())
                .andExpect(content().string("Converted [JavaBean primitive=1] and [JavaBean primitive=2]"));
    }

    @Test
    public void bindBeanDate() throws Exception {
        mockMvc.perform(get("/convert/bind?bean1.date=2015-07-09&bean2.date=2015-07-10"))
                .andDo(print())
                .andExpect(content().string("Converted [JavaBean date=Thu Jul 09 00:00:00 CST 2015] and [JavaBean date=Fri Jul 10 00:00:00 CST 2015]"));
    }

    @Test
    public void bindBeanCollection() throws Exception {
        mockMvc.perform(get("/convert/bind?bean1.list=1&bean1.list=2&bean1.list=3&bean2.list=10&bean2.list=20&bean2.list=30"))
                .andDo(print())
                .andExpect(content().string("Converted [JavaBean list=[1, 2, 3]] and [JavaBean list=[10, 20, 30]]"));
    }

    @Test
    public void bindBeanMap() throws Exception {
        mockMvc.perform(get("/convert/bind?bean1.map[1]=a&bean1.map[2]=b&bean2.map[a]=1&bean2.map[b]=2"))
                .andExpect(content().string("Converted [JavaBean map={1=a, 2=b}] and [JavaBean map={a=1, b=2}]"));
    }

    @Test
    public void bindNested() throws Exception {
        mockMvc.perform(get("/convert/bind?bean1.nested.foo=Hi&bean1.nested.list[0].foo=hello&bean1.nested.map[key].list[0].foo=world&bean2.nested.foo=I&bean2.nested.list[0].foo=Love&bean2.nested.map[key].list[0].foo=U"))
                .andDo(print())
                .andExpect(content().string("Converted [JavaBean nestedBean=NestedBean foo=Hi list=[NestedBean foo=hello] map={key=NestedBean list=[NestedBean foo=world]}] and [JavaBean nestedBean=NestedBean foo=I list=[NestedBean foo=Love] map={key=NestedBean list=[NestedBean foo=U]}]"));
    }
}
