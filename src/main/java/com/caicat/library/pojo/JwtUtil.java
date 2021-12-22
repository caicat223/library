package com.caicat.library.pojo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    private static final long EXPIRE_TIME=1000*60*60*24*10;  //毫秒开始的失效时间

    public static String signatrue="admin";

    public static String sing(){
        JwtBuilder jwtBuilder= Jwts.builder();
        String token=jwtBuilder.setHeaderParam("typ","JWT")    //定义数据类型
                               .setHeaderParam("alg","HS256")  //加密方式
                               .claim("username","tom")  //PlayLoad载荷，里面声明的用户名
                               .claim("role","admin")   //PlayLoad载荷，里面声明的用户身份
                               .setSubject("admin-test") //自定义签名
                               .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))  //token有效期是当前系统时间到自定义的时间
                                .setId(UUID.randomUUID().toString())  //设置id
                                .signWith(SignatureAlgorithm.HS256,signatrue) //signatrue加密
                                .compact();  //使用compact连接
        return token;
    }
}
