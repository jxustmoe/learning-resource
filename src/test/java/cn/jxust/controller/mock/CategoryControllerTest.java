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


public class CategoryControllerTest extends BaseTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void addCategory() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/category/add")
                                                    .param("id","1")
                                                    .param("name","1")
                                                    .param("pid","1"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode",is(500)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deleteCategory() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/category/delete")
                .param("categoryId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode", is(200)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void alterCategory() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/category/update")
                                                    .param("id","1")
                                                    .param("name","1")
                                                    .param("pid","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode", is(500)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void showCategory() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/category/show"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].length()", is(5)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
