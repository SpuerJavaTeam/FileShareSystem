package com.filesharesystem.action.file;
/*
 *文件收藏
 *@author gh
 *@create 2018-04-11 19:50
 */

import com.filesharesystem.dao.impl.FileDataDAOImpl;
import com.filesharesystem.models.File;
import com.filesharesystem.models.FileData;
import com.filesharesystem.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

//用于用户添加收藏
public class Favorites extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private String fid;
    private String message;

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        File file = (File) new FileDataDAOImpl().getObject(File.class, fid);
        FileDataDAOImpl fileDataDAO = new FileDataDAOImpl();
        if (user == null) {
            message = "抱歉，用户没有访问权限。";
            return Action.ERROR;
        }
        if (file == null) {
            message = "抱歉，文件无法收藏。";
            return Action.ERROR;
        }
        FileData fileData = new FileData();
        fileData.setVisitorId(user);
        fileData.setFid(file);
        fileData.setType(2);
        fileDataDAO.saveOrUpdate(fileData);
        return Action.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = session;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFid() {
        return fid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
