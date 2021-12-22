package com.caicat.library.pojo;

import java.util.HashMap;
import java.util.Map;
/**
 * 返回消息
 * */
public class Message {
    private Integer status; //300表示成功,400表示失败
    private String message; //操作提示信息
    private Map<String,Object> extend = new HashMap<String,Object>(); //返回的信息

    public static Message success(){
        Message message=new Message();
        message.status=200;
        message.message="成功";
        return message;
    }
    public static Message fail(){
        Message message = new Message();
        message.status=400;
        message.message="失败";
        return message;
    }
    public Message add(String key,Object value){
        this.extend.put(key,value);
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
