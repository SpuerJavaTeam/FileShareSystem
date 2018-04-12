package com.filesharesystem.dao;

import com.filesharesystem.models.File;
import com.filesharesystem.models.FileData;

import java.util.List;

public interface FileDataDAO extends BaseDAO {
//    基于BaseDao进行实现
//    存在一个用户多次浏览的情况
//    存在一个用户多次下载的情况
//    存在一个用户收藏或者取消收藏的情况(删除数据)
    FileData getFavoriteFileDate(String fid, String uid);

    List<FileData> getFileDateByFID(String fid);
}

