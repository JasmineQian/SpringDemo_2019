package com.example.demo;

import com.example.demo.dao.BookRepository;
import com.example.demo.entity.Customer;
import com.example.demo.dao.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testlength(){
        Customer customer =new Customer("钱金燕","20190504", "20190504", "创建uid", "更新uid");
        customerRepository.save(customer);
        List<Customer> list=customerRepository.findByName("钱金燕");
        for (Customer customer1 : list) {
            System.out.println(customer1);
        }

      /*  Date dt =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss秒" );
        String date =sdf.format(dt);
        String aaa="用户jasqia于时间点2019年03月13日 14:16:28秒增加comments";
        String bbb = "用户admin于2019年03月13日14:18:51秒时间点上增加comments：\n";
        System.out.println(date);
        System.out.println(aaa.length());
        System.out.println(bbb.length());*/
    }

}
