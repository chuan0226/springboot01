package com.sdbi.springboot01.controller;

import com.sdbi.springboot01.cache.HotTagCache;
import com.sdbi.springboot01.dto.PaginationDTO;
import com.sdbi.springboot01.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author chuan
 * @date 2020/2/25-21:54
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private HotTagCache hotTagCache;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size,
                        @RequestParam(name = "search",required = false) String search,
                        @RequestParam(name = "tag",required = false) String tag){

        PaginationDTO pagination= questionService.list(search,tag,page,size);
        List<String> tags = hotTagCache.getHots();
        model.addAttribute("pagination",pagination);
        model.addAttribute("search", search);
        model.addAttribute("tags", tags);
        model.addAttribute("tag", tag);
        return "index";
    }
}
