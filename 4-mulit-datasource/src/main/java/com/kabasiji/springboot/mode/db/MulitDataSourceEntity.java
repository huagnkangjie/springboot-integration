package com.kabasiji.springboot.mode.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 测试多数据源
 * @author huang_kangjie
 * @date 2018-12-13 15:56
 * @since 1.0.3
 **/
@Table(name = "test")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "测试实体", description = "测试实体")
public class MulitDataSourceEntity {

     @Id
     @Column(name = "id")
     @ApiModelProperty(value = "id")
     @GeneratedValue(generator = "JDBC")
     private Long id;

     @ApiModelProperty(value = "用户名称")
     @Column(name = "value")
     private String value;

}
