package com.cloud.api.controller;

import com.cloud.api.utils.http.NewResponseModel;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/15 10:26
 * @description:
 */
@RestController
public class TestController {

    public NewResponseModel test(){
        NewResponseModel responseModel = NewResponseModel.Success();

        return responseModel;
    }
}
