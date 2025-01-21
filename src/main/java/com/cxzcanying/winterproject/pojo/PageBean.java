package com.cxzcanying.winterproject.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 当前页数据列表
     */
    private List rows;

}