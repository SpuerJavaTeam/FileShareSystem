package hibernate.IP;

import hibernate.User.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class IP {
    private int id;
    private UUID uid;
    private String ipv4;
    private Date created_at;
    private Date updated_at;
//    private Set<User> userSet = new HashSet<User>();

    public IP() {
        // pass
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public UUID getUid() {
        return uid;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
