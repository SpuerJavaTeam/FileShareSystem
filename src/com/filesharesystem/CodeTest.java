package com.filesharesystem;

import com.filesharesystem.dao.impl.IPDAOImpl;
import com.filesharesystem.dao.impl.UserDAOImpl;
import com.filesharesystem.models.IP;
import com.filesharesystem.models.User;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CodeTest{

    public static void main(String[] args) {
        System.out.print("This is a test class");
        User user = new UserDAOImpl().checkUser("laisicheng", "123456");
        System.out.println(user.getUid());
        IP ip = new IP();
        Set<User> users = new HashSet<User>(){
            {
                add(user);
            }
        };
        ip.setUid(users);
        ip.setIpv4("127.0.0.1");
        new IPDAOImpl().saveOrUpdate(ip);
        List<IP> ips =  new IPDAOImpl().uidList("127.0.0.1");
        for(IP one :ips){
            System.out.println(one.getUid());
        }
    }
}
