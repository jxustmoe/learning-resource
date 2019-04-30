package cn.jxust;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@WebAppConfiguration //加载web.xml
public abstract class BaseTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
    }
}
