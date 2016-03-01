package com.jhon.yu.code.generator.platform.core.auth.dto;


import com.jhonyu.framework.frame.dv.DataValiRule;


public class LoginDto
{
    @DataValiRule(description = "用户名", nullable = false)
    private String username;

    @DataValiRule(description = "密码", nullable = false)
    private String password;

    public LoginDto()
    {
        // TODO Auto-generated constructor stub
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
