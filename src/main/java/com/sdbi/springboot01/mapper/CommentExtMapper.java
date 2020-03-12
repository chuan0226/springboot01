package com.sdbi.springboot01.mapper;

import com.sdbi.springboot01.model.Comment;
import com.sdbi.springboot01.model.Question;

/**
 * @author chuan
 * @date 2020/3/6-16:49
 */
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
