package com.kabasiji.springboot.mapper;

import com.kabasiji.springboot.mode.db.DemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author huang_kangjie
 * @create 2018-09-06 10:46
 **/
@Repository
@Mapper
public interface DemoMapper extends tk.mybatis.mapper.common.Mapper<DemoEntity>, MySqlMapper<DemoEntity> {

}
