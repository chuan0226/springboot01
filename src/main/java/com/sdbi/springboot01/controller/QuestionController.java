package com.sdbi.springboot01.controller;

import com.sdbi.springboot01.dto.CommentDTO;
import com.sdbi.springboot01.dto.QuestionDTO;
import com.sdbi.springboot01.enums.CommentTypeEnum;
import com.sdbi.springboot01.service.CommentService;
import com.sdbi.springboot01.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author chuan
 * @date 2020/3/2-14:12
 */
@Controller
public class QuestionController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        List<QuestionDTO> relateQuestions= questionService.selectRelated(questionDTO);
        List<CommentDTO> comments=commentService.listByTargetId(id, CommentTypeEnum.QUESTION);

        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        model.addAttribute("relatedQuestions",relateQuestions);
        return "question";
    }
}
