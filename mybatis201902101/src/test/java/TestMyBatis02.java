import com.test.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class TestMyBatis02 {

    @Test(description = "新增记录")
    public void Add() throws IOException {

        Reader reader =Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reader);

        SqlSession session =sessionFactory.openSession();
        String statement = "useraaa.addUser";
        User user= new User();
        user.setName("may");
        user.setAge(20);
        user.setPassword("12345678");
        user.setPhone("18976532121");


        int count = session.insert(statement,user);
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
        String statement = "useraaa.updateUser";
        User user= new User();
        user.setId(300);
        user.setName("may");
        user.setAge(20);
        user.setPassword("12345678");
        user.setPhone("18976532121");


        int count = session.update(statement,user);
        System.out.println(count);
        session.commit();
        System.out.println(user);
        session.close();
    }


    @Test(description = "删除记录")
    public void Delete() throws IOException {

        Reader reader =Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reader);

        SqlSession session =sessionFactory.openSession();
        String statement = "useraaa.deleteUserById";

        int count = session.delete(statement,307);
        System.out.println(count);
        session.commit();
        session.close();
    }

}
