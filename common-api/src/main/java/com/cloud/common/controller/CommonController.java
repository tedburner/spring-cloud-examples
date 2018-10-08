package com.cloud.common.controller;

import com.cloud.common.service.UserService;
import com.cloud.common.utils.http.NewResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/8 16:20
 * @description:
 */
@RestController
public class CommonController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById")
    public NewResponseModel getUserById(@RequestParam("id") Long id) {
        NewResponseModel responseModel = NewResponseModel.Success();
        responseModel.setData(userService.findUserById(id));
        return responseModel;
    }
}
