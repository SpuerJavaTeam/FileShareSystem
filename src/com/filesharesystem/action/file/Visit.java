package com.filesharesystem.action.file;
/*
 *文件浏览描述
 *@author gh
 *@create 2018-04-12 08:50
 */

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

// TODO: 18.4.12 尽可能尝试通过拦截器方式实现 
public class Visit extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        
        return Action.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
