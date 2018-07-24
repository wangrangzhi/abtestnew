package main.mapper;


import main.domain.soldproduct;
import main.domain.soldproductExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
@Service
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

    soldproduct selectPortNotNull();

}