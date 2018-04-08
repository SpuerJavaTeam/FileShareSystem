package com.filesharesystem.dao;

import com.filesharesystem.models.File;

import java.util.List;

public interface FileDAO extends BaseDAO {
    File getFile(String name);

    List<File> queryByName(String name);
}
