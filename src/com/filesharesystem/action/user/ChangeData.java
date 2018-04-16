package com.filesharesystem.action.user;
/*
 *修改预留资料
 *@author gh
 *@create 2018-04-12 10:41
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ChangeData extends ActionSupport implements SessionAware{
    private Map<String, Object> session;


    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }
}
