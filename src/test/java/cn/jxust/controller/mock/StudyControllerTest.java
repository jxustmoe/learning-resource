package cn.jxust.controller.mock;

import cn.jxust.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StudyControllerTest extends BaseTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void add() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/studyRes/add")
                                                        .param("id","1")
                                                        .param("name","学习资料")
                                                        .param("link","pornhub.com")
                                                        .param("uploadTime","1998")
                                                        .param("categoryId","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode",is(500)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void delete() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/studyRes/delete")
                .param("resourceId","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode",is(200)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void update() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/studyRes/update")
                .param("id","1")
                .param("name","学习资料")
                .param("link","pornhub.com")
                .param("uploadTime","1998")
                .param("categoryId","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode",is(500)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void show1() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/studyRes/show"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.data.length()",is(5)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void show2() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/studyRes/show")
                                                    .param("categoryId","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.data.length()",is(3)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void show3() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/studyRes/show")
                                                    .param("keyword","keyword"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.data.length()",is(4)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
