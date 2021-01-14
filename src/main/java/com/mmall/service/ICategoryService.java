package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 10:41 2021/1/14
 * @Modified By:
 **/
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse getChildrenParallelCategory(Integer categoryId);

    ServerResponse selectCategortyAndChildrenById(Integer categoryId);
}
