package com.neeson.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by daile on 2017/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityControllerTest {

    /*测试流程
    * 1.准备测试环境
    * 2.通过MovkMvc执行请求
    * 3.1 添加验证断言
    * 3.2 添加结果处理器
    * 3.3 得到MVCResult进行自定义断言/进行下一步的异步请求
    * 4. 卸载测试环境
    * */
    private MockMvc mvc;
    RequestBuilder request;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new CityController()).build();
    }
    //对dao层使用内嵌数据库或者mock
    @Test
    public void saveCity() throws Exception {
        request = post("/city/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 88, \"name\": \"string\"}");
        mvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("success")));
    }

}