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

public class TestMyBatis {

    @Test(description = "通过InputStream读取配置config文件")
    public void TestInputStream() throws IOException {

        String resource = "config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session =sessionFactory.openSession();
        String statement = "useraaa.selectById";


        User user = session.selectOne(statement,300);
        System.out.println(user);
        session.close();


    }

    @Test(description = "通过Reader读取配置config文件")
    public void Reader() throws IOException {

        Reader reader =Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reader);

        SqlSession session =sessionFactory.openSession();
        String statement = "useraaa.selectById";
        User user = session.selectOne(statement,300);
        System.out.println(user);
        session.close();
    }

    @Test(description = "读取所有的对象")
    public void selectAll() throws IOException {

        Reader reader =Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reader);

        SqlSession session =sessionFactory.openSession();
        String statement = "useraaa.selectAll";

        List<User> user = session.selectList(statement);
        System.out.println(user);
        session.close();
    }

}
