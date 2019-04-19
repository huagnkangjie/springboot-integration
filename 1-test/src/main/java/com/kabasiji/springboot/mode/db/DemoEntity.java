package com.kabasiji.springboot.mode.db;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.util.Date;

/**
 * 测试实体类，主要是用于t_demo表的增删改查
 *
 *  hibernate的表单验证
 *
 * @author huang_kangjie
 * @create 2018-08-20 16:28
 **/
@Table(name = "t_demo")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "测试实体", description = "测试实体")
public class DemoEntity {

     @Id
     @Column(name = "id")
     @ApiModelProperty(value = "id")
     private Long id;

     @NotEmpty(message = "{NotEmpty.name}")
     @ApiModelProperty(value = "用户名称")
     @Column(name = "name")
     private String name;

     @ApiModelProperty(value = "用户年龄")
     @Column(name = "age")
     @Max(value = 99, message = "{Max.age}")
     private Long age;

     @ApiModelProperty(value = "用户性别")
     @Column(name = "sex")
     private Integer sex;

     @ApiModelProperty(value = "例子")
     @Column(name = "demo")
     @Length(max = 5,message = "{Length.demo}")
     private String demo;

     @ApiModelProperty(value = "创建时间")
     @JsonProperty(value = "create_time")
     @Column(name = "create_time")
     //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     private Date createTime;

}
