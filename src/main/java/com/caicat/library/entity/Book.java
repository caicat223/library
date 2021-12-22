package com.caicat.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("图书实体")
public class Book extends Model<Book> {

    @TableId(
            value = "bk_id",
            type = IdType.AUTO
    )
    @ApiModelProperty(name = "图书编号",value = "bkId",example = "0",dataType = "Integer")
    private Integer bkId;

    @ApiModelProperty(name = "图书名称",value = "bkTitle",example = "无名小作~",dataType = "String")
    private String bkTitle;

    @ApiModelProperty(name = "作者",value = "bkAuthor",example = "佚名~",dataType = "String")
    private String bkAuthor;

    @ApiModelProperty(name = "售价",value = "bkPrice",example = "666",dataType = "Double")
    private Double bkPrice;

    @ApiModelProperty(name = "出版社",value = "bkPublisher",example = "1202联合出版社",dataType = "String")
    private String bkPublisher;

    @ApiModelProperty(name = "出版日期",value = "bkPublishDate",example = "2000-01-01",dataType = "Date")
    private Date bkPublishDate;


    @Override
    public String toString() {
        return "Book{" +
                "bkId=" + bkId +
                ", bkTitle='" + bkTitle + '\'' +
                ", bkAuthor='" + bkAuthor + '\'' +
                ", bkPrice=" + bkPrice +
                ", bkPublisher='" + bkPublisher + '\'' +
                ", bkPublishDate=" + bkPublishDate +
                '}';
    }

    public Book() {
    }

    public Book(String bkTitle, String bkAuthor, Double bkPrice, String bkPublisher, Date bkPublishDate) {
        this.bkTitle = bkTitle;
        this.bkAuthor = bkAuthor;
        this.bkPrice = bkPrice;
        this.bkPublisher = bkPublisher;
        this.bkPublishDate = bkPublishDate;
    }

    public Book(Integer bkId, String bkTitle, String bkAuthor, Double bkPrice, String bkPublisher, Date bkPublishDate) {
        this.bkId = bkId;
        this.bkTitle = bkTitle;
        this.bkAuthor = bkAuthor;
        this.bkPrice = bkPrice;
        this.bkPublisher = bkPublisher;
        this.bkPublishDate = bkPublishDate;
    }

    public Integer getBkId() {
        return bkId;
    }

    public void setBkId(Integer bkId) {
        this.bkId = bkId;
    }

    public String getBkTitle() {
        return bkTitle;
    }

    public void setBkTitle(String bkTitle) {
        this.bkTitle = bkTitle;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public Double getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(Double bkPrice) {
        this.bkPrice = bkPrice;
    }

    public String getBkPublisher() {
        return bkPublisher;
    }

    public void setBkPublisher(String bkPublisher) {
        this.bkPublisher = bkPublisher;
    }

    public Date getBkPublishDate() {
        return bkPublishDate;
    }

    public void setBkPublishDate(Date bkPublishDate) {
        this.bkPublishDate = bkPublishDate;
    }
}
