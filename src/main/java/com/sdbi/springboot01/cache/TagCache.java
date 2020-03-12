package com.sdbi.springboot01.cache;

import com.sdbi.springboot01.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chuan
 * @date 2020/3/7-1:09
 */
public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program =new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","php","html","java","python"));
        tagDTOS.add(program);
        TagDTO framework=new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("spring","express","django"));
        tagDTOS.add(framework);
        TagDTO server=new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","windows"));
        tagDTOS.add(server);
        return tagDTOS;
    }
    public static String filterInvalid(String tags){
        String[] split= StringUtils.split(tags,"，");
        List<TagDTO> tagDTOS=get();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining("，"));
        return invalid;

    }
}
