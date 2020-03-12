package com.sdbi.springboot01.controller;

import com.sdbi.springboot01.dto.AccessTokenDTO;
import com.sdbi.springboot01.dto.GithubUser;
import com.sdbi.springboot01.mapper.UserMapper;
import com.sdbi.springboot01.model.User;
import com.sdbi.springboot01.provider.GithbubProvider;
import com.sdbi.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author chuan
 * @date 2020/2/25-22:49
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithbubProvider githbubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githbubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githbubProvider.getUser(accessToken);
        if (githubUser!=null){
            User user=new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountid(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatar_url());
//            user.setGmtCreate(System.currentTimeMillis());
//            user.setGmtModified(user.getGmtCreate());
//            userMapper.insert(user);
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token",token));

            return "redirect:/";


        }else{
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie=new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
