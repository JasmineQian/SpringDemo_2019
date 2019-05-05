package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookPo;
import com.example.demo.dao.BookRepository;
import com.example.demo.response.ResVoid;
import com.example.demo.response.Response;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {

    @Value("${uid}")
    String uid;

    @Autowired
    private BookRepository bookRepository;


    @ApiOperation(value = "新增书籍信息", notes = "新增书籍信息")
    @ApiImplicitParam(dataType = "BookPo", name = "bookpo", value = "新增书籍信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResVoid save(@RequestBody BookPo bookpo) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String date = sdf.format(dt);
        String bookname = bookpo.getName();
        String bookauthor = bookpo.getAuthor();
        int booknumber = bookpo.getNumber();
        float bookprice = bookpo.getPrice();

        bookRepository.save(new Book(bookname, bookauthor, date, booknumber, bookprice, date, date, uid, uid));
        ResVoid re = new ResVoid();
        re.setCode(200);
        re.setMessage("Success");
        return re;

        //bookRepository.save(new Book("书名11", "作者", "上架时间", 100, 23, "创建时间", "更新时间", "创建uid", "更新uid"));
        //bookRepository.save(new Book("书名12", "作者", "20190504", 100, 23, "20190504", date, "3", "4"));
        //bookRepository.save(new Book("西游记10", "吴承恩", "20190504", 100, 20, "20190504", date, "2", "3"));
    }


    @ApiOperation(value = "根据作者名字或者笔名查找书籍", notes = "根据作者名字或者笔名查找书籍")
    @ApiImplicitParam(dataType = "String", name = "author", value = "根据作者名字或者笔名查找书籍", paramType = "path",required = true)
    @RequestMapping(value = "/findByAuthor/{author}", method = RequestMethod.GET)
    public Response findByAuthor(@PathVariable("author") String author) {
        List<Book> result = bookRepository.findByAuthor(author);
        System.out.println("一共有多少条呢----" + result.size());
        for (Book book : result) {
            System.out.println(book);
        }
        System.out.println("================================");
        Response re = new Response();
        re.setCode(200);
        re.setMessage("Success");
        re.setSize(result.size());
        re.setObject(result);
        return re;
    }

    @ApiOperation(value = "根据书籍名称进行找书", notes = "根据书籍名称进行找书")
    @ApiImplicitParam(dataType = "String", name = "name", value = "根据书籍名称进行找书", paramType = "path",required = true)
    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public Response findByName(@PathVariable String name) {
        List<Book> result = bookRepository.findByName(name);

        Response re = new Response();
        re.setCode(200);
        re.setMessage("Success");
        re.setSize(result.size());
        re.setObject(result);
        return re;
    }


    @ApiOperation(value = "更新书籍信息", notes = "更新书籍信息")
    @ApiImplicitParam(dataType = "Book", name = "book", value = "更新书籍信息", required = true)
    @RequestMapping(value = "/updateBookName", method = RequestMethod.POST)
    public Response updateBookName(@RequestBody Book book) {

        int count = bookRepository.updateBookName("三国演义", 2);
        System.out.println(count);

        List<Book> result = bookRepository.findAll();

        Response re = new Response();
        re.setCode(200);
        re.setMessage("Success");
        re.setSize(result.size());
        re.setObject(result);
        return re;

    }

    @ApiOperation(value = "更新书籍信息", notes = "更新书籍信息")
    @ApiImplicitParam(dataType = "Book", name = "book", value = "更新书籍信息", required = true)
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public Response updateBook(@RequestBody Book book) {

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String date = sdf.format(dt);

        Book book_orignial = bookRepository.findById(book.getId());

        book.setOntime(book_orignial.getOntime());
        book.setCreatuid(book_orignial.getCreatuid());
        book.setCreatedt(book_orignial.getCreatedt());
        book.setUpdatedt(date);
        book.setUpdateuid(uid);

        bookRepository.save(book);

        List<Book> result = bookRepository.findAll();

        Response re = new Response();
        re.setCode(200);
        re.setMessage("Success");
        re.setSize(result.size());
        re.setObject(result);
        return re;

    }
}
