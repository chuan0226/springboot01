package com.sdbi.springboot01.mapper;

import com.sdbi.springboot01.dto.QuestionQueryDTO;
import com.sdbi.springboot01.model.Question;
import com.sdbi.springboot01.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}