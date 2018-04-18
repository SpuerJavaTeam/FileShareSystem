package com.filesharesystem.action.user;
/*
 *用户修改密码
 *@author gh
 *@create 2018-04-12 10:40
 */

import com.filesharesystem.dao.impl.UserDAOImpl;
import com.filesharesystem.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ChangeAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private String message;
    private String password;
    private String email;

    @Override
    public void validate() {
        if (password == null || password.equals("") || password.trim().equals("")){
            this.addFieldError("password","密码不能为空");
        }
        if (email == null || email.equals("") || email.trim().equals("")){
            this.addFieldError("email", "密保邮箱不能为空");
        }
    }

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        user.setPassword(password);
        user.setEmail(email);
        new UserDAOImpl().saveOrUpdate(user);
        return Action.SUCCESS;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
