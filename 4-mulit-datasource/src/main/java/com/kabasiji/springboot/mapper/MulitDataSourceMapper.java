package com.kabasiji.springboot.mapper;

import com.kabasiji.springboot.mode.db.MulitDataSourceEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author huang_kangjie
 * @create 2018-09-06 10:46
 **/
@Repository
public interface MulitDataSourceMapper extends Mapper<MulitDataSourceEntity> {

}
