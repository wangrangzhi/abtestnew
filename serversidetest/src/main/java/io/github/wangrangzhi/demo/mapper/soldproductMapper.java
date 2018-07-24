package io.github.wangrangzhi.demo.mapper;

import io.github.wangrangzhi.demo.domain.soldproduct;
import io.github.wangrangzhi.demo.domain.soldproductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface soldproductMapper {
    int countByExample(soldproductExample example);

    int deleteByExample(soldproductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(soldproduct record);

    int insertSelective(soldproduct record);

    List<soldproduct> selectByExample(soldproductExample example);

    soldproduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") soldproduct record, @Param("example") soldproductExample example);

    int updateByExample(@Param("record") soldproduct record, @Param("example") soldproductExample example);

    int updateByPrimaryKeySelective(soldproduct record);

    int updateByPrimaryKey(soldproduct record);
}