package com.filesharesystem.action;

import com.filesharesystem.dao.UserDAO;
import com.filesharesystem.dao.impl.IPDAOImpl;
import com.filesharesystem.dao.impl.UserDAOImpl;
import com.filesharesystem.models.IP;
import com.filesharesystem.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashSet;
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

    @Override
    public void validate() {
        if(this.username == null || this.username.equals("") || this.username.trim().equals("")){
            this.addFieldError("username", "用户名不能为空");
        }
        if(this.password == null || this.password.equals("") || this.password.trim().equals("")){
            this.addFieldError("password","用户密码不能为空");
        }
    }

    public String execute() {
        IP ip = new IP();
        User user = dao.checkUser(username, password);
        if (user != null) {
            session.put("user", user);
            ip.setUid(new HashSet<User>(){{add(user);}});
            // TODO: 18.4.16 获取ip
            ip.setIpv4("127.0.0.1");
            new IPDAOImpl().saveOrUpdate(ip);
            if ( user.getType() == 0 ) {
                return "ADMIN";
            } else {
                return "USER";
            }
        } else {
            addActionError("用户未登陆");
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
