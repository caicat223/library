package com.caicat.library.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String SING="YUFDFG!DH@!FH!";
    private static long EXPIRE_TIME=1000*60*60*24*7;
    //private static long EXPIRE_TIME=1000*20;

    /**
     * @param map ：传入的playload载荷参数,有效的数据
     * @return token : 生成的token
     * */
    public static String getToken(Map<String,String> map){
/*        JwtBuilder jwtBuilder= Jwts.builder();
        //Algorithm algorithm = Algorithm.HMAC256(SING);
        String token=jwtBuilder.setHeaderParam("typ","JWT")    //定义数据类型
                .setHeaderParam("alg","HS256")  //加密方式
                .setClaims(map)
                .setSubject("admin-test") //自定义签名
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))  //token有效期是当前系统时间到自定义的时间
                .setId(UUID.randomUUID().toString())  //设置id
                .signWith(SignatureAlgorithm.HS256,SING) //signatrue加密
                .compact();  //使用compact连接
        return token;*/

        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(SING);
        //设置头部信息
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        JWTCreator.Builder builder = JWT.create();
        for(String obj : map.keySet()){
            builder.withClaim(obj,map.get(obj));
        }
        // 附带用户信息
        return builder.withHeader(header)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 获取登陆用户ID
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("bk_id").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 验证token
     * */
    public static boolean verify(String token){
     /*   //解密token
        JwtParser jwtParser= Jwts.parser();
        //JwtUtil是签名,加密时用什么这里就用什么,parseClaimsJws(token)会把token转换成很多的claims集合，里面就是放的载荷部分信息
        Jws<Claims> claimsJws = jwtParser.setSigningKey(com.caicat.library.pojo.JwtUtil.signatrue).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return false;*/
        try {
            Algorithm algorithm = Algorithm.HMAC256(SING);  //根据秘钥解析token
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt =  verifier.verify(token);
            System.out.println("没异常");
            return true;
        } catch (Exception exception) {
            System.out.println("有异常");
            exception.printStackTrace();
            return false;
        }
    }
}
