package com.filesharesystem.action;

import com.filesharesystem.dao.FileDAO;
import com.filesharesystem.dao.FileDataDAO;
import com.filesharesystem.dao.impl.FileDAOImpl;
import com.filesharesystem.dao.impl.FileDataDAOImpl;
import com.filesharesystem.models.File;
import com.filesharesystem.models.FileData;
import com.filesharesystem.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * 上传文件，涉及User/File/FileData
 *
 * @author KuoYu
 * @version 1.0
 * @see User
 * @see File,FileData
 */
public class CommitFileAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 8698717742693703294L;
    private Map<String, Object> session;

    private User uid;
    private String fileName;
    private String fileType;
    private User authorId;
    private User visitorId;
    private File fid;

    @Override
    public String execute() {
        User user = (User) session.get("user");
        File file = new File();
        file.setFileName(fileName);
        file.setUid(user);
        file.setFileType(fileType);
        FileData fileData = new FileData();
        fileData.setAuthorId(user);
        fileData.setVisitorId(user);
        fileData.setFid(file);
        FileDAO fileDAO = new FileDAOImpl();
        FileDataDAO dataDAO = new FileDataDAOImpl();
        if (file != null && user.getStatus() != 3) {
            fileDAO.save_or_update(file);
            dataDAO.save_or_update(fileData);
            return Action.SUCCESS;
        } else {
            addActionError("文件为空/用户已被禁止活动");
            return Action.ERROR;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public User getAuthorId() {
        return authorId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    public User getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(User visitorId) {
        this.visitorId = visitorId;
    }

    public File getFid() {
        return fid;
    }

    public void setFid(File fid) {
        this.fid = fid;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
