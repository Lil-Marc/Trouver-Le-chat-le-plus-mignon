package com.cat.dao;

import com.cat.dataobject.CatDO;
import com.cat.service.model.CatModel;

import java.util.List;

public interface CatDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated Tue Jan 04 14:55:04 CET 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated Tue Jan 04 14:55:04 CET 2022
     */
    int insert(CatDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated Tue Jan 04 14:55:04 CET 2022
     */
    int insertSelective(CatDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated Tue Jan 04 14:55:04 CET 2022
     */
    CatDO selectByPrimaryKey(String id);

    CatDO getMostPopularCat();

    //find all cats and return it to front-end
    List<CatDO> findAllCats();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated Tue Jan 04 14:55:04 CET 2022
     */
    int updateByPrimaryKeySelective(CatDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cat
     *
     * @mbggenerated Tue Jan 04 14:55:04 CET 2022
     */
    int updateByPrimaryKey(CatDO record);

    int voteCat(String id);

    void selectByPrimaryKey();
}