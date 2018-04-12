package com.filesharesystem.action.file;
/*
 *文件取消收藏
 *@author gh
 *@create 2018-04-11 20:10
 */

import com.filesharesystem.dao.FileDataDAO;
import com.filesharesystem.dao.impl.FileCommitDAOImpl;
import com.filesharesystem.dao.impl.FileDAOImpl;
import com.filesharesystem.dao.impl.FileDataDAOImpl;
import com.filesharesystem.models.File;
import com.filesharesystem.models.FileCommit;
import com.filesharesystem.models.FileData;
import com.filesharesystem.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class FavoritesCancel extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private String fid;
    private String message;

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        File file = (File) new FileDAOImpl().getObject(File.class, fid);
        // TODO: 18.4.11 通过fid会获取到所有含有这个fid的文件收藏列表
        FileData fileData = new FileDataDAOImpl().getFavoriteFileDate(fid, user.getUid());
        if (user == null) {
            message = "出了点问题，您可能没有权限取消收藏";
            return Action.ERROR;
        }
        if (file == null) {
            message = "出了点问题，无法获取文件信息";
            return Action.ERROR;
        }
        new FileDataDAOImpl().delete(fileData);
        return Action.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
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
