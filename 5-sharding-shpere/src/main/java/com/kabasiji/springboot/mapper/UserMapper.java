package com.kabasiji.springboot.mapper;

import com.kabasiji.springboot.mode.db.UserEntity;
import com.kabasiji.springboot.mode.db.UserOtherEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author xuliduo
 * @date 16/03/2018
 * @description interface UserMapper
 */
@Repository
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<UserEntity>,MySqlMapper<UserEntity> {
    @Insert({
            "<script>",
            "insert into t_user (",
            "<if test='userId !=null' > user_id, </if> ",
            "name, ",
            "password, phone, ",
            "gender, age, birthday, ",
            "last_change_user, create_time, ",
            "update_time)",
            "values (",
            "<if test='userId !=null' > #{userId,jdbcType=BIGINT}, </if> ",
            "#{name,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
            "#{gender,jdbcType=BIT}, #{age,jdbcType=BIT}, #{birthday,jdbcType=VARCHAR}, ",
            "#{lastChangeUser,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP})",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
        // @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyColumn = "user_id", keyProperty = "userId", before = false, resultType = Long.class)
    int insert(UserEntity userEntity);

    @Select({"SELECT t1.user_id AS userId,",
            "alias",
            "FROM t_user_other t1 JOIN t_user t2 ON t1.user_id = t2.user_id ",
            "WHERE t2.name = #{name,jdbcType=VARCHAR} ",
            "ORDER BY t1.user_id DESC"
    })
    List<UserOtherEntity> findAliasByName(@Param(value = "name") String name);

    @Select({"SELECT count(1) FROM t_user"})
    long count();
}
