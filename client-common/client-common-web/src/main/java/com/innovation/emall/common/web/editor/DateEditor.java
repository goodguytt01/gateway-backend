package com.innovation.emall.common.web.editor;

import com.innovation.emall.common.utils.DateHelper;

import java.beans.PropertyEditorSupport;

/**
 * @author zhangxd
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
