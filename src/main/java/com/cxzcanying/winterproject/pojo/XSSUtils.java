package com.cxzcanying.winterproject.pojo;

import org.springframework.web.util.HtmlUtils;

public class XSSUtils {
    public static String escapeHtml(String input) {
        return HtmlUtils.htmlEscape(input);
    }
}