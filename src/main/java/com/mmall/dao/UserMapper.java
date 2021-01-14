package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
@MapperScan("src/main/resources/mappers/*.xml")
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into mmall_user (id, username, password, \n" +
            "      email, phone, question, \n" +
            "      answer, role, create_time, \n" +
            "      update_time)\n" +
            "    values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, \n" +
            "      #{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{question,jdbcType=VARCHAR}, \n" +
            "      #{answer,jdbcType=VARCHAR}, #{role,jdbcType=INTEGER}, now(), now())")
    int insert(User record);

    int insertSelective(User record);

    @Select("select * from mmall_user where id = #{id}")
    User selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select count(1) from mmall_user where username = #{username}")
    int checkUsername(String username);

    @Select("select * from mmall_user where username = #{username} and password = #{password}")
    User selectLogin( String username, String password);

    @Select("select count(1) from mmall_user where email = #{email}")
    int checkEmail(String email);

    @Select("select question from mmall_user where username = #{username}")
    String selectQuestionByUsername(String username);

    @Select("select count(1) from mmall_user where username = #{username} and question = #{question} and answer = #{answer}")
    int checkAnswer( String username,  String question,  String answer);

    @Update("update mmall_user SET password = #{password}, update_time = now() where username = #{username}")
    int updatePasswordByUsername(String username, String password);

    @Select("select count(1) from mmall_user where id = #{userId} and password = #{password}")
    int checkPassword( String password, Integer userId);

    @Select("select count(1) from mmall_user where email = #{email} and id != #{userId}")
    int checkEmailByUserId( String email,  Integer userId);
}