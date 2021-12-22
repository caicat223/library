package com.caicat.library.controller;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caicat.library.entity.Book;
import com.caicat.library.pojo.Message;
import com.caicat.library.service.BookService;
import com.caicat.library.service.impl.BookServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookManage")
@Api("书籍管理")
@Slf4j
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/book")
    @ApiOperation(value = "查询全部分页书籍",notes = "查询全部分页书籍")
    @ApiImplicitParam(name = "pn",value = "起始页",required = true,dataType="int")
    public Message selectBook(Integer pn){
        if(pn!=null){
            PageHelper.startPage(pn,5);
            List<Book> bookList=service.getBookAll();
            if(bookList.size()>0){
                PageInfo pageInfo=new PageInfo(bookList,5);
                return new Message().success().add("bookList",pageInfo);
            }else{
                return  new Message().fail().add("msg","查询失败,没有数据");
            }
        }
        return new Message().fail().add("msg","访问错误");
    }

    @GetMapping("/book/{id}")
    @ApiOperation(value = "查询指定数据信息",notes = "传入id,查询指定书籍")
    public Message selectById(@PathVariable("id") Integer id){
        Book book = service.selectBookById(id);
        if(book!=null){
            return Message.success().add("book",book);
        }
        return Message.fail().add("msg","还没有你要找的书籍哟~！");
    }

    @PostMapping("/book")
    @ApiOperation(value = "新增书籍信息",notes = "新增书籍信息")
    public Message insertBook(@RequestBody Book book){
        if(book!=null){
            if(service.insertBook(book)){
                return Message.success();
            }else {
               return Message.fail();
            }
        }else {
            return new Message().fail().add("msg","访问错误");
        }
    }

    @PostMapping("/bookDelById/{id}")
    @ApiOperation(value = "删除书籍",notes = "传id删除书籍")
    public Message deleteBook(@PathVariable("id") Integer id){
        if(id!=null){
            if(service.deleteBook(id)){
                return Message.success();
            }else {
                return Message.fail();
            }
        }else {
            return new Message().fail().add("msg","访问错误");
        }
    }

    @PostMapping("/bookUpdate")
    @ApiOperation(value = "修改书籍",notes = "修改书籍")
    public Message update(@RequestBody Book book){
        if(book!=null){
            if(service.updateBook(book)){
                return Message.success();
            }else {
                return Message.fail();
            }
        }else{
            return new Message().fail().add("msg","访问错误");
        }
    }

    @GetMapping("/getBookAll")
    @ApiOperation(value = "查询全部书籍",notes = "查询全部书籍")
    public Message selectBookAll(){
        List<Book> bookList=service.getBookAll();
        if(bookList.size()>0){
            return new Message().success().add("bookList",bookList);
        }else{
            return  new Message().fail().add("msg","查询失败,没有数据");
        }
    }

    @GetMapping("/selectBookByBody")
    @ApiOperation(value = "条件查询书籍",notes = "条件查询书籍")
    public Message selectBookByBody(@RequestBody Book book){
        return new Message().success().add("bookList",service.selectBookByBody(book));
    }
}
