package com.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//表示测试的是Controller
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mvc.xml"})
public class StudentControllerTest {
    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;
    @Before//在所有测试执行之前，调用该方法
    public void setUp() throws Exception {
        mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getStudent() throws Exception {
        String json="{\"id\":1,\"name\":\"jack\",\"age\":18}";
        //perform发送请求
        mockMvc.perform(get("/student/get.do",1).param("id","1"))
                .andExpect(status().isOk())
                .andExpect(content().string(json))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void hello() throws Exception {
        mockMvc.perform(post("/student/hello.do"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name","tom"))
                .andExpect(model().attribute("age",18));

    }
}