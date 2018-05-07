package com.filesharesystem.action.file;
/*
 *删除文件
 *@author gh
 *@create 2018-04-11 20:24
 */

import com.filesharesystem.dao.impl.FileCommitDAOImpl;
import com.filesharesystem.dao.impl.FileDAOImpl;
import com.filesharesystem.dao.impl.FileDataDAOImpl;
import com.filesharesystem.models.File;
import com.filesharesystem.models.FileCommit;
import com.filesharesystem.models.FileData;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

//用于用户删除文件
public class DeleteAction extends ActionSupport implements SessionAware{
    private Map<String, Object> session;
    private String fid;
    private String message;

    @Override
    public String execute() throws Exception {
        File file = (File) new FileDAOImpl().getObject(File.class, fid);
        List<FileData> fileData = new FileDataDAOImpl().getFileDateByFID(fid);
        List<FileCommit> fileCommit = new FileCommitDAOImpl().getFileCommitByFID(fid);

//        删除文件扩展数据（浏览、收藏、下载）
        for (FileData one : fileData){
            new FileDataDAOImpl().delete(one);
            System.out.println(one.getFid() + " 文件扩展数据删除成功");
        }
//        删除文件评分以及文件评论
        for (FileCommit one : fileCommit){
            new FileCommitDAOImpl().delete(one);
            System.out.println(one.getFid() + " 文件评分数据删除成功");
        }

        if (file != null){
            new FileDAOImpl().delete(file);
            System.out.println(file.getFileName() + " 删除成功");
        } else {
            message = "抱歉出了点问题，文件ID" + fid + "无法删除";
            System.out.println("抱歉出了点问题，文件无法删除");
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }


    @Override
    public void validate() {
        super.validate();
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
