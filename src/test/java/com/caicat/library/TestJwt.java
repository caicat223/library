package com.caicat.library;

import com.caicat.library.pojo.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestJwt {

    @Test
    public void testToken(){
        String sing = JwtUtil.sing();
        System.out.println(sing);

        //解密token   eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2NDAwNjUxNDAsImp0aSI6IjQ3NTJkNzAwLTJlMTktNDQwOC05YTJmLTk1ZjlkNzkzOWU1ZSJ9.t_ACRbysMfveVs0tIa2Y37mfUDq85ecOiZfaWyfFJco
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2NDAwNjUxNDAsImp0aSI6IjQ3NTJkNzAwLTJlMTktNDQwOC05YTJmLTk1ZjlkNzkzOWU1ZSJ9.t_ACRbysMfveVs0tIa2Y37mfUDq85ecOiZfaWyfFJco";
        JwtParser jwtParser= Jwts.parser();
        //JwtUtil是签名,加密时用什么这里就用什么,parseClaimsJws(token)会把token转换成很多的claims集合，里面就是放的载荷部分信息
        Jws<Claims> claimsJws = jwtParser.setSigningKey(JwtUtil.signatrue).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        System.out.println(body.getId()); //获取封装的id
        System.out.println(body.getSubject()); //获取签名
        System.out.println(body.get("username")); //凭key获取载荷里面里面的值
        System.out.println(body.get("role")); //获取用户身份
        System.out.println(body.getExpiration()); //获取有效期
    }
}
