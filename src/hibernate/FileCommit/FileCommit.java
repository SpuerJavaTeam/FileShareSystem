package hibernate.FileCommit;

import hibernate.File.File;
import hibernate.User.User;

public class FileCommit {
    private String id;
    private User authorId;
    private User visitorId;
    private File fid;
    private int level;
    private String commit;
    private String created_at;
    private String updated_at;
    public FileCommit() {
        // pass
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
