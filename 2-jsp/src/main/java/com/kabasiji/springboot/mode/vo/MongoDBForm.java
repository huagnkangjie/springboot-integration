package com.kabasiji.springboot.mode.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * mongodb 测试实体
 * @author huang_kangjie
 * @create 2018-09-12 14:27
 **/
@Data
public class MongoDBForm implements Serializable {

     private static final long serialVersionUID = 3032163707867382963L;

     private Long id;
     private String userName;
     private String passWord;
     private String email;
     private String nickName;
     private String regTime;
     private String remark;

}
