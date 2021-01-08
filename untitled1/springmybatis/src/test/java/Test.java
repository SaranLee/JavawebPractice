import demo.mapper.ProductMapper;
import demo.domain.Product;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-config.xml")
public class Test {
    @Autowired
    private ProductMapper productMapper;

    @org.junit.Test
    public void t1(){
        List<Product> products = productMapper.selectByExample(null);
        products.stream().forEach(System.out::println);
    }
}
