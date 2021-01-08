import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.mapper.CategoryDao;
import demo.mapper.ProdMapper;
import demo.mapper.ProductDao;
import demo.mapper.UserDao;
import demo.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

public class MyBatisTest {

    private SqlSession sqlSession;
    private UserDao mapper;
    private ProductDao productMapper;
    private CategoryDao categoryMapper;
    private ProdMapper prodMapper;
    @Before
    public void before(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis/config/mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            sqlSession.getConnection().setAutoCommit(true);
            mapper = sqlSession.getMapper(UserDao.class);
            productMapper = sqlSession.getMapper(ProductDao.class);
            categoryMapper = sqlSession.getMapper(CategoryDao.class);
            prodMapper = sqlSession.getMapper(ProdMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t1(){
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void t2(){
        List<User> list = mapper.getUserByAddrAndSex("上海", "1");
        list.stream().forEach(System.out::println);
    }

    @Test
    public void t3(){
        User user = new User();
        user.setAddress("上海");
        user.setSex("1");
        List<User> list = mapper.getUserByAddrAndSexUser(user);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void t4(){
        List<String> addrs = new ArrayList<>();
        addrs.add("广州");
        addrs.add("北京");
        addrs.add("上海");
        addrs.add("深圳");
        List<User> list = mapper.getUserByAddrs(addrs);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void t5(){
        List<User> list = mapper.getUserLikeName("王");
        list.stream().forEach(System.out::println);
    }

    @Test
    public void t6(){
        List<User> list = mapper.getUserLikeName1("王");
        list.stream().forEach(System.out::println);
    }

    @Test
    public void t7(){
        User user = new User("龙哥", new Date(), "0","重庆");
        mapper.insertUser(user);
        System.out.println(user);
        sqlSession.commit();
    }

    @Test
    public void t8(){
        User user = new User("龙哥", new Date(), "0","成都");
        mapper.updateUserByUsername(user);
    }

    @Test
    public void t9(){
        Map<Integer, User> users = mapper.getUsers();
        Iterator<Integer> itr = users.keySet().iterator();
        while(itr.hasNext()){
            int key = itr.next();
            User user = users.get(key);
            System.out.println(user);
        }
    }

    @Test
    public void t10(){
        User user = new User();
        user.setSex("1");
        user.setAddress("上海");
        List<User> list = mapper.listByUser(user);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void t11(){
        User user = new User();
        user.setId(29);
        user.setSex("1");
        user.setAddress("绵阳");
        mapper.updateUserById(user);
    }

    @Test
    public void t12(){
        User user1 = new User("fcy", new Date(), "1", "宝鸡");
        User user2 = new User("ljj", new Date(), "1", "绵阳");
        User user3 = new User("lk", new Date(), "1", "安庆");
        List<User> list = Arrays.asList(user1, user2, user3);
        mapper.insertUsers(list);

        list.stream().forEach(x->{
            System.out.println(x.getId());
        });
    }

    @Test
    public void t13(){
        Product prod = productMapper.getProductById("p001");
        System.out.println(prod);
    }

    @Test
    public void t14(){
        Category category = categoryMapper.getCategoryById("c001");
        System.out.println(category);
    }

    @Test
    public void t15(){
        ProdExample example = new ProdExample();
        example.createCriteria().andPidEqualTo("p001");
        List<Prod> prods = prodMapper.selectByExample(example);
        System.out.println(prods.get(0));
    }

    @Test
    public void t16(){
        PageHelper.startPage(2, 6);
        ProdExample example = new ProdExample();
        List<Prod> prods = prodMapper.selectByExample(example);
        PageInfo<Prod> pageInfo = new PageInfo<>(prods);
        pageInfo.getList().stream().forEach(System.out::println);
    }
}
