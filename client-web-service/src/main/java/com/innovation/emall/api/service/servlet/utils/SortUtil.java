package com.innovation.emall.api.service.servlet.utils;

import java.util.Collections;
import java.util.List;

public class SortUtil {

    public static List<String> getList(List<String> para) {
        Collections.sort(para);
        return para;
    }
}
