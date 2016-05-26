package dao;

import java.util.List;
import model.SubjectType;
import model.SubjectTypeExample;
import org.apache.ibatis.annotations.Param;

public interface SubjectTypeMapper {
    int countByExample(SubjectTypeExample example);

    int deleteByExample(SubjectTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubjectType record);

    int insertSelective(SubjectType record);

    List<SubjectType> selectByExample(SubjectTypeExample example);

    SubjectType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubjectType record, @Param("example") SubjectTypeExample example);

    int updateByExample(@Param("record") SubjectType record, @Param("example") SubjectTypeExample example);

    int updateByPrimaryKeySelective(SubjectType record);

    int updateByPrimaryKey(SubjectType record);
}