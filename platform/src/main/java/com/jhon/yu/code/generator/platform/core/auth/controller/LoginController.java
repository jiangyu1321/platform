package com.jhon.yu.code.generator.platform.core.auth.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhon.yu.code.generator.platform.core.auth.dto.LoginDto;
import com.jhonyu.framework.frame.controller.JhonyuBaseController;
import com.jhonyu.framework.frame.dto.JhonyuResponse;
import com.jhonyu.framework.frame.dv.support.DVHelper;
import com.jhonyu.framework.frame.util.ResponseUtil;


@Controller
@RequestMapping("/")
public class LoginController extends JhonyuBaseController
{
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public JhonyuResponse getLoginInfo(HttpServletRequest request,@RequestBody LoginDto loginInfo)
    {
        
        DVHelper.getInstance().valid(loginInfo);
        
        return ResponseUtil.ok("ok");
    }
}
