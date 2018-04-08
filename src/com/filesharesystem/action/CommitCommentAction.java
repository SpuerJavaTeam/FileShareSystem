package com.filesharesystem.action;

import com.filesharesystem.models.User;
import com.filesharesystem.models.File;
import com.filesharesystem.models.FileData;
import com.filesharesystem.models.FileCommit;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * 提交文件评论，涉及User/File/FileData/FileCommit
 *
 * @author KuoYu
 * @version 1.0
 * @see User
 * @see File,FileData,FileCommit
 */
public class CommitCommentAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1271467894101374431L;
    private Map<String, Object> session;

    @Override
    public String execute() {
        User user = (User) session.get("user");
        //TODO: 找到文件cookies提交
        return Action.ERROR;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
