package com.sdbi.springboot01.dto;

import lombok.Data;

/**
 * @author chuan
 * @date 2020/3/13-22:41
 */
@Data
public class HotTagDTO implements Comparable{
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
