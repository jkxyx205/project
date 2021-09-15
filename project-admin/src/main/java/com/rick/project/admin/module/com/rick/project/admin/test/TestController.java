package com.rick.project.admin.module.com.rick.project.admin.test;

import com.rick.common.http.exception.BizException;
import com.rick.common.http.model.Result;
import com.rick.common.http.model.ResultUtils;
import com.rick.common.http.util.MessageUtils;
import com.rick.project.admin.common.ExceptionCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Rick
 * @createdAt 2021-09-15 16:31:00
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("1")
    public Result test1() {
        return ResultUtils.success(MessageUtils.getMessage("MAX_TRY_LOGIN_ERROR", new Object[] {5, 20}));
    }

    @GetMapping("2")
    public Result test2() {
        int a = 1 / 0;
        return ResultUtils.success();
    }

    @GetMapping("3")
    public Result test3() {
        return ResultUtils.fail();
    }

    @GetMapping("4")
    public Result test4() {
        throw new BizException(ExceptionCode.FORMULA_ERROR.result());
    }

    @GetMapping("5")
    public Result test5() {
        throw new BizException(ExceptionCode.BEAN_VALIDATE_ERROR.result(), new Object[] {"姓名不能为空"});
    }
}
