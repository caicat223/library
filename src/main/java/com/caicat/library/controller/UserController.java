package com.caicat.library.controller;

import com.caicat.library.entity.User;
import com.caicat.library.pojo.Message;
import com.caicat.library.service.UserService;
import com.caicat.library.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    //@GetMapping("/login")
    public Message login(HttpServletRequest request,String uName){
        request.getSession().setAttribute("username",uName);
        return Message.success();
    }

    @GetMapping("/login")
    public Message userLogin(@RequestBody User user){
        log.info("用户名：[{}]",user.getUName());
        log.info("密码：[{}]",user.getUPassword());
        Message message=new Message();
        Map<String,String> map=new HashMap<String,String>();
        try {
            User login = service.Login(user);
            if(login!=null){
                map.put("bk_id",user.getUId()+"");
                return  message.success().add("msg","登录成功").add("token",JwtUtil.getToken(map));
            }else{
                return  message.fail().add("msg","登录失败");
            }
        }catch(Exception e){
            return message.fail().add("msg",e.getMessage());
        }
    }

    @GetMapping("/user")
    public Message selUser(@RequestHeader String token){
        System.out.println(token);
        if(JwtUtil.verify(token)){
            System.out.println(JwtUtil.getUserId(token)+"###########我的id是.........");
            return Message.success().add("bk_id",JwtUtil.getUserId(token));
        }
        return Message.fail().add("msg","token错误");
    }
}
