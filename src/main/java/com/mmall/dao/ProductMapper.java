package com.mmall.dao;

import com.mmall.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into mmall_product (id, category_id, name, \n" +
            "      subtitle, main_image, sub_images, \n" +
            "      detail, price, stock, \n" +
            "      status, create_time, update_time\n" +
            "      )\n" +
            "    values (#{id,jdbcType=INTEGER}, #{categoryId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, \n" +
            "      #{subtitle,jdbcType=VARCHAR}, #{mainImage,jdbcType=VARCHAR}, #{subImages,jdbcType=VARCHAR}, \n" +
            "      #{detail,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, #{stock,jdbcType=INTEGER}, \n" +
            "      #{status,jdbcType=INTEGER}, now(), now()\n" +
            "      )")
    int insert(Product record);

    int insertSelective(Product record);

    @Select("select \n" +
            "  *  " +
            "    from mmall_product\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    @Update("update mmall_product\n" +
            "    set category_id = #{categoryId,jdbcType=INTEGER},\n" +
            "      name = #{name,jdbcType=VARCHAR},\n" +
            "      subtitle = #{subtitle,jdbcType=VARCHAR},\n" +
            "      main_image = #{mainImage,jdbcType=VARCHAR},\n" +
            "      sub_images = #{subImages,jdbcType=VARCHAR},\n" +
            "      detail = #{detail,jdbcType=VARCHAR},\n" +
            "      price = #{price,jdbcType=DECIMAL},\n" +
            "      stock = #{stock,jdbcType=INTEGER},\n" +
            "      status = #{status,jdbcType=INTEGER},\n" +
            "      create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      update_time = now()\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    int updateByPrimaryKey(Product record);
}