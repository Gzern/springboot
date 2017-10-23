package lianjia.test;


import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


//配置Sping的单元测试环境
@RunWith(SpringJUnit4ClassRunner.class)

//加载SpringBoot的配置类
@SpringBootTest(classes=DemoApplication.class)
//指定这是一个web项目
@WebAppConfiguration
public class Demo1 {

    @Test
    public void test(){

    }
}
