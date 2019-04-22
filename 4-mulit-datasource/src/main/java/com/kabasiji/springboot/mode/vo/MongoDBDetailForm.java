package com.kabasiji.springboot.mode.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huang_kangjie
 * @create 2018-09-12 17:13
 **/
@Data
public class MongoDBDetailForm implements Serializable {

     private static final long serialVersionUID = -3884750906073228005L;

     private String detailId;

     private String description;

}
