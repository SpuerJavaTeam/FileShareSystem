package com.filesharesystem.action;

import com.filesharesystem.dao.UserDAO;
import com.filesharesystem.dao.UserDataDAO;
import com.filesharesystem.dao.impl.IPDAOImpl;
import com.filesharesystem.dao.impl.UserDAOImpl;
import com.filesharesystem.dao.impl.UserDataDAOImpl;
import com.filesharesystem.models.IP;
import com.filesharesystem.models.User;
import com.filesharesystem.models.UserData;
import com.filesharesystem.utils.DateUtil;
import com.filesharesystem.utils.MD5Util;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

/**
 * 注册
 *
 * @author KuoYu
 * @version 1.0
 * @see User,UserData
 */
public class SignUpAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 8790215995796599624L;
    private Map<String, Object> session = ActionContext.getContext().getSession();// 产生session
    private Integer random = (int)((Math.random()*9+1)*100000);
    private String uid;
    private String username;
    private String password;
    private String email;


    @Override
    public String execute() {
        UserDAO userDAO = new UserDAOImpl();
        String uuid = null;
        if (userDAO.getUserByName(username) == null) {
            return Action.ERROR;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setType ( 1 );
            user.setStatus ( 1 );
            userDAO.save (user);
            session.put("user",user);

            return Action.SUCCESS;
        }

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = session;
    }
}
