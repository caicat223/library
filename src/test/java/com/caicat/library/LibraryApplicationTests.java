package com.caicat.library;

import com.caicat.library.entity.Book;
import com.caicat.library.pojo.Message;
import com.caicat.library.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class LibraryApplicationTests {

    @Autowired
    private BookService service;

    @Test
    public void insertBook() {
        for (int i=0;i<250;i++){
            String name= UUID.randomUUID().toString().substring(0,5)+i;
            service.insertBook(new Book("三国演义"+name,"罗贯中"+name,79.9,"1202联合出版社",new Date()));
            service.insertBook(new Book("红楼梦"+name,"曹雪芹"+name,89.9,"1202联合出版社",new Date()));
            service.insertBook(new Book("西游记"+name,"吴承恩"+name,99.9,"1202联合出版社",new Date()));
            service.insertBook(new Book("水浒传"+name,"施耐庵"+name,79.9,"1202联合出版社",new Date()));
       }
    }

    @Test
    public void testSel(){
            PageHelper.startPage(2,5);
            List<Book> bookList=service.getBookAll();
            System.out.println(bookList.size()+"##############");
            if(bookList.size()>0){
                PageInfo pageInfo=new PageInfo(bookList,5);
                System.out.println( new Message().success().add("bookList",pageInfo));
            }else{
                System.out.println(new Message().fail().add("msg","查询失败,没有数据"));
            }

    }

    @Test
    public void testDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
    }

}
