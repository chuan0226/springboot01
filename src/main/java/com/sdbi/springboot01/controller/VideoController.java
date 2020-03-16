package com.sdbi.springboot01.controller;

import com.sdbi.springboot01.cache.HotTagCache;
import com.sdbi.springboot01.dto.PaginationDTO;
import com.sdbi.springboot01.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author chuan
 * @date 2020/2/25-21:54
 */
@Controller
public class VideoController {

    @GetMapping("/videos")
    public String index(){

        return "videos";
    }
    @GetMapping("/video")
    public String video(@RequestParam(name = "aid") Integer aid,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        Model model){
        model.addAttribute("aid",aid);
        model.addAttribute("page",page);
        return "video";
    }
}
