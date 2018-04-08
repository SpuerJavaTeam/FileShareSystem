package com.filesharesystem.action;

import com.filesharesystem.dao.UserDAO;
import com.filesharesystem.dao.UserDataDAO;
import com.filesharesystem.dao.impl.UserDAOImpl;
import com.filesharesystem.dao.impl.UserDataDAOImpl;
import com.filesharesystem.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * 登陆
 *
 * @author KuoYu
 * @version 1.0
 * @see User
 */
public class SignInAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 3651532609841503307L;
    private UserDAO dao = new UserDAOImpl();
    private String username;
    private String password;
    private Map<String, Object> session;

    public String execute() {
        User user = dao.getUser(username);
        if (user != null && user.getPassword() == password) {
            session.put("user", user);
            return Action.SUCCESS;
        } else {
            addActionError("无权限");
            return INPUT;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Object> getSession() {
        return session;
    }

}
