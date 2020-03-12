package com.sdbi.springboot01.controller;

import com.sdbi.springboot01.dto.NotificationDTO;
import com.sdbi.springboot01.dto.PaginationDTO;
import com.sdbi.springboot01.enums.NotificationTypeEnum;
import com.sdbi.springboot01.model.User;
import com.sdbi.springboot01.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chuan
 * @date 2020/3/8-23:56
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(@PathVariable(name="id") Long id,
                          HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            return "redirect:/";
        }

        NotificationDTO notificationDTO = notificationService.read(id, user);
        if (NotificationTypeEnum.REOLY_COMMENT.getType() == notificationDTO.getType()
                || NotificationTypeEnum.REOLY_QUESTION.getType() == notificationDTO.getType()) {
            return "redirect:/question/" + notificationDTO.getOuterid();
        }else{
            return "redirect:/";
        }
    }
}
