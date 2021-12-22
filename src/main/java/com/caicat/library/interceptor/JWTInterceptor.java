package com.caicat.library.interceptor;
import com.alibaba.fastjson.JSON;
import com.caicat.library.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!StringUtils.isBlank(token)){
            boolean result = JwtUtil.verify(token);
            if (result){
                return true;
            }
        }

        response.setContentType("application/json; charset=utf-8");
        Map<String, Object> map = new HashMap<>();
        map.put("code", 401);
        map.put("message", "token错误");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(JSON.toJSON(map));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
