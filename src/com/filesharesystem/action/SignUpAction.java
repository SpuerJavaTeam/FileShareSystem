package com.filesharesystem.action;

import com.filesharesystem.dao.UserDAO;
import com.filesharesystem.dao.UserDataDAO;
import com.filesharesystem.dao.impl.UserDAOImpl;
import com.filesharesystem.dao.impl.UserDataDAOImpl;
import com.filesharesystem.models.User;
import com.filesharesystem.models.UserData;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Date;
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
    private Map<String, Object> session;

    private String uid;
    private String username;
    private String password;
    private String email;
    private int gender;
    private int age;
    private Date birthday;
    private String QQ;
    private String phone;

    @Override
    public String execute() {
        UserDAO userDAO = new UserDAOImpl();
        if (userDAO.getUser(username) != null) {
            return Action.ERROR;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            // 不能添加UserData，因为User主键还未生成
            UserDataDAO dataDAO = new UserDataDAOImpl();
            userDAO.save_or_update(user);
//            session.put("user",user); TODO:如何添加session，UUID还未生成
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = session;
    }
}
