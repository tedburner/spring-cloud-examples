package com.cloud.api.controller;

import com.cloud.api.service.TestService;
import com.cloud.api.utils.http.NewResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:26
 * @description:
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Value("from")
    private String from;

    @RequestMapping(value = "/test")
    public NewResponseModel test() {
        NewResponseModel responseModel = NewResponseModel.Success();

        responseModel.setData(testService.findUserList());

        return responseModel;
    }
}
