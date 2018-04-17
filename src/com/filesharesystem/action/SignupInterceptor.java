package com.filesharesystem.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

public class SignupInterceptor implements Interceptor{
    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String,Object> session = actionInvocation.getInvocationContext().getSession();//获取session
        if(session.get("user")!=null)
        {
            return actionInvocation.invoke();//已经登录继续执行
        }else
        {
            return "login";//返回登录页面
        }
    }
}
