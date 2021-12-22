package com.caicat.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data                   //同时拥有了get/set,toString,hashCode,特定参数构造器
@AllArgsConstructor    //有全部字段的有参构造
@NoArgsConstructor     //无参构造
public class User extends Model<User> {

    @TableId(
        value = "u_id",
        type = IdType.AUTO
    )
    private Integer uId;
    //MybatisPlus默认支持的驼峰映射,数据库设计用下划线,实体用大写
    private String uName;
    private String uPassword;
    private Integer role;
}
