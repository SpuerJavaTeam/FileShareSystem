package com.filesharesystem.action.file;

import com.filesharesystem.dao.FileDAO;
import com.filesharesystem.dao.impl.FileDAOImpl;
import com.filesharesystem.models.File;
import com.filesharesystem.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;

public class GetFileAction extends ActionSupport
{

    private static final long serialVersionUID = 8698717426937032941L;
    private List<File> files;

    public List <File> getFiles() {
        return files;
    }

    public void setFiles(List <File> files) {
        this.files = files;
    }

    @Override
    public String execute() throws Exception {
        List<File> files;
        files = new FileDAOImpl ().getFiles ();
        ActionContext.getContext ().put ( "list",files );
        return Action.SUCCESS;
    }
}
