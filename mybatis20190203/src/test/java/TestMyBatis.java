import com.test.mybatis.entity.User;
import com.test.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class TestMyBatis {

    @Test(description = "namespace=UserMapper,接口中方法名=id")
    public void TestInputStream() throws IOException {

        String resource = "config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();

        UserMapper usermapper = session.getMapper(UserMapper.class);

        User user = usermapper.selectById(300);
        List<User> users = usermapper.selectAll();


        System.out.println(user);
        System.out.println("==============");

        System.out.println(users);
        session.close();
        }


    @Test(description = "新增记录")
    public void Add() throws IOException {

        Reader reader =Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reader);

        SqlSession session =sessionFactory.openSession();
        UserMapper usermapper = session.getMapper(UserMapper.class);


        User user= new User();
        user.setName("may");
        user.setAge(18);
        user.setPassword("54321");
        user.setPhone("18976532121");
        user.setFlag(false);


        int count = usermapper.addUser(user);
        System.out.println(count);
        session.commit();
        System.out.println(user);
        session.close();
    }


    @Test(description = "更新记录")
    public void Update() throws IOException {

        Reader reader =Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session =sessionFactory.openSession();
        UserMapper usermapper = session.getMapper(UserMapper.class);


        User user= new User();
        user.setId(300);
        user.setName("may");
        user.setAge(20);
        user.setPassword("22222");
        user.setPhone("1599660000");


        int count = usermapper.updateUser(user);
        System.out.println(count);
        session.commit();
        System.out.println(user);
        session.close();
    }


    @Test(description = "删除记录")
    public void Delete() throws IOException {

        Reader reader =Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reader,"development");

        SqlSession session =sessionFactory.openSession();
        UserMapper usermapper = session.getMapper(UserMapper.class);

        int count = usermapper.deleteUserById(308);
        System.out.println(count);
        session.commit();
        session.close();
    }

}