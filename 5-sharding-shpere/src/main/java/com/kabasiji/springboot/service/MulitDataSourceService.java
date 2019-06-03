package com.kabasiji.springboot.service;

import com.kabasiji.springboot.common.mulitdatasource.annotation.ReadOnlyConnection;
import com.kabasiji.springboot.mapper.MulitDataSourceMapper;
import com.kabasiji.springboot.mode.db.MulitDataSourceEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huang_kangjie
 * @date 2018-12-13 16:01
 * @since 1.0.3
 **/
@Service
@Log4j2
public class MulitDataSourceService {

     private final MulitDataSourceMapper mulitDataSourceMapper;

     @Autowired
     public MulitDataSourceService(MulitDataSourceMapper mulitDataSourceMapper) {
          this.mulitDataSourceMapper = mulitDataSourceMapper;
     }

     /**
      * 测试数据源1
      * @return
      */
     @ReadOnlyConnection
     public List<MulitDataSourceEntity> testData1() {
          log.debug(">>>>>>>>>>>>>>>>>>>测试数据源   test");
          Example example = new Example(MulitDataSourceEntity.class);
          return this.mulitDataSourceMapper.selectByExample(example);
     }

     /**
      * 测试数据源2
      * @return
      */
     public List<MulitDataSourceEntity> testData2() {
          log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>测试数据源    biz");
          Example example = new Example(MulitDataSourceEntity.class);
          return this.mulitDataSourceMapper.selectByExample(example);
     }
}
