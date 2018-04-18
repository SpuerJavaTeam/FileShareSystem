package com.filesharesystem.dao;

import com.filesharesystem.models.File;

import java.util.List;

public interface FileDAO extends BaseDAO {
//    获取所有用户的文件列表
    List<File> getFiles();

//    通过用户ID获取文件列表
    List<File> getFileById(String uid);

    File getFileByFid(String fid);
}
