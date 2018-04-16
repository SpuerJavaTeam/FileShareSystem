package com.filesharesystem.action.ip;
/*
 *获取所有用户的登录IP
 *@author gh
 *@create 2018-04-16 15:31
 */

import com.filesharesystem.dao.impl.IPDAOImpl;
import com.filesharesystem.models.IP;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.function.ObjIntConsumer;

public class GetIPList extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private List<Object> ipList;
    private String message;

    @Override
    public String execute() throws Exception {
        return Action.SUCCESS;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
