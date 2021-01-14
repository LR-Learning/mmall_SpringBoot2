package com.mmall.dao;

import com.mmall.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into mmall_category (id, parent_id, name,\n" +
            "                                status, sort_order, create_time,\n" +
            "                                update_time)\n" +
            "    values (#{id,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR},\n" +
            "            #{status,jdbcType=BIT}, #{sortOrder,jdbcType=INTEGER}, now(),\n" +
            "    now())")
    int insert(Category record);

    int insertSelective(Category record);

    @Select("select \n" +
            "    *     " +
            "    from mmall_category\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    @Select("select * from mmall_category where parent_id = #{parentId}")
    List<Category> selectCategoryChildrenByParentId(Integer parentId);
}