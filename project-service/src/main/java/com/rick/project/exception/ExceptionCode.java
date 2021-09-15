package com.rick.project.exception;

import com.rick.common.http.model.ExceptionResult;
import com.rick.common.http.model.ResultUtils;
import lombok.Getter;
import lombok.ToString;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @author: Rick.Xu
 * @date: 9/10/19 2:03 PM
 * @Copyright: 2019 www.yodean.com. All rights reserved.
 */
@Getter
@ToString
public enum ExceptionCode {
    REQUEST_PARAM_ERROR(30001, "用户姓名超过5个字符");

    private int code;

    private String msg;

    ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ExceptionResult<String> result() {
        return ResultUtils.exception(getCode(), getMsg());
    }
}
